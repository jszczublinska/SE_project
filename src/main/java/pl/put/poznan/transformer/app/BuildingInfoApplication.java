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

        System.out.printf("hello \n");

        // making a buidling
        CompositeLocation mainBuilding = new CompositeLocation("1", "Centrum wykladowe");

        // making levels
        CompositeLocation level0 = new CompositeLocation("101", "parter");
        CompositeLocation level1 = new CompositeLocation("102", "1 pietro");
        mainBuilding.addLocation(level0);
        mainBuilding.addLocation(level1);

        // making rooms
        Room room1 = new Room("201", "pokoj Lesia", 10, 2, 2, 50, 20);
        Room room2 = new Room("202", "pokoj Dareczka", 60, 120, 2.5, 85, 24.9);

        // adding them the the level0
        level1.addLocation(room1);
        level1.addLocation(room2);

        System.out.printf(String.format("%s pokoj ma  powierzchnie %f m^2 \n and volume %f m^3", room1.getName(), room1.calculateTotalArea(), room1.calculateTotalVolume()));;

//        BuildingInfoController BIC = new BuildingInfoController();
 //       String inf0 = BIC.get("/pokoj", "blabla");

        // jesli wpisesz strone http://localhost:8080/pokoj
        // to wyswietli ci sie info o pokoju Lesia, ten tutaj print wyswietla to samo
        System.out.printf(inf0);
    }
}
