package pl.put.poznan.info.logic.dataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single building containing multiple levels, which are made of Rooms.
 * Implements the ComponentLocation interface.
 */
public class CompositeBuilding implements ComponentLocation {
    private String id;
    private String name;
    @JsonProperty("list_of_levels")
    private ArrayList<CompositeFloor> listOfLevels = new ArrayList<CompositeFloor>();

    public CompositeBuilding(){
    }

    /**
     * Constructs a CompositeBuilding object.
     * @param id The unique identifier of the building.
     * @param name The name of the building.
     */
    public CompositeBuilding(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructs a CompositeBuilding object.
     * @param id The unique identifier of the building.
     */
    public CompositeBuilding(String id) {
        this(id,null);
    }


    /**
     * Retrieves the unique identifier of the building.
     * @return The unique identifier of the building.
     */
    @Override
    public String getId() {
        return id;
    }


    /**
     * Retrieves the name of the building.
     * @return The name of the building.
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * Adds a location (Floor object) to the building.
     * @param location The location (Floor object) to be added.
     */
    public void addLocation(CompositeFloor location) {
        listOfLevels.add(location);
    }

    /**
     * Removes a location (Floor object) from the building.
     * @param location The location (Floor object) to be removed.
     */
    public void removeLocation(CompositeFloor location) {
        listOfLevels.remove(location);
    }

    /**
     * Calculates the total area of the building.
     * @return The total area of the building.
     */
    @Override
    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (ComponentLocation location: listOfLevels){
            totalArea += location.calculateTotalArea();
        }
        return totalArea;
    }

    /**
     * Calculates the total volume of the building.
     * @return The total volume of the building.
     */
    @Override
    public double calculateTotalVolume() {
        // TO IMPLEMENT WIKTORIA
        return 0.0;
    }

    /**
     * Calculates the total heating energy consumption of the building.
     * @return The total heating energy consumption of the building.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        // TO IMPLEMENT
        return 0.0;
    }

    /**
     * Calculates the total lighting power consumption of the building.
     * @return The total lighting power consumption of the building.
     */
    @Override
    public double calculateTotalLightingPower() {
        // TO IMPLEMENT
        return  0.0;
    }
}
