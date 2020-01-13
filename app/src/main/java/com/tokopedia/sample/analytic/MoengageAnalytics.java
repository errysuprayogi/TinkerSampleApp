package com.tokopedia.sample.analytic;

import android.content.Context;
import android.text.TextUtils;

import com.tokopedia.sample.track.interfaces.ContextAnalytics;

import java.util.Map;


public class MoengageAnalytics extends ContextAnalytics {
    public MoengageAnalytics(Context context) {
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
