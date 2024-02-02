package ev.station.RenaultEV.RenaultEv;

import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LocalImageRepository extends JpaRepository<ChargeLocationImage , Long> {
    @Query("select c.image from ChargeLocationImage c where c.ge_id = ?1")
    Optional<byte[]> findByGeId(int ge_id);

    @Query("select c.ge_id from ChargeLocationImage c")
    List<Integer> getAllIds();

}
