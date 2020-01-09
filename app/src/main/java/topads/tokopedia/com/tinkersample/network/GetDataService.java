package topads.tokopedia.com.tinkersample.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author errysuprayogi on 09,January,2020
 */
public interface GetDataService {
    @GET("config")
    Call<ResponseObject> getConfig();
}
