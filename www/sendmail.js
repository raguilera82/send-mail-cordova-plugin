var sendmail = {

    send: function(successCallback, errorCallback, subject, body, sender, password, recipients){
        cordova.exec(successCallback,
            errorCallback,
            "SendMail",
            "send",
            [{
                 "subject":subject,
                 "body":body,
                 "sender":sender,
                 "password":password,
                 "recipients":recipients,
                 "attachment": attachment,
            }]
        );

    }
}

module.exports = sendmail;
