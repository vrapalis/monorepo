import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Janus } from 'janus-gateway';
import { isPlatformBrowser } from '@angular/common';
import { Observable, of } from 'rxjs';
import { filter, flatMap } from 'rxjs/operators';
import { JanusJS } from 'janus-gateway/npm';

@Injectable()
export class JanusService {
  janus: JanusJS.Janus = null;

  constructor(@Inject(PLATFORM_ID) private platformId: any) {
  }

  public init(successCallback?: Function): Observable<void> {
    return of(isPlatformBrowser(this.platformId))
      .pipe(
        filter(this.isBrowser),
        flatMap(() => new Observable<void>(subscriber => {
          try {
            Janus.init({
              debug: true,
              dependencies: Janus.useDefaultDependencies(), // or: Janus.useOldDependencies() to get the behaviour of previous Janus versions
              callback: () => {
                subscriber.next();
                subscriber.complete();
                if (successCallback !== undefined) {
                  successCallback();
                }
              }
            });
          } catch (e) {
            subscriber.error(e);
            subscriber.complete();
          }
        }))
      );
  }

  isBrowser = (is): boolean => {
    return is === true && is !== undefined;
  };

  public createSession(successCallback?: Function, errorCallback?: Function,
                       destroyedCallback?: Function): Observable<JanusJS.Janus> {
    return of(isPlatformBrowser(this.platformId))
      .pipe(
        filter(this.isBrowser),
        flatMap(() => new Observable<JanusJS.Janus>(subscriber => {
          try {
            if (this.janus === null) {
              this.janus = new Janus(
                {
                  server: 'ws://localhost:8188/',
                  success: () => {
                    subscriber.next(this.janus);
                    subscriber.complete();
                    if (successCallback !== undefined) {
                      successCallback();
                    }
                  },
                  error: function(cause) {
                    subscriber.error(cause);
                    subscriber.complete();
                    if (errorCallback !== undefined) {
                      errorCallback();
                    }
                  },
                  destroyed: function() {
                    if (destroyedCallback !== undefined) {
                      destroyedCallback();
                    }
                  }
                });
            } else {
              subscriber.next(this.janus);
              subscriber.complete();
            }
          } catch (e) {
            subscriber.error(e);
            subscriber.complete();
          }
        }))
      );
  }
}
