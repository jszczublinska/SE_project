package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.dataStructures.*;
import pl.put.poznan.transformer.logic.BuildingInfo;
import pl.put.poznan.transformer.rest.BuildingInfoController;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class BuildingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);

        //http://localhost:8080/

    }
}
