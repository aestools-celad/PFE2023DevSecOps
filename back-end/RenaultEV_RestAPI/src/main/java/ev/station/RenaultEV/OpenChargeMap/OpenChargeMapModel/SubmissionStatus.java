
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SubmissionStatus {

    @SerializedName("IsLive")
    @Expose
    private Boolean isLive;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
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
