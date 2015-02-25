package com.autentia.plugin.sendmail;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SendMail extends CordovaPlugin {

	public static final String ACTION_SEND = "send";

	public boolean execute(String action, JSONArray jsonArgs,
			CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_SEND.equals(action)) {
				JSONObject args = jsonArgs.getJSONObject(0);
				String subject = args.getString("subject");
				String body = args.getString("body");
				String sender = args.getString("sender");
				String password = args.getString("password");
				String recipients = args.getString("recipients");
				String attachment = null;
				if (args.has("attachment")) {
					attachment = args.getString("attachment");
				}

				GMailSender gmailSender = new GMailSender(
						sender, password);

				gmailSender.sendMail(subject, body, sender, recipients, attachment);

			}
			callbackContext.success();
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}
}
