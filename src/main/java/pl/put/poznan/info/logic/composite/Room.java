package pl.put.poznan.info.logic.composite;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Represents a single room which is part of the floor.
 * Implements the ComponentLocation interface.
 */

public class Room implements ComponentLocation {

    private String id;
    private String name ;
    @JsonProperty("area")
    private double area;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("lightning")
    private double lightning;
    @JsonProperty("heating")
    private float heating;

    /**
     * Default constructor for creating Room objects.
     * Used for JSON object creation.
     */
    public Room(){
    }


    /**
     * Constructor for a Room object
     *
     * @param id The unique identifier of the room.
     * @param name The name of the room.
     * @param area The area of the room.
     * @param volume The volume of the room.
     * @param lightning The level of lightning consumption.
     * @param heating The level of heating energy consumption of the room.
     */
    public Room(String id, String name, double area, double volume, double lightning, float heating) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.volume = volume;
        this.lightning = lightning;
        this.heating = heating;
    }

    /**
     * Constructor for a Room object
     *
     * @param id The unique identifier of the room.
     * @param area The area of the room.
     * @param volume The volume of the room.
     * @param lightning The amount of lighting in the room.
     * @param heating The level of heating energy consumption of the room.
     */
    public Room(String id, double area, double volume, double lightning, float heating) {
        this(id, null, area, volume, lightning, heating);
    }

    /**
     * Retrieves the unique identifier of the room.
     * @return The unique identifier of the room.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Retrieves the name of the room.
     * @return The name of the room.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Calculates the total area of the room.
     * @return The total area of the room.
     */
    @Override
    public double calculateTotalArea() {
        return this.area;
    }

    /**
     * Calculates the total volume of the room.
     * @return The total volume of the room.
     */
    @Override
    public double calculateTotalVolume() {
        return this.volume;
    }

    /**
     * Retrieves the heating energy consumption of the room.
     * @return The heating energy consumption of the room.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        return this.heating;
    }

    /**
     * Retrieves the total lighting power consumption of the room.
     * @return The lighting power consumption of the room.
     */
    @Override
    public double calculateTotalLightingPower() {

        //double lumen = 1500.00; // number of lumen per m2
        //double area = calculateTotalArea();
        //double totalLightning = (area * lumen)/10; // 1 W equals 10 lumen
        return this.lightning;
    }

    /**
     * Adds a location (Room object) to the building.
     * @param location      location where the Room should be added
     */
    @Override
    public void addLocation(ComponentLocation location) {

    }

    /**
     * Retrieves empty list, as room has no sub-locations.
     * @return empty list
     */
    @Override
    public ArrayList getList() {
        return null;
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

