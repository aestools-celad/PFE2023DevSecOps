/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric.GoingElectricModel;

public class coordinates {
	double lat  ;
	double lng ;

	public coordinates(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}
}
