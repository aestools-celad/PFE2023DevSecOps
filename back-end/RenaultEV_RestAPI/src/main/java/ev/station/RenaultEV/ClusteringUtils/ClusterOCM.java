package ev.station.RenaultEV.ClusteringUtils;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel_OCM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class ClusterOCM {
    public int getId() {
        return id;
    }

    private ArrayList<ChargeLocationMockModel_OCM> getChargelcoations() {
        return chloc;
    }

    public int getClusterSize() {
        return clusterSize;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    @Id
    @Column(name = "id")
    int id  ;

      ArrayList<ChargeLocationMockModel_OCM> chloc  ;
int clusterSize ;
double latitude  ;
double longitude ;



    public void setClusterSize(int clusterSize) {
        this.clusterSize = clusterSize;
    }

    public ClusterOCM() {
    }

    public ClusterOCM(int id, ArrayList<ChargeLocationMockModel_OCM> chloc, int i, double latitude, double longitude) {
        this.id = id;
        this.chloc= chloc;
        this.clusterSize= i;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ArrayList<ChargeLocationMockModel_OCM> getChargelocations() {
        return chloc;
    }

    public int getClusterCount() {
        return clusterSize ;
    }
}
