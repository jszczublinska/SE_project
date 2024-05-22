package pl.put.poznan.info.logic.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Represents a single room which is part of the floor.
 * Implements the ComponentLocation interface.
 */

public class Room implements ComponentLocation {

    private static final Logger logger = LoggerFactory.getLogger(Room.class);

    private String id;
    private String name;
    @JsonProperty("area")
    private double area;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("lighting")
    private double lighting;
    @JsonProperty("heating")
    private float heating;

    /**
     * Default constructor for creating Room objects.
     * Used for JSON object creation.
     */
    public Room() {
        logger.debug("Default constructor called for Room");
    }

    /**
     * Constructor for a Room object
     *
     * @param id       The unique identifier of the room.
     * @param name     The name of the room.
     * @param area     The area of the room.
     * @param volume   The volume of the room.
     * @param lighting The level of lighting consumption.
     * @param heating  The level of heating energy consumption of the room.
     */
    public Room(String id, String name, double area, double volume, double lighting, float heating) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.volume = volume;
        this.lighting = lighting;
        this.heating = heating;
        logger.debug("Constructor with parameters called for Room with id: {}", id);

    }

    /**
     * Constructor for a Room object
     *
     * @param id       The unique identifier of the room.
     * @param area     The area of the room.
     * @param volume   The volume of the room.
     * @param lighting The amount of lighting in the room.
     * @param heating  The level of heating energy consumption of the room.
     */
    public Room(String id, double area, double volume, double lighting, float heating) throws IllegalArgumentException {
        if (id == null || area <= 0 || volume <= 0 || lighting <= 0 || heating <= 0) {
            throw new IllegalArgumentException("Invalid parameters for Room constructor");
        }

        // Assuming you have a logger set up
        logger.debug("Constructor with parameters called for Room with id: {}", id);

        this.id = id;
        this.area = area;
        this.volume = volume;
        this.lighting = lighting;
        this.heating = heating;

    }

    /**
     * Retrieves the unique identifier of the room.
     * 
     * @return The unique identifier of the room.
     */
    @Override
    public String getId() {
        logger.debug("getId called, returning: {}", this.id);
        return this.id;
    }

    /**
     * Retrieves the name of the room.
     * 
     * @return The name of the room.
     */
    @Override
    public String getName() {
        logger.debug("getName called, returning: {}", this.name);
        return this.name;
    }

    /**
     * Calculates the total area of the room.
     * 
     * @return The total area of the room.
     */
    @Override
    public double calculateTotalArea() {
        logger.debug("calculateTotalArea called, returning: {}", this.area);
        return this.area;
    }

    /**
     * Calculates the total volume of the room.
     * 
     * @return The total volume of the room.
     */
    @Override
    public double calculateTotalVolume() {
        logger.debug("calculateTotalVolume called, returning: {}", this.volume);
        return this.volume;
    }

    /**
     * Retrieves the heating energy consumption of the room.
     * 
     * @return The heating energy consumption of the room.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        logger.debug("calculateTotalHeatingEnergy called, returning: {}", this.heating);
        return this.heating;
    }

    /**
     * Retrieves the total lighting power consumption of the room.
     * 
     * @return The lighting power consumption of the room.
     */
    @Override
    public double calculateTotalLightingPower() {
        logger.debug("calculateTotalLightingPower called, returning: {}", this.lighting);

        // double lumen = 1500.00; // number of lumen per m2
        // double area = calculateTotalArea();
        // double totalLighting = (area * lumen)/10; // 1 W equals 10 lumen
        return this.lighting;
    }

    /**
     * Calculates the average water consumption of the room.
     * 
     * @return The average water consumption of the room.
     */
    @Override
    public double calculateTotalWaterConsumption() {
        logger.debug("calculateTotalWaterConsumption called, returning: {}", 2 * this.area);
        return 2 * this.area;
    }

    /**
     * Adds a location (Room object) to the building.
     * 
     * @param location location where the Room should be added
     */
    @Override
    public void addLocation(ComponentLocation location) {
        logger.debug("addLocation called, returning: nothing");
    }

    /**
     * Retrieves empty list, as room has no sub-locations.
     * 
     * @return empty list
     */
    @Override
    public ArrayList getList() {
        logger.debug("getList called, returning: null");
        return null;
    }

    /**
     * Accepts a visitor and lets it perform its operation on this location.
     * 
     * @param visitor visitor to accept
     * @return BuildingInfo object containing information accordingly to visitor
     */
    @Override
    public BuildingInfo accept(LocationVisitorInt visitor) {
        logger.debug("accept method called with visitor: {}", visitor.getClass().getSimpleName());
        return visitor.visit(this);
    }
}
