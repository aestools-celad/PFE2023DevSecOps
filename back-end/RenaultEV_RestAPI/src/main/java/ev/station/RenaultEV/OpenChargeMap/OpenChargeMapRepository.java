package ev.station.RenaultEV.OpenChargeMap;
import ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel.ChargeLocation_OCM;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel_OCM;
import ev.station.RenaultEV.RenaultEv.LocalRepository_OCM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChargeMapRepository {
    OpenChargeMapApi myOpenChargeMapApi ;
    LocalRepository_OCM localRepository_ocm ;
    List<ChargeLocationMockModel_OCM> chargeLocationList;


    public OpenChargeMapRepository(LocalRepository_OCM localRepository)
{
    this.localRepository_ocm=localRepository ;
    chargeLocationList=new ArrayList<>() ;
}
  public  LocalRepository_OCM getLocalRepository_ocm()
    {
        return this.localRepository_ocm ;
    }
public void parseOpenChargeMap(double sw_lat , double sw_lng,double ne_lat  , double ne_lng)
{
    String boundingbox="("+sw_lat+","+sw_lng+"),("+ne_lat+","+ne_lng+")" ;


    myOpenChargeMapApi.getStationDataWithinBounds(boundingbox,true,false).enqueue(new Callback<List<ChargeLocation_OCM>>() {
        @Override
        public void onResponse(Call<List<ChargeLocation_OCM>> call, Response<List<ChargeLocation_OCM>> response) {

            for(int i=0; i< response.body().size() ; i++ )
            {
                ChargeLocationMockModel_OCM chargeLocationMockModel = new ChargeLocationMockModel_OCM()  ;
                try {chargeLocationMockModel.setGe_id(response.body().get(i).getId());} catch (Exception e) {};
                try { chargeLocationMockModel.setName(response.body().get(i).getAddressInfo().getTitle());} catch (Exception e) {};
                try { chargeLocationMockModel.setCity(response.body().get(i).getAddressInfo().getTown());} catch (Exception e) {};
                try { chargeLocationMockModel.setCountry(response.body().get(i).getAddressInfo().getCountry().getTitle());} catch (Exception e) {};
                try {chargeLocationMockModel.setPostcode(""+response.body().get(i).getAddressInfo().getPostcode());} catch (Exception e) {};
                try { chargeLocationMockModel.setStreet(response.body().get(i).getAddressInfo().getAddressLine1());} catch (Exception e) {};
                try {chargeLocationMockModel.setLat(response.body().get(i).getAddressInfo().getLatitude());} catch (Exception e) {};
                try { chargeLocationMockModel.setLng(response.body().get(i).getAddressInfo().getLongitude());} catch (Exception e) {};
                try {chargeLocationMockModel.setUrl(response.body().get(i).getAddressInfo().getRelatedURL());} catch (Exception e) {};
                try {chargeLocationMockModel.setVerified(response.body().get(i).getIsRecentlyVerified());} catch (Exception e) {};
                try {chargeLocationMockModel.setChargepoints(response.body().get(i).getConnectionsToString());} catch (Exception e) {};
                try {chargeLocationMockModel.setPrice(response.body().get(i).getUsageCost().toString());}catch (Exception e){}
                chargeLocationMockModel.setNetwork(false);
                chargeLocationList.add(chargeLocationMockModel);

            }
            localRepository_ocm.saveAll(chargeLocationList);


        }




        @Override
        public void onFailure(Call<List<ChargeLocation_OCM>> call, Throwable throwable) {

        }
    });
}

}
