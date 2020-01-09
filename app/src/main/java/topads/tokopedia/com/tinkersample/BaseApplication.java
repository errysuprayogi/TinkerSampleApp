package topads.tokopedia.com.tinkersample;

import android.content.Context;

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
        BaseApplicationLike.class.getName(),
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
}
