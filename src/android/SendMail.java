package com.autentia.plugin.sendmail;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SendMail extends CordovaPlugin {

	public static final String ACTION_SEND = "send";

	public boolean execute(
		String action,
		JSONArray jsonArgs,
		final CallbackContext callbackContext) throws JSONException {

		if (ACTION_SEND.equals(action)) {
			// Get the arguments.
			JSONObject args = jsonArgs.getJSONObject(0);
			final String subject = args.getString("subject");
			final String body = args.getString("body");
			final String sender = args.getString("sender");
			final String password = args.getString("password");
			final String recipients = args.getString("recipients");
			if (args.has("attachment")) {
				final String attachment = args.getString("attachment");
			} else {
				final String attachment = null;
			}

			// Run in a thread to not block the webcore thread.
			cordova.getThreadPool().execute(new Runnable() {
				// Thread method.
				public void run() {
					try {
						// Create the sender
						GMailSender gmailSender = new GMailSender(sender, password);

						// Send the mail.
						gmailSender.sendMail(subject, body, sender, recipients, attachment);

						// Thread safe callback.
						callbackContext.success();
					} catch (Exception e) {
						// Catch error.
						callbackContext.error(e.getMessage());
						callbackContext.error(e.toString());
					}
				}
			});
			return true;
		}

		return false;
	}
}
