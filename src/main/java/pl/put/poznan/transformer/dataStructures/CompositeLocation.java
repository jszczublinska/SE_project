package pl.put.poznan.transformer.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CompositeLocation implements ComponentLocation {
    private String id;
    private String name;
    private List<ComponentLocation> locations;

    public CompositeLocation(String id, String name) {
        this.id = id;
        this.name = name;
        this.locations = new ArrayList<>();
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
        locations.add(location);
    }

    @Override
    public void removeLocation(ComponentLocation location) {
        locations.remove(location);
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
