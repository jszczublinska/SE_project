package pl.put.poznan.info.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
importsrc/main/java/pl/put/poznan/info/app/BuildingInfoApplication.java
import pl.put.poznan.transformer.dataStructures.*;
import pl.put.poznan.transformer.logic.BuildingInfo;
import pl.put.poznan.transformer.rest.BuildingInfoController;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.info.rest"})
public class BuildingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);

        //http://localhost:8080/

    }
}
