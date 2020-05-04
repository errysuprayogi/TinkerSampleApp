package com.tokopedia.sample;

import android.content.Context;
import android.content.Intent;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Author errysuprayogi on 17,December,2019
 */
public class BaseApplication extends TinkerApplication implements TkpdCoreRouter {

    public BaseApplication() {
        super(
        // tinkerFlags, the types supported by tinker, dex, library, or all of them are supported!
        ShareConstants.TINKER_ENABLE_ALL,
        // ApplicationLike implementation class, can only pass strings
        "com.tokopedia.sample.BaseApplicationLike",
        // Tinker's loader, generally use the default
        "com.tencent.tinker.loader.TinkerLoader",
        // tinkerLoadVerifyFlag, whether to verify dex and ib and res Md5 when running load
        false
        );
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SplitCompat.install(this);
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
