package com.tokopedia.sample.analytic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.tokopedia.sample.R;
import com.tokopedia.sample.track.interfaces.ContextAnalytics;

import java.util.Map;

public class GTMAnalytics extends ContextAnalytics {

    public GTMAnalytics(Context context) {
        super(context);
//        String s = context.getApplicationContext().getString(R.string.app_name);
//        Log.d("INFO", s);
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
