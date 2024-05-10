package pl.put.poznan.transformer.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CompositeBuilding implements ComponentLocation {
    private String id;
    private String name;
    private List<ComponentLocation> listOfLevels;

    public CompositeBuilding(String id, String name) {
        this.id = id;
        this.name = name;
        this.listOfLevels = new ArrayList<>();
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
        listOfLevels.add(location);
    }

    @Override
    public void removeLocation(ComponentLocation location) {
        listOfLevels.remove(location);
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
