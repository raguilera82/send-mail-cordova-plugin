send-mail-cordova-plugin
========================

This Cordova plugin allows to send an email using Android platform without email composer

Add in Cordova/PhoneGap project
========================

cordova plugin add https://github.com/raguilera82/send-mail-cordova-plugin.git


Example calling from index.js
========================

<code>
        
      var app = {
      // Application Constructor
      initialize: function() {
          this.bindEvents();
      },
      // Bind Event Listeners
      //
      // Bind any events that are required on startup. Common events are:
      // 'load', 'deviceready', 'offline', and 'online'.
      bindEvents: function() {
          document.addEventListener('deviceready', this.onDeviceReady, false);
      },
      // deviceready Event Handler
      //
      // The scope of 'this' is the event. In order to call the 'receivedEvent'
      // function, we must explicity call 'app.receivedEvent(...);'
      onDeviceReady: function() {
          app.receivedEvent('deviceready');
          sendmail.send(app.sendMailSuccess, app.sendMailError,
                  '(subject)',
                  'body', 
                  'yourmail@gmail.com', 'password',
                  'tosomeone@gmail.com');
      },
      sendMailSuccess : function() {
         console.log('Email send');
      },
      sendMailError : function(error) {
          console.log('Error: ' + error);
      },
      // Update DOM on a Received Event
      receivedEvent: function(id) {
          var parentElement = document.getElementById(id);
          var listeningElement = parentElement.querySelector('.listening');
          var receivedElement = parentElement.querySelector('.received');
    
          listeningElement.setAttribute('style', 'display:none;');
          receivedElement.setAttribute('style', 'display:block;');
    
          console.log('Received Event: ' + id);
      }
    };
</code>
