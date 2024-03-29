
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class StatusType {

    @SerializedName("IsOperational")
    @Expose
    private Boolean isOperational;
    @SerializedName("IsUserSelectable")
    @Expose
    private Boolean isUserSelectable;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;

    public Boolean getIsOperational() {
        return isOperational;
    }

    public void setIsOperational(Boolean isOperational) {
        this.isOperational = isOperational;
    }

    public Boolean getIsUserSelectable() {
        return isUserSelectable;
    }

    public void setIsUserSelectable(Boolean isUserSelectable) {
        this.isUserSelectable = isUserSelectable;
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
