package ev.station.RenaultEV;

import ev.station.RenaultEV.RenaultEv.ChargeLocationController;
import ev.station.RenaultEV.RenaultEv.ChargeLocationService;
import ev.station.RenaultEV.RenaultEv.ChargelocationModel.ChargeLocationMockModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ChargeLocationControllerTest {

    @Mock
    private ChargeLocationService chargeLocationService;

    @InjectMocks
    private ChargeLocationController chargeLocationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCountry() {
        String country = "Malta";
        List<ChargeLocationMockModel> expectedLocations = Arrays.asList(
                new ChargeLocationMockModel("Spanien"),
                new ChargeLocationMockModel("Malta")
        );

        // Mock the behavior of chargeLocationService.findByCountry
        when(chargeLocationService.findByCountry(country)).thenReturn(expectedLocations);

        // Call the controller method
        List<ChargeLocationMockModel> actualLocations = chargeLocationController.findByCountry(country);

        // Verify the result
        assertEquals(expectedLocations, actualLocations);
    }
}
