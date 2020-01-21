package com.tokopedia.sample;

import android.content.Context;
import android.content.Intent;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Author errysuprayogi on 17,December,2019
 */
public class BaseApplication extends TinkerApplication {

    public BaseApplication() {
        super(
        // tinkerFlags, the types supported by tinker, dex, library, or all of them are supported!
        ShareConstants.TINKER_ENABLE_ALL,
        // ApplicationLike implementation class, can only pass strings
                BaseApplicationLike.class.getName()
        );
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
