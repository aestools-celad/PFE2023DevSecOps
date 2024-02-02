package ev.station.RenaultEV.RenaultEv.ChargelocationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargeLocationMockModel_OCM {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    int ge_id ;
    @Column(columnDefinition="TEXT")
    String name  ;
    @Type(type = "string-array")
    @Column(
            name = "chargepoints",
            columnDefinition = "text[]"
    )
    String[] chargepoints ;

    @Column(name = "city",columnDefinition = "TEXT")
    String city ;
    @Column(name = "country",columnDefinition = "TEXT")
    String country;
    @Column(name = "postcode",columnDefinition = "TEXT")
    String postcode;
    @Column(name = "street",columnDefinition = "TEXT")
    String street ;
    @Column(name = "lat")
    double lat ;
    @Column(name = "lng")
    double lng  ;
    boolean network;
    @Column(columnDefinition="TEXT")
    String url;
    boolean verified  ;
    boolean clustered ;
    int clusterCount ;
    @Column(columnDefinition="TEXT")
    String price  ;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ChargeLocationMockModel_OCM()
    {
    }

    public ChargeLocationMockModel_OCM(double lat, double lng, boolean clustered, int clusterCount) {
        this.lat = lat;
        this.lng = lng;
        this.clustered = clustered;
        this.clusterCount = clusterCount;
    }

    public ChargeLocationMockModel_OCM(Integer id, String[] chargepoints, int ge_id, String name, String city, String country, String postcode, String street, double lat, double lng, boolean network, String url, boolean verified, boolean clustered, int clusterCount) {
        this.id = id;
        this.chargepoints = chargepoints;
        this.ge_id = ge_id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.street = street;
        this.lat = lat;
        this.lng = lng;
        this.network = network;
        this.url = url;
        this.verified = verified;
        this.clustered = clustered;
        this.clusterCount = clusterCount;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }





    public String[] getChargepoints() {
        return chargepoints;
    }

    public void setChargepoints(String[] chargepoints) {
        this.chargepoints = chargepoints;
    }

    public int getGe_id() {
        return ge_id;
    }

    public void setGe_id(int ge_id) {
        this.ge_id = ge_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }







    public boolean isNetwork() {
        return network;
    }

    public void setNetwork(boolean network) {
        this.network = network;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isClustered() {
        return clustered;
    }

    public void setClustered(boolean clustered) {
        this.clustered = clustered;
    }

    public int getClusterCount() {
        return clusterCount;
    }

    public void setClusterCount(int clusterCount) {
        this.clusterCount = clusterCount;
    }

}
