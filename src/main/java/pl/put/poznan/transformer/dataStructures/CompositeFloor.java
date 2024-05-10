package pl.put.poznan.transformer.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CompositeFloor implements ComponentLocation{

    private String id;
    private String name;
    private List<ComponentLocation> listOfRooms;

    public CompositeFloor(String id, String name) {
        this.id = id;
        this.name = name;
        this.listOfRooms = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addLocation(ComponentLocation location) {
        listOfRooms.add(location);
    }

    @Override
    public void removeLocation(ComponentLocation location) {
        listOfRooms.remove(location);
    }

    @Override
    public double calculateTotalArea() {
        // TO IMPLEMENT
        return 0.0;
    }

    @Override
    public double calculateTotalVolume() {
        // TO IMPLEMENT
        return 0.0;
    }

    @Override
    public double calculateTotalHeatingEnergy() {
        // TO IMPLEMENT
        return 0.0;
    }

    @Override
    public double calculateTotalLightingPower() {
        // TO IMPLEMENT
        return  0.0;
    }

}
