package com.tokopedia.sample;

import android.content.Context;
import android.content.Intent;

public interface TkpdCoreRouter {
    String CART_ACTIVITY_OLD
            = "com.tokopedia.transaction.cart.activity.CartActivity";

    String CART_ACTIVITY_NEW
            = "com.tokopedia.purchase_platform.features.checkout.view.feature.cartlist.CartActivity";

    String INBOX_TICKET_ACTIVITY = "com.tokopedia.contactus.inboxticket2.view.activity.InboxListActivity";

    String ACTIVITY_SIMPLE_HOME = "com.tokopedia.tkpd.home.SimpleHomeActivity";

    String FRAGMENT_TYPE = "FRAGMENT_TYPE";
    int INVALID_FRAGMENT = 0;
    int WISHLIST_FRAGMENT = 1;
    int PRODUCT_HISTORY_FRAGMENT = 2;

    String EXTRA_STATE_TAB_POSITION = "EXTRA_STATE_TAB_POSITION";
    int RESO_ALL = 2;


    Class<?> getDeeplinkClass();

    Intent getSellerHomeActivityReal(Context context);

    Intent getInboxTalkCallingIntent(Context mContext);

    Class<?> getInboxMessageActivityClass();

    Class<?> getInboxResCenterActivityClassReal();

    Intent getActivitySellingTransactionShippingStatusReal(Context mContext);

    Class getSellingActivityClassReal();

    Intent getActivitySellingTransactionListReal(Context mContext);

    Intent getHomeIntent(Context context);

    Class<?> getHomeClass(Context context) throws ClassNotFoundException;

    void refreshFCMTokenFromBackgroundToCM(String token, boolean force);

    void refreshFCMFromInstantIdService(String token);

    void refreshFCMTokenFromForegroundToCM();
}
