package ev.station.RenaultEV.GoingElectric;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoingElectricRipper {
    private final GoingElectricRepository goingElectricRepository ;

    public static double lat=-65.00000001d,lng =-28.00000001d  ;
    public static  double ne_lng=0 , ne_lat=0 ;
    static boolean startFlag=false ;
    static List<Integer> ids ;
    static List<Integer> removableIds ;
    int startkey =0;
    static int i ;




    public static boolean parseDoneFlag =false ;
    public static boolean startedParsingBounds = false;

    @Autowired
    public GoingElectricRipper(GoingElectricRepository goingElectricRepository) {
        this.goingElectricRepository=goingElectricRepository ;


    }







    public void parseWorldMap_fast()
    {

        goingElectricRepository.getChargeLocationsWithinParserBounds(startkey,-65, -160, 85 , 88);
        startkey+=500;
    }

    public String ripImageRepository()
    {
        if (!startFlag ) {
            ids = goingElectricRepository.getLocalRepository().getAllIds();
            removableIds=goingElectricRepository.getLocalImageRepository().getAllIds()  ;
            removableIds.stream().forEach(id->ids.remove(id));
            goingElectricRepository.getChargingLocationImage(ids.get(0), 500);
            startFlag=true ;
            i=0 ;
        }
        else {
            if (i< ids.size()-1) {
                i++;
                goingElectricRepository.getChargingLocationImage(ids.get(i), 500);

            }
        }
        return "parsing images for : "+ids.size()+" stations" ;

    }


}

