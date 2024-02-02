package ev.station.RenaultEV.RenaultEv;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@CrossOrigin(origins = "*")

@RestController
public class ChargeLocationManual {
 /*   String  Manual =Files.readString(Path.of("./manual.txt"));

    public ChargeLocationManual() throws IOException {
    }

    @GetMapping("/help")
    public @ResponseBody String helpManual()
    {

        return Manual ;
    }*/
}
