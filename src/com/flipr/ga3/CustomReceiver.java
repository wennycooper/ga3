package com.flipr.ga3;

import android.util.Log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.analytics.tracking.android.CampaignTrackingReceiver;

/*
 *  A simple Broadcast Receiver to receive an INSTALL_REFERRER
 *  intent and pass it to other receivers, including
 *  the Google Analytics receiver.
 */
public class CustomReceiver extends BroadcastReceiver {
	private static final String TAG = "CustomReceiver";

  @Override
  public void onReceive(Context context, Intent intent) {

    // Pass the intent to other receivers.

	Log.v(TAG, "onReceive");
	
    // When you're done, pass the intent to the Google Analytics receiver.
    new CampaignTrackingReceiver().onReceive(context, intent);
  }
}