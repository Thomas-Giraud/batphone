package org.servalproject.dt;

import org.servalproject.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class Receiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
		Log.i("Receiver", "Intent received " + intent.getAction());
		// if ((intent.getAction().equals("android.intent.action.DEFAULT"))
		if ((intent.getAction().equals("org.servalproject.DT"))
		/*
		 * & (intent.getType()
		 * .equals("vnd.servalproject.DT/vnd.servalproject.DT"))
		 */) {
			String sender = intent.getExtras().getString("number");
			String content = intent.getExtras().getString("content");
			this.writeSMS(sender, content, context);
		}
	}

	private void writeSMS(final String sender, final String content,
			final Context context) {
		// Write the SMS in the Inbox
		ContentValues values = new ContentValues();
		values.put("address", sender);
		values.put("body", content);
		context.getContentResolver().insert(Uri.parse("content://sms/inbox"),
				values);

		// Display a notification linked with SMSDroid
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(ns);

		int icon = R.drawable.icon;
		CharSequence tickerText = "Digital Telegram - New message";
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon, tickerText, when);
		// Context context = getApplicationContext();
		CharSequence contentTitle = "Digital Telegram";
		CharSequence contentText = sender + ": " + content;
		// Intent notificationIntent = new Intent("android.intent.action.MAIN");
		Intent notificationIntent = new Intent("android.intent.action.VIEW");
		notificationIntent.setData(Uri
				.parse("content://mms-sms/conversations/"));
		// Lauch Messaging when the user clicks on the notification
		// notificationIntent.setComponent(new
		// ComponentName("com.android.mms","com.android.mms.ui.ConversationList"));
		// Lauch SmsDroid when the user clicks on the notification
		/*
		 * notificationIntent.setComponent(new ComponentName(
		 * "de.ub0r.android.smsdroid",
		 * "de.ub0r.android.smsdroid.ConversationList"));
		 */
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				notificationIntent, 0);

		notification.setLatestEventInfo(context, contentTitle, contentText,
				contentIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(1, notification);
	}
}
