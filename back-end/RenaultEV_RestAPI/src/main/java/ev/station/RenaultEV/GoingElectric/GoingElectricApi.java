/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric;
import ev.station.RenaultEV.GoingElectric.GoingElectricModel.GoingElectricData;


import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
@CrossOrigin(origins = "*")

public interface GoingElectricApi {
	String BASE_URL = "https://api.goingelectric.de/";

	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataNearMe(@Query("lat") double latitude,
												 @Query("lng") double longitude,
												 @Query("radius") int radius);
	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataNearMeOredered(@Query("lat") double latitude,
												 @Query("lng") double longitude,
												 @Query("radius") int radius,@Query("orderby")String orderby);

	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataWithinBounds(@Query("sw_lat") double sw_lat,
	                                             @Query("sw_lng") double sw_lng,
	                                             @Query("ne_lat") double ne_lat ,
												 @Query("ne_lng")double ne_lng);
	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataWithinBounds(@Query("startkey")int startkey , @Query("sw_lat") double sw_lat,
													   @Query("sw_lng") double sw_lng,
													   @Query("ne_lat") double ne_lat ,
													   @Query("ne_lng")double ne_lng);

	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataWithinBoundsClustered(@Query("sw_lat") double sw_lat,
	                                                   @Query("sw_lng") double sw_lng,
	                                                   @Query("ne_lat") double ne_lat ,
	                                                   @Query("ne_lng")double ne_lng ,
	                                                   @Query("clustering") boolean clustering ,
	                                                   @Query("zoom")int zoom  ,
	                                                   @Query("cluster_distance")int cluster_distance);

	@GET("chargepoints/photo/?key=19d974deee27be03459664d999989f0d")
	Call<ResponseBody> getStationImageWithId(@Query("id")int id ,
	                                        @Query("size")int size);

	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d")
	Call<GoingElectricData> getStationDataWithId(@Query("ge_id")int id);


	@GET("chargepoints/?key=19d974deee27be03459664d999989f0d&sw_lat=-87.71179927260242&sw_lng=-180&ne_lat=89.45016124669523&ne_lng=180&result_details%3Dminimal ")
	Call<GoingElectricData> getAllStationsData();





}
