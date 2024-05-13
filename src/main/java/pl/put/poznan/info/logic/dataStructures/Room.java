package pl.put.poznan.info.logic.dataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

/**
 * Represents a single room which is part of the floor.
 * Implements the ComponentLocation interface.
 */

public class Room implements ComponentLocation {

    private String id;
    private String name ;
    @JsonProperty("height")
    private float height;
    @JsonProperty("length")
    private double length;
    @JsonProperty("width")
    private double width;
    @JsonProperty("heating")
    private double heating;
    @JsonProperty("lightening")
    private double lightening;

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
     * @param width The width of the room.
     * @param length The length of the room.
     * @param height The height of the room.
     * @param heating The level of heating energy consumption of the room.
     * @param lightening The level of lightening consumption.
     */
    public Room(String id, String name, double width, double length, float height, double heating, double lightening) {
        this.id = id;
        this.name = name;
        this.heating = heating;
        this.length = length;
        this.width = width;
        this.height = height;
        this.lightening = lightening;
    }

    /**
     * Constructor for a Room object
     *
     * @param id The unique identifier of the room.
     * @param width The width of the room.
     * @param length The length of the room.
     * @param height The height of the room.
     * @param heating The level of heating energy consumption of the room.
     */
    public Room(String id, double width, double length, float height, double heating, double lightening) {
        this(id, null, width, length, height, heating, lightening);
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
        return this.width * this.length;
    }

    /**
     * Calculates the total volume of the room.
     * @return The total volume of the room.
     */
    @Override
    public double calculateTotalVolume() {
        return (this.width * this.length * this.height);
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
        //double totalLightening = (area * lumen)/10; // 1 W equals 10 lumen
        return this.lightening;
    }

    @Override
    public BuildingInfo accept(LocationVisitorInt visitor) {
        return visitor.visit(this);
    }
}

