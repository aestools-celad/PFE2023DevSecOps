/*
 * Copyright (c) 2022 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package ev.station.RenaultEV.GoingElectric.GoingElectricModel;


import org.hibernate.HibernateException;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class address {

	String city  ;
	String country  ;
	String postcode ;
	String street ;



	public address() {
	}

	public address(String city, String country, String postcode, String street) {
		this.city = city;
		this.country = country;
		this.postcode = postcode;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getStreet() {
		return street;
	}

	@Override
	public String toString() {
		return "address{" +
				"city='" + city + '\'' +
				", country='" + country + '\'' +
				", postcode='" + postcode + '\'' +
				", street='" + street + '\'' +
				'}';
	}
}
