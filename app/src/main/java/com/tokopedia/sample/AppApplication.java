package com.tokopedia.sample;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.google.android.play.core.splitcompat.SplitCompat;

/**
 * Author errysuprayogi on 17,December,2019
 */
public class AppApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SplitCompat.install(this);
        MultiDex.install(this);
    }
}
