
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class UsageType {

    @SerializedName("IsPayAtLocation")
    @Expose
    private Object isPayAtLocation;
    @SerializedName("IsMembershipRequired")
    @Expose
    private Object isMembershipRequired;
    @SerializedName("IsAccessKeyRequired")
    @Expose
    private Object isAccessKeyRequired;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;

    public Object getIsPayAtLocation() {
        return isPayAtLocation;
    }

    public void setIsPayAtLocation(Object isPayAtLocation) {
        this.isPayAtLocation = isPayAtLocation;
    }

    public Object getIsMembershipRequired() {
        return isMembershipRequired;
    }

    public void setIsMembershipRequired(Object isMembershipRequired) {
        this.isMembershipRequired = isMembershipRequired;
    }

    public Object getIsAccessKeyRequired() {
        return isAccessKeyRequired;
    }

    public void setIsAccessKeyRequired(Object isAccessKeyRequired) {
        this.isAccessKeyRequired = isAccessKeyRequired;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
