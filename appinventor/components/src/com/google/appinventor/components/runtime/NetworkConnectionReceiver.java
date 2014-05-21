// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2014 MIT, All rights reserved
// Released under the MIT License https://raw.github.com/mit-cml/app-inventor/master/mitlicense.txt

package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.AndroidManifestXML;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.ErrorMessages;

import com.google.appinventor.components.runtime.NetworkConnection;
import android.content.BroadcastReceiver;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.app.Activity;


@SuppressWarnings("deprecation")
public class NetworkConnectionReceiver extends BroadcastReceiver {

  public static final String TAG = "NetworkConnectionReceiver";
  public static final int NOTIFICATION_ID = 8647;

  /**
   * Called by the system when an incoming SMS is received either from Google Voice
   * or through the built-in Telephony app.
   *
   */
  @Override
  public void onReceive(Context context, Intent intent) {
    ConnectivityManager connectivityManager =  (ConnectivityManager)
        context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
  }
}
