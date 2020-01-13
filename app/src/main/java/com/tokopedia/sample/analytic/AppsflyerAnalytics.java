package com.tokopedia.sample.analytic;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.lifecycle.Observer;

import com.tokopedia.sample.track.interfaces.AFAdsIDCallback;
import com.tokopedia.sample.track.interfaces.ContextAnalytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppsflyerAnalytics extends ContextAnalytics {
    private static final String TAG = AppsflyerAnalytics.class.getSimpleName();
    private static boolean isAppsflyerCallbackHandled = false;
    public static final String APPSFLYER_KEY = "SdSopxGtYr9yK8QEjFVHXL";
    private static final String KEY_INSTALL_SOURCE = "install_source";
    public static final String GCM_PROJECT_NUMBER = "692092518182";

    private static String deferredDeeplinkPath = "";

    public static final String ADVERTISINGID = "ADVERTISINGID";
    public static final String KEY_ADVERTISINGID = "KEY_ADVERTISINGID";

    public AppsflyerAnalytics(Context context) {
        super(context);
    }

    @Override
    public void sendGeneralEvent(Map<String, Object> value) {

    }

    @Override
    public void sendGeneralEvent(String event, String category, String action, String label) {

    }

    @Override
    public void sendEnhanceEcommerceEvent(Map<String, Object> value) {

    }

    @Override
    public void sendScreenAuthenticated(String screenName) {

    }

    @Override
    public void sendScreenAuthenticated(String screenName, Map<String, String> customDimension) {

    }

    @Override
    public void sendScreenAuthenticated(String screenName, String shopID, String shopType, String pageType, String productId) {

    }

    @Override
    public void sendEvent(String eventName, Map<String, Object> eventValue) {

    }
}
