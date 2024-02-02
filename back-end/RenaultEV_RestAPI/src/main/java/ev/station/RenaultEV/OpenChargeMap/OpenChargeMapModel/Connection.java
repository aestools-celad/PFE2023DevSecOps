
package ev.station.RenaultEV.OpenChargeMap.OpenChargeMapModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Connection {

    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("ConnectionTypeID")
    @Expose
    private Integer connectionTypeID;
    @SerializedName("ConnectionType")
    @Expose
    private ConnectionType connectionType;
    @SerializedName("Reference")
    @Expose
    private Object reference;
    @SerializedName("StatusTypeID")
    @Expose
    private Object statusTypeID;
    @SerializedName("StatusType")
    @Expose
    private Object statusType;
    @SerializedName("LevelID")
    @Expose
    private Integer levelID;
    @SerializedName("Level")
    @Expose
    private Level level;
    @SerializedName("Amps")
    @Expose
    private Object amps;
    @SerializedName("Voltage")
    @Expose
    private Object voltage;
    @SerializedName("PowerKW")
    @Expose
    private Double powerKW;
    @SerializedName("CurrentTypeID")
    @Expose
    private Object currentTypeID;
    @SerializedName("CurrentType")
    @Expose
    private Object currentType;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Comments")
    @Expose
    private Object comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConnectionTypeID() {
        return connectionTypeID;
    }

    public void setConnectionTypeID(Integer connectionTypeID) {
        this.connectionTypeID = connectionTypeID;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public Object getReference() {
        return reference;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }

    public Object getStatusTypeID() {
        return statusTypeID;
    }

    public void setStatusTypeID(Object statusTypeID) {
        this.statusTypeID = statusTypeID;
    }

    public Object getStatusType() {
        return statusType;
    }

    public void setStatusType(Object statusType) {
        this.statusType = statusType;
    }

    public Integer getLevelID() {
        return levelID;
    }

    public void setLevelID(Integer levelID) {
        this.levelID = levelID;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Object getAmps() {
        return amps;
    }

    public void setAmps(Object amps) {
        this.amps = amps;
    }

    public Object getVoltage() {
        return voltage;
    }

    public void setVoltage(Object voltage) {
        this.voltage = voltage;
    }

    public Double getPowerKW() {
        return powerKW;
    }

    public void setPowerKW(Double powerKW) {
        this.powerKW = powerKW;
    }

    public Object getCurrentTypeID() {
        return currentTypeID;
    }

    public void setCurrentTypeID(Object currentTypeID) {
        this.currentTypeID = currentTypeID;
    }

    public Object getCurrentType() {
        return currentType;
    }

    public void setCurrentType(Object currentType) {
        this.currentType = currentType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

}
