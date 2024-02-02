package ev.station.RenaultEV.RenaultEv;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LocalRepository extends JpaRepository<ChargeLocationMockModel, Long> {
    Page<ChargeLocationMockModel> findAll(Pageable pageable);
    List <ChargeLocationMockModel> findByCountry(String country);


    @Query("select c from ChargeLocationMockModel c " +
            "where c.lat between ?1 and ?2 and c.lng between ?3 and ?4")
    List<ChargeLocationMockModel> findByCoordinates_latBetweenAndCoordinates_lngBetween(double coordinates_latStart, double coordinates_latEnd, double coordinates_lngStart, double coordinates_lngEnd);

    @Query("select count(c) from ChargeLocationMockModel c where c.lat between ?1 and ?2 and c.lng between ?3 and ?4")
    long countByLatIsBetweenAndLngIsBetween(double latStart, double latEnd, double lngStart, double lngEnd);
    @Query("select c from ChargeLocationMockModel c " +
            "where SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)) < ?3 "
    )
    List<ChargeLocationMockModel> findByRadius(double lat, double lng,double radius);
    @Query("select c from ChargeLocationMockModel c " +
            "where 0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2))) < ?3 "
    )
    List<ChargeLocationMockModel> findByRadiusKm(double lat, double lng,double radius);

    @Query("select c from ChargeLocationMockModel c " +
            "where 0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)))=(select MIN(0.62 * (SQRT(POWER(69.1 * ( c.lat - ?1 ),  2) + POWER(69.1 * ( ?2  - c.lng )  * COS(c.lat / 57.3), 2)))) from ChargeLocationMockModel c )")
            List<ChargeLocationMockModel>findNearest(double lat, double lng);

    @Query("select c.ge_id from ChargeLocationMockModel c")
    List<Integer> getAllIds();

    @Query("SELECT c FROM ChargeLocationMockModel c WHERE c.name= ?1")
    Optional<ChargeLocationMockModel> findChargelocationbyName(String name)  ;

    @Query("SELECT c FROM ChargeLocationMockModel c WHERE c.id= ?1")
    Optional<ChargeLocationMockModel> findChargelocationbyId(int id);

    @Query("select c from ChargeLocationMockModel c where c.ge_id=?1")
    Optional<ChargeLocationMockModel> findbyGeId(int ge_id) ;

}
