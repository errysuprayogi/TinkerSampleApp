package com.tokopedia.sample;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tokopedia.sample.analytic.AppsflyerAnalytics;
import com.tokopedia.sample.analytic.GTMAnalytics;
import com.tokopedia.sample.analytic.MoengageAnalytics;
import com.tokopedia.sample.track.TrackApp;

/**
 * Author errysuprayogi on 16,December,2019
 */

public class BaseApplicationLike extends DefaultApplicationLike {

    private static final String TAG = BaseApplicationLike.class.getSimpleName();

    public BaseApplicationLike(Application application, int tinkerFlags,
                               boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                               long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DEBUG", "onCreate BaseApplicationLike");
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        Log.d("DEBUG", "onBaseContextAttached");
        MultiDex.install(base);
        TinkerInstaller.install(this);
        Tinker.with(getApplication());

        TrackApp.initTrackApp(getApplication());

        TrackApp.getInstance().registerImplementation(TrackApp.GTM, GTMAnalytics.class);
        TrackApp.getInstance().registerImplementation(TrackApp.APPSFLYER, AppsflyerAnalytics.class);
        TrackApp.getInstance().registerImplementation(TrackApp.MOENGAGE, MoengageAnalytics.class);
        TrackApp.getInstance().initializeAllApis();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(
            Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }
}
