
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CheckinStatusType {

    @SerializedName("IsPositive")
    @Expose
    private Boolean isPositive;
    @SerializedName("IsAutomatedCheckin")
    @Expose
    private Boolean isAutomatedCheckin;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;

    public Boolean getIsPositive() {
        return isPositive;
    }

    public void setIsPositive(Boolean isPositive) {
        this.isPositive = isPositive;
    }

    public Boolean getIsAutomatedCheckin() {
        return isAutomatedCheckin;
    }

    public void setIsAutomatedCheckin(Boolean isAutomatedCheckin) {
        this.isAutomatedCheckin = isAutomatedCheckin;
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
