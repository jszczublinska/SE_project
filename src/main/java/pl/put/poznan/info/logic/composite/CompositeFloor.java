package pl.put.poznan.info.logic.composite;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Represents a single floor is a part of building and contains multiple rooms.
 * Implements the ComponentLocation interface.
 */
public class CompositeFloor implements ComponentLocation{

    private String id;
    private String name;
    private ArrayList<ComponentLocation> listOfRooms =  new ArrayList<ComponentLocation>();


    /**
     * Default constructor for CompositeFloor object.
     */
    public CompositeFloor(){
    }

    /**
     * Constructs a CompositeFloor object.
     * @param id The unique identifier of the floor.
     * @param name The name of the floor.
     */
    public CompositeFloor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructs a CompositeFloo r object.
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
    public void addLocation(ComponentLocation location) {
        listOfRooms.add(location);
    }

    /**
     * Retrieves a list of sub-locations: here rooms within location.
     * @return an ArrayList of objects representing rooms.
     */
    @Override
    public ArrayList<ComponentLocation> getList() {
        return listOfRooms;
    }

    /**
     * Removes a location (Room object) from the floor.
     * @param location The location (Room object) to be removed.
     */
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
        double totalVolume = 0.0;

        for(ComponentLocation location: listOfRooms){
            totalVolume += location.calculateTotalVolume();
        }
        return totalVolume;
    }

    /**
     * Calculates the total heating energy consumption of the floor.
     * @return The total heating energy consumption of the floor.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        double totalHeating = 0.0;
        for(ComponentLocation location: listOfRooms){
            totalHeating += location.calculateTotalHeatingEnergy();
        }
        return totalHeating/calculateTotalVolume();
    }

    /**
     * Calculates the total lighting power consumption of the floor.
     * @return The total lighting power consumption of the floor.
     */
    @Override
    public double calculateTotalLightingPower() {
        double totalLightening = 0.0;

        for(ComponentLocation location: listOfRooms){
            totalLightening += location.calculateTotalLightingPower();
        }
        return  totalLightening/ calculateTotalArea();
    }

    /**
     * Calculates the average water consumption of the floor.
     * @return The average water consumption of the floor.
     */
    @Override
    public double calculateTotalWaterConsumption() {
        double totalWater = 0.0;

        for(ComponentLocation location: listOfRooms){
            totalWater += location.calculateTotalWaterConsumption();
        }
        return  totalWater;
    }

    /**
     * Accepts a visitor and lets it perform its operation on this location.
     * @param visitor   visitor to accept
     * @return          BuildingInfo object containing information accordingly to visitor
     */
    @Override
    public BuildingInfo accept(LocationVisitorInt visitor) {
        return visitor.visit(this);
    }

}
