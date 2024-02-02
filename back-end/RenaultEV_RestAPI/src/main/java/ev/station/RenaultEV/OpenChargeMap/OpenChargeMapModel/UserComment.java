
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class UserComment {

    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("ChargePointID")
    @Expose
    private Integer chargePointID;
    @SerializedName("CommentTypeID")
    @Expose
    private Integer commentTypeID;
    @SerializedName("CommentType")
    @Expose
    private CommentType commentType;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Comment")
    @Expose
    private String comment;
    @SerializedName("Rating")
    @Expose
    private Object rating;
    @SerializedName("RelatedURL")
    @Expose
    private String relatedURL;
    @SerializedName("DateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("User")
    @Expose
    private User user;
    @SerializedName("CheckinStatusTypeID")
    @Expose
    private Integer checkinStatusTypeID;
    @SerializedName("CheckinStatusType")
    @Expose
    private CheckinStatusType checkinStatusType;
    @SerializedName("IsActionedByEditor")
    @Expose
    private Boolean isActionedByEditor;

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

    public Integer getCommentTypeID() {
        return commentTypeID;
    }

    public void setCommentTypeID(Integer commentTypeID) {
        this.commentTypeID = commentTypeID;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getRelatedURL() {
        return relatedURL;
    }

    public void setRelatedURL(String relatedURL) {
        this.relatedURL = relatedURL;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCheckinStatusTypeID() {
        return checkinStatusTypeID;
    }

    public void setCheckinStatusTypeID(Integer checkinStatusTypeID) {
        this.checkinStatusTypeID = checkinStatusTypeID;
    }

    public CheckinStatusType getCheckinStatusType() {
        return checkinStatusType;
    }

    public void setCheckinStatusType(CheckinStatusType checkinStatusType) {
        this.checkinStatusType = checkinStatusType;
    }

    public Boolean getIsActionedByEditor() {
        return isActionedByEditor;
    }

    public void setIsActionedByEditor(Boolean isActionedByEditor) {
        this.isActionedByEditor = isActionedByEditor;
    }

}
