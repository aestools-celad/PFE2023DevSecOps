package ev.station.RenaultEV.RenaultEv;

import ev.station.RenaultEV.ClusteringUtils.Cluster;
import ev.station.RenaultEV.ClusteringUtils.ClusterOCM;
import ev.station.RenaultEV.ClusteringUtils.ClusteringUtils;
import ev.station.RenaultEV.ClusteringUtils.ClusteringUtilsOCM;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel_OCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class 	ChargeLocationController {
	@Autowired

    private LocalRepository LocalRepository ;
    ChargeLocationService chargeLocationService  ;
	public ChargeLocationController(ChargeLocationService chargeLocationService)
	{
		this.chargeLocationService=chargeLocationService ;
	}

	//********************************************************************************************************************************************************************
	//goingelectric
	//********************************************************************************************************************************************************************
	@GetMapping("/ge/locations")
	public Page<ChargeLocationMockModel> getLocations(Pageable pageable) {
		return LocalRepository.findAll(pageable);
	}
	/*
	@GetMapping("/ge/chargelocations_all")
	public List<ChargeLocationMockModel> chargeLocation()
	{
	return  chargeLocationService.getChargeLocations() ;
	}
<<<<<<< HEAD
	/*@GetMapping("/pagination/{offset}/{pageSize}")
	public APIResponse <Page<ChargeLocationMockModel>> getLocationsWithSort()
	{

	}



	public List<ChargeLocationMockModel> chargeLocation()
	{
		return  chargeLocationService.getChargeLocations() ;
	}*/

	@GetMapping("/ge/chargelocations_country")
	public List<ChargeLocationMockModel> findByCountry(@RequestParam String country )
	{
		return chargeLocationService.findByCountry(country )  ;
	}
	/*@GetMapping("/chargelocations_country_ocm")
	public List<ChargeLocationMockModel_OCM> findByCountry_OCM(@RequestParam String country )
	{
		return chargeLocationService.findByCountry_ocm(country )  ;
	}*/
	@GetMapping(" ")
	public Page<ChargeLocationMockModel> chargeLocation(Pageable pageable)
	{
		return LocalRepository.findAll(pageable);
	}


	/*@GetMapping("/ge/chargelocations_all")
	@ResponseBody
	public List<ChargeLocationMockModel> chargeLocation()
	{
		return  chargeLocationService.getChargeLocations() ;
	}*/


	@GetMapping("/ge/chargelocation")
	public ChargeLocationMockModel chargeLocation(@RequestParam 	int ge_id )
	{
		return  chargeLocationService.getChargeLocationWithGeId(ge_id) ;
	}


   	@GetMapping("/home")
   	public String welcome()
   {
	   return "welcome" ; 
   }

	@PostMapping("/ge/add_chargelocation")
	public void addChargeLocation(@RequestBody ChargeLocationMockModel chargeLocation)
	{
		chargeLocationService.addChargeLocation(chargeLocation) ;
	}
	@DeleteMapping("/ge/delete_chargelocation")
	public  void deleteChargelocation(@RequestParam int id )
	{
		chargeLocationService.deleteChargeLocation(id);
	}

	@PostMapping("/ge/add_chargelocations_from_remote")
	public  void addChargeLocationsFromRemote(@RequestParam double latitude,double longitude,int radius)
	{
		chargeLocationService.addChargeLocationsFromRemote(latitude,longitude,radius);
	}
	@GetMapping("/parse_goingelectric")
	public  void parseGoingElectricDB()
	{
		chargeLocationService.parseGoingElectricDB();
	}

	@DeleteMapping("/ge/delete_chargelocations")
	public  void deleteChargelocation()
	{
		chargeLocationService.deleteAllChargeLocations();
	}

	@GetMapping("/ge/test")
	public List<ChargeLocationMockModel> test()
	{
		return  chargeLocationService.getStationsTest();
	}
	@GetMapping("/ge/chargelocations_bounds")
	public List<ChargeLocationMockModel> getStationsWithinBounds(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng)
	{
		return  chargeLocationService.getStationsWithinBounds(sw_lat,sw_lng,ne_lat, ne_lng);
	}
	@GetMapping("/ge/chargelocations_bounds_count")
	public long contStationsWithinBounds(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng)
	{
		return  chargeLocationService.countStationsWithinBounds(sw_lat,sw_lng,ne_lat, ne_lng);
	}
	@GetMapping("/ge/chargelocations_radius")
	public List<ChargeLocationMockModel> getStationsWithinBounds(@RequestParam double lat, double lng, int radius,@RequestParam(required=false)String unit )
	{

		if (unit!=null) {
			if (unit.equals("km")) return chargeLocationService.findByRadiusKm(lat, lng, radius);
			else return  chargeLocationService.findByRadius(lat,lng,radius);
		}
		else {
			return  chargeLocationService.findByRadius(lat,lng,radius);
		}


	}
	@GetMapping("/ge/chargelocations_clusters")
	public List<ChargeLocationMockModel> getClusters(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{
		List<ChargeLocationMockModel>chargelocations = chargeLocationService.getStationsWithinBounds(sw_lat,sw_lng,ne_lat, ne_lng);
		return (ClusteringUtils.clusterV3((ArrayList<ChargeLocationMockModel>) chargelocations, zoomLevel,minPixelDistance) );

	}
	@GetMapping("/ge/chargelocations_clusters_old")
	public List<Cluster> getClustersOldModel(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{
		List<ChargeLocationMockModel>chargelocations = chargeLocationService.getStationsWithinBounds(sw_lat,sw_lng,ne_lat, ne_lng);
		return (ClusteringUtils.clusterV3OldModel( chargelocations, zoomLevel,minPixelDistance) );

	}
	@GetMapping("/ge/chargelocations_clusters_count")
	public int countClusters(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{

		List<ChargeLocationMockModel>chargelocations = chargeLocationService.getStationsWithinBounds(sw_lat,sw_lng,ne_lat, ne_lng);

		return (ClusteringUtils.countAfterClustering((ArrayList<ChargeLocationMockModel>) chargelocations, zoomLevel,minPixelDistance) );

	}

	@GetMapping("/ge/chargelocations_nearest")
	public List<ChargeLocationMockModel> findNearest(@RequestParam double lat, double lng )
	{
		return chargeLocationService.findNearest(lat, lng )  ;
	}

	@GetMapping("/ge/parse_goingelectric_images")
	public String parseImages( )
	{

		return chargeLocationService.parseGoingElectricImagesDB();
	}

	@GetMapping(path= "/ge/image" ,produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageByGeId(@RequestParam("ge_id")int ge_id){
		return chargeLocationService.getImageById(ge_id);
	}



	//********************************************************************************************************************************************************************
	//openchargemap
	//********************************************************************************************************************************************************************
	@GetMapping("/ocm/chargelocations_all")
	public List<ChargeLocationMockModel_OCM> chargeLocationOCM()
	{
		return  chargeLocationService.getChargeLocationsOCM() ;
	}
	@GetMapping("/ocm/chargelocation")
	public ChargeLocationMockModel_OCM chargeLocationOCM(@RequestParam 	int ge_id )
	{
		return  chargeLocationService.getChargeLocationWithOcmId(ge_id) ;
	}
	@PostMapping("/ocm/add_chargelocation")
	public void addChargeLocationOCM(@RequestBody ChargeLocationMockModel_OCM chargeLocation)
	{
		chargeLocationService.addChargeLocationOCM(chargeLocation) ;
	}
	@DeleteMapping("/ocm/delete_chargelocation")
	public  void deleteChargelocationOCM(@RequestParam int id )
	{
		chargeLocationService.deleteChargeLocationOCM(id);
	}



	@GetMapping("/parse_openchargemap")
	public  void parseOpenChargeMapDB()
	{
		chargeLocationService.parseOpenChargeMapDB();
	}
	@DeleteMapping("/ocm/delete_chargelocations")
	public  void deleteChargelocationOCM()
	{
		chargeLocationService.deleteAllChargeLocationsOCM();
	}


	@GetMapping("/ocm/chargelocations_bounds")
	public List<ChargeLocationMockModel_OCM> getStationsWithinBoundsOCM(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng)
	{
		return  chargeLocationService.getStationsWithinBoundsOCM(sw_lat,sw_lng,ne_lat, ne_lng);
	}
	@GetMapping("/ocm/chargelocations_bounds_count")
	public long contStationsWithinBoundsOCM(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng)
	{
		return  chargeLocationService.countStationsWithinBoundsOCM(sw_lat,sw_lng,ne_lat, ne_lng);
	}
	@GetMapping("/ocm/chargelocations_radius")
	public List<ChargeLocationMockModel_OCM> getStationsWithinBoundsOCM(@RequestParam double lat, double lng, int radius,@RequestParam(required=false)String unit )
	{

		if (unit!=null) {
			if (unit.equals("km")) return chargeLocationService.findByRadiusKmOCM(lat, lng, radius);
			else return  chargeLocationService.findByRadiusOCM(lat,lng,radius);
		}
		else {
			return  chargeLocationService.findByRadiusOCM(lat,lng,radius);
		}


	}
	@GetMapping("/ocm/chargelocations_clusters")
	public List<ChargeLocationMockModel_OCM> getClustersOCM(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{
		List<ChargeLocationMockModel_OCM>chargelocations = chargeLocationService.getStationsWithinBoundsOCM(sw_lat,sw_lng,ne_lat, ne_lng);
		return (ClusteringUtilsOCM.clusterV3((ArrayList<ChargeLocationMockModel_OCM>) chargelocations, zoomLevel,minPixelDistance) );

	}
	@GetMapping("/ocm/chargelocations_clusters_old")
	public List<ClusterOCM> getClustersOldModelOCM(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{
		List<ChargeLocationMockModel_OCM>chargelocations = chargeLocationService.getStationsWithinBoundsOCM(sw_lat,sw_lng,ne_lat, ne_lng);
		return (ClusteringUtilsOCM.clusterV3OldModel( chargelocations, zoomLevel,minPixelDistance) );

	}
	@GetMapping("/ocm/chargelocations_clusters_count")
	public int countClustersOCM(@RequestParam double sw_lat, double sw_lng, double ne_lat , double ne_lng , int zoomLevel, int minPixelDistance)
	{

		List<ChargeLocationMockModel_OCM>chargelocations = chargeLocationService.getStationsWithinBoundsOCM(sw_lat,sw_lng,ne_lat, ne_lng);

		return (ClusteringUtilsOCM.countAfterClustering((ArrayList<ChargeLocationMockModel_OCM>) chargelocations, zoomLevel,minPixelDistance) );

	}

	@GetMapping("/ocm/chargelocations_nearest")
	public List<ChargeLocationMockModel_OCM> findNearestOCM(@RequestParam double lat, double lng )
	{
		return chargeLocationService.findNearestOCM(lat, lng )  ;
	}




}
