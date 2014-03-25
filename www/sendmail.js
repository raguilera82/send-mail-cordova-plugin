var sendmail = {
    
		send: function(successCallback, errorCallback, subject, body, sender, recipients){
			cordova.exec(successCallback,
			    errorCallback,
			    "SendMail",
			    "send",
			    [{
			     	"subject":subject, 
			       	"body":body, 
			       	"sender":sender, 
			       	"recipients":recipients
			    }]
			);
			
		}
}

module.exports = sendmail;