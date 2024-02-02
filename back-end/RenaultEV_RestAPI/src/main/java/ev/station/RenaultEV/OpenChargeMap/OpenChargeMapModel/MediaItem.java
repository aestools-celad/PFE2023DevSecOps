
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class MediaItem {

    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("ChargePointID")
    @Expose
    private Integer chargePointID;
    @SerializedName("ItemURL")
    @Expose
    private String itemURL;
    @SerializedName("ItemThumbnailURL")
    @Expose
    private String itemThumbnailURL;
    @SerializedName("Comment")
    @Expose
    private String comment;
    @SerializedName("IsEnabled")
    @Expose
    private Boolean isEnabled;
    @SerializedName("IsVideo")
    @Expose
    private Boolean isVideo;
    @SerializedName("IsFeaturedItem")
    @Expose
    private Boolean isFeaturedItem;
    @SerializedName("IsExternalResource")
    @Expose
    private Boolean isExternalResource;
    @SerializedName("MetadataValue")
    @Expose
    private Object metadataValue;
    @SerializedName("User")
    @Expose
    private User__1 user;
    @SerializedName("DateCreated")
    @Expose
    private String dateCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargePointID() {
        return chargePointID;
    }

    public void setChargePointID(Integer chargePointID) {
        this.chargePointID = chargePointID;
    }

    public String getItemURL() {
        return itemURL;
    }

    public void setItemURL(String itemURL) {
        this.itemURL = itemURL;
    }

    public String getItemThumbnailURL() {
        return itemThumbnailURL;
    }

    public void setItemThumbnailURL(String itemThumbnailURL) {
        this.itemThumbnailURL = itemThumbnailURL;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public Boolean getIsFeaturedItem() {
        return isFeaturedItem;
    }

    public void setIsFeaturedItem(Boolean isFeaturedItem) {
        this.isFeaturedItem = isFeaturedItem;
    }

    public Boolean getIsExternalResource() {
        return isExternalResource;
    }

    public void setIsExternalResource(Boolean isExternalResource) {
        this.isExternalResource = isExternalResource;
    }

    public Object getMetadataValue() {
        return metadataValue;
    }

    public void setMetadataValue(Object metadataValue) {
        this.metadataValue = metadataValue;
    }

    public User__1 getUser() {
        return user;
    }

    public void setUser(User__1 user) {
        this.user = user;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

}
