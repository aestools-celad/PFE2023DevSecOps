package ev.station.RenaultEV.RenaultEv;

import ev.station.RenaultEV.OpenChargeMap.OpenChargeMapRepository;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import ev.station.RenaultEV.GoingElectric.GoingElectricRepository;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel_OCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")

@Service
public class ChargeLocationService {


    @Autowired
    private LocalRepository localRepository;
    private LocalRepository_OCM localRepository_ocm;

    /*public Page<ChargeLocationMockModel> getUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return LocalRepository.findAll(pageable);
    }*/
    GoingElectricRepository goingElectricRepository ;
    OpenChargeMapRepository openChargeMapRepository ;

    @Autowired
public ChargeLocationService( LocalRepository localRepository,LocalImageRepository localImageRepository , LocalRepository_OCM localRepository_ocm) {

        goingElectricRepository =new GoingElectricRepository(localRepository,localImageRepository) ;
        openChargeMapRepository =new OpenChargeMapRepository(localRepository_ocm) ;

    }

    public List<ChargeLocationMockModel>  findByCountry(String country)
    {
        return localRepository.findByCountry(country);
    }


   /* public List<ChargeLocationMockModel_OCM>  findByCountry_ocm(String country)
    {
        return localRepository_ocm.findByCountry_ocm(country);
    }*/

    //********************************************************************************************************************************************************************
    //goingelectric
    //********************************************************************************************************************************************************************

    //basic operations
    public List<ChargeLocationMockModel> getChargeLocations()
    {
        return  goingElectricRepository.getLocalRepository().findAll()  ;

    }

    /*public Page<ChargeLocationMockModel> findLocationWIthPagination(int offset ,int pageSize)
    {
        Page<ChargeLocationMockModel>  locations= LocalRepository.findAll(PageRequest.of(offset,pageSize));
        return locations ;
    }*/
    public void addChargeLocation(ChargeLocationMockModel chargeLocation)
    {
        Optional<ChargeLocationMockModel> chargeLocationOptional=  goingElectricRepository.getLocalRepository().findChargelocationbyName(chargeLocation.getName());
            if (chargeLocationOptional.isPresent())
            {
                throw new IllegalStateException("chargelocation already in data base") ;
            }
            else
            {
                goingElectricRepository.getLocalRepository().save(chargeLocation) ;

            }


    }
    public void deleteChargeLocation(int id)
    {
        Optional<ChargeLocationMockModel> chargeLocationOptional=  goingElectricRepository.getLocalRepository().findChargelocationbyId(id) ;
        if (chargeLocationOptional.isPresent() ) goingElectricRepository.getLocalRepository().delete(chargeLocationOptional.get());

    }
    public void addChargeLocationsFromRemote(double latitude ,double longitude,int radius)
    {

        goingElectricRepository.getChargingLocationsNearMyLocation(latitude,longitude,radius);
    }
    public void deleteAllChargeLocations()
    {
        goingElectricRepository.getLocalRepository().deleteAll();

    }


    //database filling methods

    public void parseGoingElectricDB()
    {
        goingElectricRepository.getGoingElectricRipper().parseWorldMap_fast();
    }
    public String parseGoingElectricImagesDB()
    {
        return goingElectricRepository.getGoingElectricRipper().ripImageRepository();
    }

    //fetching methods
    public List<ChargeLocationMockModel> getStationsTest()
    {
        return goingElectricRepository.getLocalRepository().findByCoordinates_latBetweenAndCoordinates_lngBetween(-80d,80d,-60d,80d);
    }
    public List<ChargeLocationMockModel> getStationsWithinBounds(double sw_lat, double sw_lng , double ne_lat , double ne_lng) {
        return goingElectricRepository.getLocalRepository().findByCoordinates_latBetweenAndCoordinates_lngBetween(sw_lat ,ne_lat,sw_lng,ne_lng);
    }
    public List<ChargeLocationMockModel> findByRadius(double pos_lat, double pos_lng , int radius )
    {
        return goingElectricRepository.getLocalRepository().findByRadius(pos_lat ,pos_lng, radius);
    }
    public List<ChargeLocationMockModel> findByRadiusKm(double pos_lat, double pos_lng, int radius)
    {
        return goingElectricRepository.getLocalRepository().findByRadiusKm(pos_lat ,pos_lng, radius);
    }
    public List<ChargeLocationMockModel> findNearest(double lat, double lng)
    {
        return goingElectricRepository.getLocalRepository().findNearest(lat , lng) ;
    }
    public byte[] getImageById(int ge_id)
    {
        return goingElectricRepository.getLocalImageRepository().findByGeId(ge_id).get();

    }
    public long countStationsWithinBounds(double sw_lat, double sw_lng, double ne_lat, double ne_lng) {
        return goingElectricRepository.getLocalRepository().countByLatIsBetweenAndLngIsBetween(sw_lat ,ne_lat,sw_lng,ne_lng);
    }



