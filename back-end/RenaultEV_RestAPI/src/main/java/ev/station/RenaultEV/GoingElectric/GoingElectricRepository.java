package ev.station.RenaultEV.GoingElectric;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationImage;
import ev.station.RenaultEV.RenaultEv.LocalImageRepository;
import ev.station.RenaultEV.RenaultEv.LocalRepository;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import ev.station.RenaultEV.GoingElectric.GoingElectricModel.GoingElectricData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GoingElectricRepository {
    int previousstartkey ;
    private static GoingElectricRepository instance;
    GoingElectricApi myGoingElectricApi ;

    GoingElectricRipper goingElectricRipper ;
    private final LocalRepository localRepository;

    private final LocalImageRepository localImageRepository;
    static ChargeLocationMockModel[] chargeLocationList ;

    public LocalRepository getLocalRepository() {
        return localRepository;
    }
    public LocalImageRepository getLocalImageRepository() {
        return localImageRepository;
    }
    public GoingElectricRipper getGoingElectricRipper() {
        return goingElectricRipper;
    }

    public GoingElectricRepository(LocalRepository localRepository,LocalImageRepository localImageRepository)
    {

        this.localRepository = localRepository;
        this.localImageRepository=localImageRepository ;
        goingElectricRipper = new GoingElectricRipper(this) ; }


    public void getChargingLocationsNearMyLocation(double latitude, double longitude, int radius)
    {
        //List<ChargeLocation> chargeLocationList =new ArrayList<>() ;
        List<ChargeLocationMockModel> chargeLocationList =new ArrayList<>() ;

        myGoingElectricApi.getStationDataNearMe(latitude, longitude , radius)
                .enqueue(new Callback<GoingElectricData>() {
                    @Override
                    public void onResponse(Call<GoingElectricData> call, Response<GoingElectricData> response)
                    {

                       for(int i=0; i< response.body().getChargelocations().size() ; i++ )
                       {
                           ChargeLocationMockModel chargeLocationMockModel = new ChargeLocationMockModel()  ;
                           chargeLocationMockModel.setGe_id(response.body().getChargelocations().get(i).getGe_id());
                           chargeLocationMockModel.setName(response.body().getChargelocations().get(i).getName());

                           chargeLocationMockModel.setCity(response.body().getChargelocations().get(i).getAddress().getCity());
                           chargeLocationMockModel.setCountry(response.body().getChargelocations().get(i).getAddress().getCountry());
                           chargeLocationMockModel.setPostcode(response.body().getChargelocations().get(i).getAddress().getPostcode());
                           chargeLocationMockModel.setStreet(response.body().getChargelocations().get(i).getAddress().getStreet());
                           chargeLocationMockModel.setLat(response.body().getChargelocations().get(i).getCoordinates().getLat());
                           chargeLocationMockModel.setLng(response.body().getChargelocations().get(i).getCoordinates().getLng());


                           chargeLocationMockModel.setUrl(response.body().getChargelocations().get(i).getUrl());
                           chargeLocationMockModel.setVerified(response.body().getChargelocations().get(i).isVerified());
                           chargeLocationMockModel.setChargepoints(response.body().getChargelocations().get(i).getChargepointsStrings());
                           chargeLocationMockModel.setNetwork(response.body().getChargelocations().get(i).isNetwork());

                           chargeLocationList.add(chargeLocationMockModel);

                       }


                       //chargeLocationRepository.saveAll(chargeLocationList) ;
                        localRepository.saveAll(chargeLocationList);


                    }

                    @Override
                    public void onFailure(Call<GoingElectricData> call, Throwable t) {



                    }
                });
    }

    public void getChargeLocationsWithinParserBounds(int startkey ,double sw_lat , double sw_lng,double ne_lat  , double ne_lng)
    {
        //List<ChargeLocation> chargeLocationList =new ArrayList<>() ;

        myGoingElectricApi.getStationDataWithinBounds(startkey , sw_lat  , sw_lng, ne_lat,ne_lng).enqueue(new Callback<GoingElectricData>() {
            @Override
            public void onResponse(Call<GoingElectricData> call, Response<GoingElectricData> response) {

                chargeLocationList= new ChargeLocationMockModel[response.body().getChargelocations().size()] ;
                for(int i=0; i< response.body().getChargelocations().size() ; i++ )
                {
                    ChargeLocationMockModel chargeLocationMockModel = new ChargeLocationMockModel()  ;
                    chargeLocationMockModel.setGe_id(response.body().getChargelocations().get(i).getGe_id());
                    chargeLocationMockModel.setName(response.body().getChargelocations().get(i).getName());

                    chargeLocationMockModel.setCity(response.body().getChargelocations().get(i).getAddress().getCity());
                    chargeLocationMockModel.setCountry(response.body().getChargelocations().get(i).getAddress().getCountry());
                    chargeLocationMockModel.setPostcode(response.body().getChargelocations().get(i).getAddress().getPostcode());
                    chargeLocationMockModel.setStreet(response.body().getChargelocations().get(i).getAddress().getStreet());
                    chargeLocationMockModel.setLat(response.body().getChargelocations().get(i).getCoordinates().getLat());
                    chargeLocationMockModel.setLng(response.body().getChargelocations().get(i).getCoordinates().getLng());


                    chargeLocationMockModel.setUrl(response.body().getChargelocations().get(i).getUrl());
                    chargeLocationMockModel.setVerified(response.body().getChargelocations().get(i).isVerified());
                    chargeLocationMockModel.setChargepoints(response.body().getChargelocations().get(i).getChargepointsStrings());
                    chargeLocationMockModel.setNetwork(response.body().getChargelocations().get(i).isNetwork());


                    chargeLocationList[i]=chargeLocationMockModel ;



                }


                if (chargeLocationList.length>0)
                {
                    List<ChargeLocationMockModel> newList =List.of(chargeLocationList) ;
                    localRepository.saveAll(newList);
                }
                Integer k=response.body().getStartkey() ;
  if (previousstartkey<k)
  {
                goingElectricRipper.parseWorldMap_fast();
                previousstartkey=k;
            }}

            @Override
            public void onFailure(Call<GoingElectricData> call, Throwable throwable) {

            }
        });



    }

    public void   getChargingLocationImage(int chargeLocationId,int size)
    {
        myGoingElectricApi.getStationImageWithId(chargeLocationId,size)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.body()!=null) {
                            InputStream is = response.body().byteStream();
                            byte[] array ;
                            try {
                                array = is.readAllBytes();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ChargeLocationImage image = new ChargeLocationImage(chargeLocationId , array) ;
                            localImageRepository.save(image) ;


                        }
                        goingElectricRipper.ripImageRepository();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {


                    }
                });
    }
}
