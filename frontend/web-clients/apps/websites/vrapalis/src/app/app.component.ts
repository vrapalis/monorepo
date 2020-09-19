import { Component } from '@angular/core';
import * as Jan from 'janus-gateway-js';
import { Janus } from 'janus-gateway';

@Component({
  selector: 'web-clients-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor() {
    Janus.init({
      debug: true,
      dependencies: Janus.useDefaultDependencies(), // or: Janus.useOldDependencies() to get the behaviour of previous Janus versions
      callback: function() {
        // Done!
      }});

    const jan = new Janus(
      {
        server: 'ws://localhost:8188/',
        success: function() {
          // Done! attach to plugin XYZ
          console.log("success")
        },
        error: function(cause) {
          // Error, can't go on...
          console.log(cause)
        },
        destroyed: function() {
          // I should get rid of this
        }
      });

    jan.attach(
      {
        plugin: "janus.plugin.echotest",
        success: function(pluginHandle) {
          // Plugin attached! 'pluginHandle' is our handle
          console.log(pluginHandle)
        },
        error: function(cause) {
          // Couldn't attach to the plugin
        },
        consentDialog: function(on) {
          // e.g., Darken the screen if on=true (getUserMedia incoming), restore it otherwise
          console.log(on);
        },
        onmessage: function(msg, jsep) {
          // We got a message/event (msg) from the plugin
          // If jsep is not null, this involves a WebRTC negotiation
          console.log(msg, jsep)
        },
        onlocalstream: function(stream) {
          // We have a local stream (getUserMedia worked!) to display
          console.log(stream)
        },
        onremotestream: function(stream) {
          // We have a remote stream (working PeerConnection!) to display
          console.log(stream)
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

    // const janus = new Jan.Client('ws://localhost:8188', {
    //   token: 'token',
    //   apisecret: 'apisecret',
    //   keepalive: 'true'
    // });
    //
    // janus.createConnection('id').then(function(connection) {
    //   console.log(connection);
    //   connection.createSession().then(function(session) {
    //     console.log(`Session: ${session}`);
    //     session.attachPlugin('janus.plugin.echotest').then(function(plugin) {
    //       console.log('Plugin: ' + plugin);
    //       plugin.send({}).then(function(response) {
    //         console.log('Plugin Res: '+response);
    //       });
    //       plugin.on('message', function(message) {
    //         console.log('Plugin on: ' + message)
    //       });
    //
    //       // plugin.detach();
    //     });
    //   });
    // });

  }
}
