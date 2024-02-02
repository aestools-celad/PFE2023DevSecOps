package ev.station.RenaultEV.OpenChargeMap;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class OpenChargeMapClient{
    private static OpenChargeMapClient instance = null;

    private OpenChargeMapClient() {



    }





    public static synchronized OpenChargeMapClient getInstance() {
        if (instance == null) {
            instance = new OpenChargeMapClient();
        }
        return instance;
    }

}
