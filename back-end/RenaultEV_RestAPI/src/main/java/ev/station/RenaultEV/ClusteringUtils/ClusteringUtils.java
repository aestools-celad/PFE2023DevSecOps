package ev.station.RenaultEV.ClusteringUtils;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class ClusteringUtils implements Cloneable {


        static int OFFSET = 268435456;
        static double RADIUS = 85445659.4471;
        static double pi = 3.1444;
        static ChargeLocationMockModel ch;

        static boolean clusterFlag ;

        public static double lonToX ( double lon){
        return Math.round(OFFSET + RADIUS * lon * pi / 180);
    }

        public static double latToY ( double lat){
        return Math.round(OFFSET
                - RADIUS
                * Math.log((1 + Math.sin(lat * pi / 180))
                / (1 - Math.sin(lat * pi / 180))) / 2);
    }
        public static int pixelDistance ( double lat1, double lon1, double lat2,
        double lon2, int zoom){
        double x1 = lonToX(lon1);
        double y1 = latToY(lat1);

        double x2 = lonToX(lon2);
        double y2 = latToY(lat2);

        return (int) (Math
                .sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2))) >> (21 - zoom);
    }
        // use this function for custering seperated from station model

    public static List<Cluster> clusterV3OldModel(List<ChargeLocationMockModel> chargelocations, int zoom, int minPixelDistance)
    {
        List<ChargeLocationMockModel> chargelocations_Copy= chargelocations ;
        List<ChargeLocationMockModel> stationsPerCluster= new ArrayList<>() ;
        List<Cluster> clusterList= new ArrayList<>() ;

        for (int i=0 ; chargelocations.size()>0; i++) {

            stationsPerCluster.clear();

            for (int j = 1; j < chargelocations.size(); j++) {
                int pixelDistance = pixelDistance(
                        chargelocations.get(i).getLat()
                        , chargelocations.get(i).getLng()
                        , chargelocations.get(j).getLat()
                        , chargelocations.get(j).getLng()
                        , zoom
                );

                if (pixelDistance < minPixelDistance) {
                    stationsPerCluster.add(chargelocations.get(j));

                    chargelocations.remove(j);
                    j=j-1 ;
                }
            }
            stationsPerCluster.add( chargelocations.get(i));

            ArrayList<ChargeLocationMockModel> stationsPerClusterClone=new ArrayList<>(stationsPerCluster)  ;


            final Cluster cluster ;
            if (stationsPerCluster.size() >= 1){
                 cluster = new Cluster(clusterList.size(), (ArrayList<ChargeLocationMockModel>) stationsPerClusterClone,
                        stationsPerCluster.size(), chargelocations.get(i).getLat(), chargelocations.get(i).getLng());
                clusterList.add(cluster);

            }
            chargelocations.remove(i);
            i = -1;
        }
        return clusterList  ;



    }
        public static List<ChargeLocationMockModel> clusterV3(List<ChargeLocationMockModel> chargelocations, int zoom, int minPixelDistance)
        {

            List<ChargeLocationMockModel> stationsPerCluster= new ArrayList<>() ;
            List<ChargeLocationMockModel> clusterList= new ArrayList<>() ;

            for (int i=0 ; chargelocations.size()>0; i++) {

                stationsPerCluster.clear();

                for (int j = 1; j < chargelocations.size(); j++) {
                    int pixelDistance = pixelDistance(
                            chargelocations.get(i).getLat()
                            , chargelocations.get(i).getLng()
                            , chargelocations.get(j).getLat()
                            , chargelocations.get(j).getLng()
                            , zoom
                    );

                    if (pixelDistance < minPixelDistance) {
                        stationsPerCluster.add(chargelocations.get(j));

                        chargelocations.remove(j);
                        j=j-1 ;
                    }
                }
                    stationsPerCluster.add( chargelocations.get(i));


                OptionalDouble average_Lat = stationsPerCluster
                        .stream()
                        .mapToDouble(ChargeLocationMockModel::getLat)
                        .average();
                OptionalDouble average_Lng = stationsPerCluster
                        .stream()
                        .mapToDouble(ChargeLocationMockModel::getLng)
                        .average();
                //double average_lat_double = average_Lat.orElse(-1);
                //double average_lng_double = average_Lng.orElse(-1);
                double min_lat_double = stationsPerCluster.stream().min(Comparator.comparing(ChargeLocationMockModel::getLat)).get().getLat();
                double min_lng_double = stationsPerCluster.stream().min(Comparator.comparing(ChargeLocationMockModel::getLng)).get().getLng();
                double max_lat_double = stationsPerCluster.stream().max(Comparator.comparing(ChargeLocationMockModel::getLat)).get().getLat();
                double max_lng_double = stationsPerCluster.stream().max(Comparator.comparing(ChargeLocationMockModel::getLng)).get().getLng();

                ChargeLocationMockModel cluster;
                if (stationsPerCluster.size() > 1){
                    cluster = new ChargeLocationMockModel((min_lat_double+max_lat_double)/2,(min_lng_double+max_lng_double)/2, true, stationsPerCluster.size());
                clusterList.add(0, cluster);}
                else  if (stationsPerCluster.size()==1){
                    cluster = chargelocations.get(i);
                    cluster.setClusterCount(1);
                    clusterList.add(0, cluster);
                }
                chargelocations.remove(i);
                i = -1;
            }

            return clusterList  ;



        }

        public static int countAfterClustering (ArrayList < ChargeLocationMockModel > chargelocations,int zoom,
        int minPixelDistance)
        {
            int sum = clusterV3(chargelocations, zoom, minPixelDistance).stream().mapToInt(ChargeLocationMockModel::getClusterCount).sum();
            return sum;
        }
    }
