/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric.GoingElectricModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class chargelocation {



	List<chargepoint> chargepoints  ;
	int ge_id  ;
	String name  ;
	address address  ;
	coordinates coordinates;
	boolean network ;
	String url="" ;


	boolean verified  ;
	boolean clustered =false ;
	int clusterCount =0 ;



	public chargelocation() {
	}


	//Getters
	public List<chargepoint> getChargepoints() {
		return chargepoints;
	}

	public String getChargepointsStrings()
	{
		String chargePointsStrings = "";
		for(int i=0 ; i<chargepoints.size() ;i++) chargePointsStrings+=(chargepoints.get(i).toString()) +"\n";
		return  chargePointsStrings ;

	}

	public int getGe_id() {
		return ge_id;
	}

	public String getName() {
		return name;
	}

	public address getAddress() {
		return address;
	}

	public coordinates getCoordinates() {
		return coordinates;
	}

	public boolean isNetwork() {
		return network;
	}

	public String getUrl() {
		return url;
	}



	public boolean isVerified() {
		return verified;
	}

	public boolean isClustered() {
		return clustered;
	}

	public int getCluster_Count() {
		return clusterCount;
	}

	// constructor

	public chargelocation(List<chargepoint> chargepoints, int ge_id, String name, address address,coordinates coordinates, boolean network, String url, boolean fault_report, boolean verified, boolean clustered, int clusterCount) {
		this.chargepoints = chargepoints;
		this.ge_id = ge_id;
		this.name = name;
		this.address = address;
		this.coordinates = coordinates;
		this.network = network;
		this.url = url;

		this.verified = verified;
		this.clustered = clustered;
		this.clusterCount = clusterCount;
	}
}
