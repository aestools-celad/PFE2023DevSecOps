package ev.station.RenaultEV.RenaultEv.ChargelocationModel;

import javax.persistence.*;

@Table
@Entity
public class ChargeLocationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    int ge_id  ;

    @Column(name="imageBinaryStream",columnDefinition ="BYTEA")
    byte[] image  ;

    public ChargeLocationImage() {
    }

    public ChargeLocationImage(int ge_id, byte[] image) {
        this.ge_id = ge_id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public int getGe_id() {

        return ge_id;
    }
}
