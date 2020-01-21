package com.tokopedia.sample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.tokopedia.sample.analytic.AppsflyerAnalytics;
import com.tokopedia.sample.analytic.GTMAnalytics;
import com.tokopedia.sample.analytic.MoengageAnalytics;
import com.tokopedia.sample.track.TrackApp;

/**
 * Author errysuprayogi on 17,December,2019
 */
public class AppApplication extends BaseApplication implements TkpdCoreRouter {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DEBUG", "onCreate AppApplication");
    }

    @Override
    public Class<?> getDeeplinkClass() {
        return null;
    }

    @Override
    public Intent getSellerHomeActivityReal(Context context) {
        return null;
    }

    @Override
    public Intent getInboxTalkCallingIntent(Context mContext) {
        return null;
    }

    @Override
    public Class<?> getInboxMessageActivityClass() {
        return null;
    }

    @Override
    public Class<?> getInboxResCenterActivityClassReal() {
        return null;
    }

    @Override
    public Intent getActivitySellingTransactionShippingStatusReal(Context mContext) {
        return null;
    }

    @Override
    public Class getSellingActivityClassReal() {
        return null;
    }

    @Override
    public Intent getActivitySellingTransactionListReal(Context mContext) {
        return null;
    }

    @Override
    public Intent getHomeIntent(Context context) {
        return null;
    }

    @Override
    public Class<?> getHomeClass(Context context) throws ClassNotFoundException {
        return null;
    }

    @Override
    public void refreshFCMTokenFromBackgroundToCM(String token, boolean force) {

    }

    @Override
    public void refreshFCMFromInstantIdService(String token) {

    }

    @Override
    public void refreshFCMTokenFromForegroundToCM() {

    }
}
