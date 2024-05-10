package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.dataStructures.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BuildingInfo {

    CompositeBuilding mainBuilding = new CompositeBuilding("1", "Centrum wykladowe");

    // making levels
    CompositeFloor level0 = new CompositeFloor("101", "parter");
    CompositeFloor level1 = new CompositeFloor("102", "1 pietro");
    // making rooms
    Room room1 = new Room("201", "pokoj Lesia", 10, 2, 2, 50, 20);
    Room room2 = new Room("202", "pokoj Dareczka", 60, 120, 2.5, 85, 24.9);

    // adding them the the level0
    public BuildingInfo(){
        mainBuilding.addLocation(level0);
        mainBuilding.addLocation(level1);
        level1.addLocation(room1);
        level1.addLocation(room2);
    }

    public String area(){
        return String.format("%.2f", mainBuilding.calculateTotalArea());
    }

    public String Info(){
        return (String.format("%s pokoj ma  powierzchnie %f m^2", room1.getName(), room1.calculateTotalArea()));
    }

}
