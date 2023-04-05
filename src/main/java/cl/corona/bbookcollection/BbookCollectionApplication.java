package cl.corona.bbookcollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class BbookCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbookCollectionApplication.class, args);
	}

}
