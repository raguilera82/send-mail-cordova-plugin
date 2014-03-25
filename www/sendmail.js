var sendmail = {
    
		send: function(successCallback, errorCallback, subject, body, sender, password, recipients){
			cordova.exec(successCallback,
			    errorCallback,
			    "SendMail",
			    "send",
			    [{
			     	"subject":subject, 
			       	"body":body,
			       	"password":password,
			       	"sender":sender, 
			       	"recipients":recipients
			    }]
			);
			
		}
}

module.exports = sendmail;