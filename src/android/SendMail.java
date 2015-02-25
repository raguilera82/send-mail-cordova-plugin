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
		CallbackContext callbackContext) throws JSONException {

		if (ACTION_SEND.equals(action)) {
			// Run in a thread to alloz to display loading image for the application.
			final long duration = args.getLong(0);
			cordova.getActivity().runOnUiThread(new Runnable() {
				// Thread method.
				public void run() {
					try {
						// Get the arguments.
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

						// Create the sender
						GMailSender gmailSender = new GMailSender(
								sender, password);

						// Send the mail (async).
						gmailSender.sendMail(subject, body, sender, recipients, attachment);

						// Thread safe.
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
