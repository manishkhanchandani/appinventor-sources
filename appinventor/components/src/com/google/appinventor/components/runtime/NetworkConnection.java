// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2014 MIT, All rights reserved
// Released under the MIT License https://raw.github.com/mit-cml/app-inventor/master/mitlicense.txt

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.AndroidManifestXML;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.app.Activity;


/**
 * Component for sharing files and/or messages through Android's built-in sharing
 * functionality.
 *
 * @author manishkk74@gmail.com (Manish Khanchandani)
 * and fixed file support.
 */
@DesignerComponent(version = YaVersion.SHARING_COMPONENT_VERSION,
    description ="Sharing is a non-visible component that enables sharing files and/or " +
        "messages between your app and other apps installed on a device. The component " +
        "will display a list of the installed apps that can handle the information provided, " +
        "and will allow the user to choose one to share the content with, for instance a " +
        "mail app, a social network app, a texting app, and so on.<br>" +
        "The file path can be taken directly from other components such as the Camera or the " +
        "ImagePicker, but can also be specified directly to read from storage. Be aware that " +
        "different devices treat storage differently, so a few things to try if, " +
        "for instance, you have a file called arrow.gif in the folder " +
        "<code>Appinventor/assets</code>, would be: <ul>" +
        "<li><code>\"file:///sdcard/Appinventor/assets/arrow.gif\"</code></li> or " +
        "<li><code>\"/storage/Appinventor/assets/arrow.gif\"</code></li></ul>",
    category = ComponentCategory.CONNECTIVITY,
    nonVisible = true, iconName = "images/networkconnection.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE")
@AndroidManifestXML(manifestLine = "<action android:name=\"android.net.conn.CONNECTIVITY_CHANGE\"/>")
public class NetworkConnection extends AndroidNonvisibleComponent {

  private static Activity activity;
  public NetworkConnection(ComponentContainer container) {
    super(container.$form());
    activity = container.$context();
  }

  @SimpleFunction(description = "Returns TRUE if the phone is on Connected, FALSE otherwise")
  public static boolean isConnected() {
    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    return isConnected;
  }

  @SimpleFunction(description = "Returns network type")
  public static int getNetworkType() {
    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    return activeNetwork.getType();
  }

  @SimpleFunction(description = "Returns TRUE if the phone is on Wifi, FALSE otherwise")
  public static boolean isWifi() {
    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    return isWiFi;
  }

  @SimpleFunction(description = "Returns TRUE if the phone is on Mobile Data Connection, FALSE otherwise")
  public static boolean isMobile() {
    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    boolean isMobile = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
    return isMobile;
  }

  @SimpleFunction(description = "Returns network status")
  public static String getConnectivityStatusString() {
    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    int conn = activeNetwork.getType();
    String status = null;
    if (conn == ConnectivityManager.TYPE_WIFI) {
        status = "Wifi enabled";
    } else if (conn == ConnectivityManager.TYPE_MOBILE) {
        status = "Mobile data enabled";
    } else {
        status = "Not connected to Internet";
    }
    return status;
  }
}
