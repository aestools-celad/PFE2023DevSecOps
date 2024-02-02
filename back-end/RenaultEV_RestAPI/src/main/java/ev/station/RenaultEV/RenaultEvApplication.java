package ev.station.RenaultEV;

import ev.station.RenaultEV.oauth2.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)

public class RenaultEvApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenaultEvApplication.class, args);
	}

}
