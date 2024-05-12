package pl.put.poznan.info.dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single floor is a part of building and contains multiple rooms.
 * Implements the ComponentLocation interface.
 */
public class CompositeFloor implements ComponentLocation{

    private String id;
    private String name;
    private List<ComponentLocation> listOfRooms;

    /**
     * Constructs a CompositeFloor object.
     * @param id The unique identifier of the floor.
     * @param name The name of the floor.
     */
    public CompositeFloor(String id, String name) {
        this.id = id;
        this.name = name;
        this.listOfRooms = new ArrayList<>();
    }

    /**
     * Constructs a CompositeFloor object.
     * @param id The unique identifier of the floor.
     */
    public CompositeFloor(String id) {
        this(id, null);
    }

    /**
     * Retrieves the unique identifier of the floor.
     * @return The unique identifier of the floor.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the floor.
     * @return The name of the floor.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a location (Room object) to the floor.
     * @param location The location (Room object) to be added.
     */
    @Override
    public void addLocation(ComponentLocation location) {
        listOfRooms.add(location);
    }

    /**
     * Removes a location (Room object) from the floor.
     * @param location The location (Room object) to be removed.
     */
    @Override
    public void removeLocation(ComponentLocation location) {
        listOfRooms.remove(location);
    }

    /**
     * Calculates the total area of the floor.
     * @return The total area of the floor.
     */
    @Override
    public double calculateTotalArea() {
        double totalArea = 0.0;

        for (ComponentLocation location : listOfRooms) {
            totalArea += location.calculateTotalArea();
        }
        return totalArea;
    }

    /**
     * Calculates the total volume of the floor.
     * @return The total volume of the floor.
     */
    @Override
    public double calculateTotalVolume() {
        // TO IMPLEMENT
        return 0.0;
    }

    /**
     * Calculates the total heating energy consumption of the floor.
     * @return The total heating energy consumption of the floor.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        // TO IMPLEMENT
        return 0.0;
    }

    /**
     * Calculates the total lighting power consumption of the floor.
     * @return The total lighting power consumption of the floor.
     */
    @Override
    public double calculateTotalLightingPower() {
        // TO IMPLEMENT
        return  0.0;
    }

}
