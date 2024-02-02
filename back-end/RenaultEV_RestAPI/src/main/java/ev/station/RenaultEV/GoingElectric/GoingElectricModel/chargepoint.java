/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric.GoingElectricModel;

public class chargepoint {
	String type  ;
	double power  ;
	int count  ;
	public chargepoint(String type, double power, int count) {
		this.type = type;
		this.power = power;
		this.count = count;
	}

	public String getType() {
		return type;
	}
	public double getPower() {
		return power;
	}

	public int getCount() {
		return count;
	}  ;

	@Override
	public String toString() {
		return "chargepoint{" +
				"type='" + type + '\'' +
				", power=" + power +
				", count=" + count +
				'}';
	}
}
