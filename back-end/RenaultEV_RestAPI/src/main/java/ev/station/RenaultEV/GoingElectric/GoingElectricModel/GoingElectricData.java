/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric.GoingElectricModel;

import java.util.List;

public class GoingElectricData {
	String status   ;

	int startkey ;

	public int getStartkey() {
		return startkey;
	}

	public void setStartkey(int startkey) {
		this.startkey = startkey;
	}
	List<chargelocation> chargelocations ;


	public GoingElectricData(String status, List<chargelocation> chargelocations,int startkey) {
		this.status = status;
		this.chargelocations = chargelocations;
		this.startkey=startkey ;

	}



	public String getStatus() {
		return status;
	}



	public List<chargelocation> getChargelocations() {
		return chargelocations;
	}

}
