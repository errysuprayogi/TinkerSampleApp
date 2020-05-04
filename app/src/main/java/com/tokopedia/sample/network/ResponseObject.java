package com.tokopedia.sample.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.tokopedia.sample.utils.Utils;

/**
 * Author errysuprayogi on 09,January,2020
 */
public class ResponseObject {
    @SerializedName("patch_available")
    @Expose
    private boolean isPatchAvailable;
    @SerializedName("patch_id")
    @Expose
    private String patchId;
    @SerializedName("patch_url")
    @Expose
    private String patchUrl;

    public boolean isPatchAvailable() {
        return isPatchAvailable;
    }

    public void setPatchAvailable(boolean patchAvailable) {
        isPatchAvailable = patchAvailable;
    }

    public String getPatchId() {
        return Utils.checkDataValidity(patchId);
    }

    public void setPatchId(String patchId) {
        this.patchId = patchId;
    }

    public String getPatchUrl() {
        return Utils.checkDataValidity(patchUrl);
    }

    public void setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
    }
}