    //utils
    public List<Integer> getAllGe_ids()
    {
        return  goingElectricRepository.getLocalRepository().getAllIds();
    }


    public ChargeLocationMockModel getChargeLocationWithGeId(int ge_id) {
    return goingElectricRepository.getLocalRepository().findbyGeId(ge_id).get() ;
    }




    //********************************************************************************************************************************************************************
    //openchargemap
    //********************************************************************************************************************************************************************
    //basic methods
    public List<ChargeLocationMockModel_OCM> getChargeLocationsOCM()
    {
        return  openChargeMapRepository.getLocalRepository_ocm().findAll()  ;

    }
    public void addChargeLocationOCM(ChargeLocationMockModel_OCM chargeLocation)
    {
        Optional<ChargeLocationMockModel_OCM> chargeLocationOptional=  openChargeMapRepository.getLocalRepository_ocm().findChargelocationbyName(chargeLocation.getName());
        if (chargeLocationOptional.isPresent())
        {
            throw new IllegalStateException("chargelocation already in data base") ;
        }
        else
        {
            openChargeMapRepository.getLocalRepository_ocm().save(chargeLocation) ;

        }


    }
    public void deleteChargeLocationOCM(int id)
    {
        Optional<ChargeLocationMockModel_OCM> chargeLocationOptional=  openChargeMapRepository.getLocalRepository_ocm().findChargelocationbyId(id) ;
        if (chargeLocationOptional.isPresent() )openChargeMapRepository.getLocalRepository_ocm().delete(chargeLocationOptional.get());

    }

    public void deleteAllChargeLocationsOCM()
    {
        openChargeMapRepository.getLocalRepository_ocm().deleteAll();

    }


    //database filling methods
    public void parseOpenChargeMapDB()
    {
        openChargeMapRepository.parseOpenChargeMap(-180 , -52,180 ,80);
    }

    //fetching methods

    public List<ChargeLocationMockModel_OCM> getStationsWithinBoundsOCM(double sw_lat, double sw_lng , double ne_lat , double ne_lng) {
        return openChargeMapRepository.getLocalRepository_ocm().findByCoordinates_latBetweenAndCoordinates_lngBetween(sw_lat ,ne_lat,sw_lng,ne_lng);
    }
    public List<ChargeLocationMockModel_OCM> findByRadiusOCM(double pos_lat, double pos_lng , int radius )
    {
        return openChargeMapRepository.getLocalRepository_ocm().findByRadius(pos_lat ,pos_lng, radius);
    }
    public List<ChargeLocationMockModel_OCM> findByRadiusKmOCM(double pos_lat, double pos_lng, int radius)
    {
        return openChargeMapRepository.getLocalRepository_ocm().findByRadiusKm(pos_lat ,pos_lng, radius);
    }
    public List<ChargeLocationMockModel_OCM> findNearestOCM(double lat, double lng)
    {
        return openChargeMapRepository.getLocalRepository_ocm().findNearest(lat , lng) ;
    }
    public long countStationsWithinBoundsOCM(double sw_lat, double sw_lng, double ne_lat, double ne_lng) {
        return openChargeMapRepository.getLocalRepository_ocm().countByLatIsBetweenAndLngIsBetween(sw_lat ,ne_lat,sw_lng,ne_lng);
    }
    public ChargeLocationMockModel_OCM getChargeLocationWithOcmId(int ge_id) {
        return openChargeMapRepository.getLocalRepository_ocm().findbyGeId(ge_id).get() ;
    }


}

