package ev.station.RenaultEV.ClusteringUtils;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import org.hibernate.annotations.Immutable;

import javax.management.ImmutableDescriptor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cluster {
    public int getId() {
        return id;
    }

    private ArrayList<ChargeLocationMockModel> getChargelcoations() {
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

      ArrayList<ChargeLocationMockModel> chloc  ;
int clusterSize ;
double latitude  ;
double longitude ;



    public void setClusterSize(int clusterSize) {
        this.clusterSize = clusterSize;
    }

    public Cluster() {
    }

    public Cluster(int id, ArrayList<ChargeLocationMockModel> chloc, int i, double latitude, double longitude) {
        this.id = id;
        this.chloc= chloc;
        this.clusterSize= i;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ArrayList<ChargeLocationMockModel> getChargelocations() {
        return chloc;
    }

    public int getClusterCount() {
        return clusterSize ;
    }
}
