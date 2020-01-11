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
public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DEBUG", "onCreate AppApplication");
    }

}
