/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class 	GoingElectricClient {

	private static GoingElectricClient instance = null;

	private GoingElectricClient() {




	}





	public static synchronized GoingElectricClient getInstance() {
		if (instance == null) {
			instance = new GoingElectricClient();
		}
		return instance;
	}

}

