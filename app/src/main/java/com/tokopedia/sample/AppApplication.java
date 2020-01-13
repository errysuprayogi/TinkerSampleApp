package com.tokopedia.sample;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.tokopedia.sample.analytic.AppsflyerAnalytics;
import com.tokopedia.sample.analytic.GTMAnalytics;
import com.tokopedia.sample.analytic.MoengageAnalytics;
import com.tokopedia.sample.track.TrackApp;

/**
 * Author errysuprayogi on 17,December,2019
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        TrackApp.initTrackApp(this);
        TrackApp.getInstance().registerImplementation(TrackApp.GTM, GTMAnalytics.class);
        TrackApp.getInstance().registerImplementation(TrackApp.APPSFLYER, AppsflyerAnalytics.class);
        TrackApp.getInstance().registerImplementation(TrackApp.MOENGAGE, MoengageAnalytics.class);
        TrackApp.getInstance().initializeAllApis();

    }

    //    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        SplitCompat.install(this);
//        MultiDex.install(this);
//    }
}
