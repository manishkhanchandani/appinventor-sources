// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the MIT License https://raw.github.com/mit-cml/app-inventor/master/mitlicense.txt

package com.google.appinventor.components.runtime;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.ErrorMessages;

import android.provider.Settings.Secure;
import android.app.Activity;

import android.util.Log;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

/**
 * Utilities
 *
 * @author manishkk74@gmail.com (Manish Khanchandani)
 */

@DesignerComponent(version = 1,
    description = "Utilities Component",
    category = ComponentCategory.MKGALAXY,
    nonVisible = true, iconName = "images/utilities.png")
@SimpleObject
public class Utilities extends AndroidNonvisibleComponent {

  private static final String LOG_TAG = "Utilities";

  private String android_id;

  protected final Activity activityContext;

  public Utilities(ComponentContainer container) {
    super(container.$form());
    activityContext = container.$context();
  }

  /**
   * Shares a message using Android' built-in sharing.
   */
  @SimpleFunction(description = "Get the ID of Android")
  public String GetAndroidID() {
    android_id = Secure.getString(activityContext.getContentResolver(),
                Secure.ANDROID_ID);
    return android_id;
  }

  /**
   * Encodes the given text value so that it can be used in a URL.
   *
   * @param text the text to encode
   * @return the encoded text
   */
  @SimpleFunction
  public String UriEncode(String text) {
    try {
      return URLEncoder.encode(text, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      // If UTF-8 is not supported, we're in big trouble!
      // According to Javadoc and Android documentation for java.nio.charset.Charset, UTF-8 is
      // available on every Java implementation.
      Log.e(LOG_TAG, "UTF-8 is unsupported?", e);
      return "";
    }
  }

}