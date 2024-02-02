package ev.station.RenaultEV.OpenChargeMap;
import ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel.ChargeLocation_OCM;
import org.springframework.web.bind.annotation.CrossOrigin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List;
@CrossOrigin(origins = "*")

public interface OpenChargeMapApi {

        String BASE_URL = "https://api.openchargemap.io/v3/";
        int maxresults =100000;

        @GET("poi?key=91c7511c-5844-4945-9913-83906e2aaa45"+"&maxresults="+maxresults)
        Call<List<ChargeLocation_OCM>> getStationDataWithinBounds(@Query("boundingbox") String boundingbox,
                                                                  @Query("compact")boolean compact  ,
                                                                  @Query("verbose") boolean verbose ) ;










}
