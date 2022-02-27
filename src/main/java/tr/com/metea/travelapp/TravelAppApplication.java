package tr.com.metea.travelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class TravelAppApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Turkey"));
    }

    public static void main(String[] args) {
        SpringApplication.run(TravelAppApplication.class, args);
    }

}
