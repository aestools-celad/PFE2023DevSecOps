    package ev.station.RenaultEV.RenaultEv;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel_OCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LocalRepository_OCM extends JpaRepository<ChargeLocationMockModel_OCM, Long> {
    /*List <ChargeLocationMockModel_OCM> findByCountry_ocm(String country);*/

    @Query("select c from ChargeLocationMockModel_OCM c " +
            "where c.lat between ?1 and ?2 and c.lng between ?3 and ?4")
    List<ChargeLocationMockModel_OCM> findByCoordinates_latBetweenAndCoordinates_lngBetween(double coordinates_latStart, double coordinates_latEnd, double coordinates_lngStart, double coordinates_lngEnd);

    @Query("select count(c) from ChargeLocationMockModel_OCM c where c.lat between ?1 and ?2 and c.lng between ?3 and ?4")
    long countByLatIsBetweenAndLngIsBetween(double latStart, double latEnd, double lngStart, double lngEnd);
    @Query("select c from ChargeLocationMockModel_OCM c " +
            "where SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)) < ?3 "
    )
    List<ChargeLocationMockModel_OCM> findByRadius(double lat, double lng,double radius);
    @Query("select c from ChargeLocationMockModel_OCM c " +
            "where 0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2))) < ?3 "
    )
    List<ChargeLocationMockModel_OCM> findByRadiusKm(double lat, double lng,double radius);

    @Query("select c from ChargeLocationMockModel_OCM c " +
            "where 0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)))=(select MIN(0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)))) from ChargeLocationMockModel c )")
            List<ChargeLocationMockModel_OCM>findNearest(double lat, double lng);

    @Query("select c.ge_id from ChargeLocationMockModel_OCM c")
    List<Integer> getAllIds();

    @Query("SELECT c FROM ChargeLocationMockModel_OCM c WHERE c.name= ?1")
    Optional<ChargeLocationMockModel_OCM> findChargelocationbyName(String name)  ;

    @Query("SELECT c FROM ChargeLocationMockModel_OCM c WHERE c.id= ?1")
    Optional<ChargeLocationMockModel_OCM> findChargelocationbyId(int id);

    @Query("select c from ChargeLocationMockModel_OCM c where c.ge_id=?1")
    Optional<ChargeLocationMockModel_OCM> findbyGeId(int ge_id) ;

}
