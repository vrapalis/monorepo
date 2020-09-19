import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { JanusService } from '../../janus.service';
import { IJanusPlugin } from '../../janus';
import { Observable, of } from 'rxjs';
import { IVideoRoom } from './video-room';
import { isPlatformBrowser } from '@angular/common';

@Injectable()
export class VideoRoomService {
  plugin: IJanusPlugin = null;

  constructor(private janusService: JanusService,
              @Inject(PLATFORM_ID) private platformId: any) {
  }

  init(): Observable<IJanusPlugin> {
    return new Observable<IJanusPlugin>(subscriber => {
      this.janusService.init().subscribe(() => {
        this.janusService.createSession().subscribe((session) => {
          if (isPlatformBrowser(this.platformId)) {
            if (this.plugin === null) {
              try {
                session.attach(
                  {
                    plugin: 'janus.plugin.videoroom',
                    success: (pluginHandle) => {
                      // Plugin attached! 'pluginHandle' is our handle
                      this.plugin = pluginHandle;
                      subscriber.next(this.plugin);
                      subscriber.complete();
                    },
                    error: function(cause) {
                      // Couldn't attach to the plugin
                      subscriber.error(cause);
                      subscriber.complete();
                    },
                    consentDialog: function(on) {
                      // e.g., Darken the screen if on=true (getUserMedia incoming), restore it otherwise
                    },
                    onmessage: function(msg, jsep) {
                      // We got a message/event (msg) from the plugin
                      // If jsep is not null, this involves a WebRTC negotiation
                      console.log('hallo ollah');
                    },
                    onlocalstream: function(stream) {
                      // We have a local stream (getUserMedia worked!) to display
                    },
                    onremotestream: function(stream) {
                      // We have a remote stream (working PeerConnection!) to display
                    },
                    oncleanup: function() {
                      // PeerConnection with the plugin closed, clean the UI
                      // The plugin handle is still valid so we can create a new one
                    },
                    detached: function() {
                      // Connection with the plugin closed, get rid of its features
                      // The plugin handle is not valid anymore
                    }
                  });
              } catch (e) {
                subscriber.error(e);
                subscriber.complete();
              }
            } else {
              subscriber.next(this.plugin);
              subscriber.complete();
            }
          }
        });
      });
    });
  }

  getRooms(): Observable<Array<IVideoRoom>> {
    return new Observable<Array<IVideoRoom>>(subscriber => {
      try {
        this.plugin.send({
          'message': { 'request': 'list' }, 'success': (result) => {
            subscriber.next(result.list);
            subscriber.complete();
          }
        });
      } catch (e) {
        subscriber.error(e);
        subscriber.complete();
      }
    });
  }

  createRoom(description: string): Observable<number> {
    return new Observable<number>(subscriber => {
      try {
        this.plugin.send({
          'message': { 'request': 'create', 'description': description }, 'success': (response) => {
            subscriber.next(response.room);
            subscriber.complete();
          }
        });
      } catch (e) {
        subscriber.error(e);
        subscriber.complete();
      }
    });
  }

  join(roomId: number):Observable<any> {

  }
}
