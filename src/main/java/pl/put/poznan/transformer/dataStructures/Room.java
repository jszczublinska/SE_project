package pl.put.poznan.transformer.dataStructures;


/**
 * Represents a single room which is part of the floor.
 * Implements the ComponentLocation interface.
 */

public class Room implements ComponentLocation {

    private String id;
    private String name ;
    private double height;
    private double length;
    private double width;
    private double area;
    private double volume;
    private double heating;
    private double lighting;

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
     * @param lighting The total lighting power consumption of the room.
     */
    public Room(String id, String name, double width, double length, double height, double heating, double lighting) {
        this.id = id;
        this.name = name;
        this.heating = heating;
        this.lighting = lighting;
        this.length = length;
        this.width = width;
        this.height = height;
        this.area = width * length;
        this.volume = this.area * height;
    }

    /**
     * Constructor for a Room object
     *
     * @param id The unique identifier of the room.
     * @param width The width of the room.
     * @param length The length of the room.
     * @param height The height of the room.
     * @param heating The level of heating energy consumption of the room.
     * @param lighting The total lighting power consumption of the room.
     */
    public Room(String id, double width, double length, double height, double heating, double lighting) {
        this(id, null, width, length, height, heating, lighting);
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
     * Throws an UnsupportedOperationException because a room can not contain other locations.
     * @param location The location to be added, but will not be used.
     * @throws UnsupportedOperationException Always throws this exception.
     */
    @Override
    public void addLocation(ComponentLocation location) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot add location to a Room, as it is a leaf node.");
    }

    /**
     * Throws an UnsupportedOperationException because a room can not contain other locations.
     * @param location The location to be removed, but will not be used.
     * @throws UnsupportedOperationException Always throws this exception.
     */
    @Override
    public void removeLocation(ComponentLocation location)throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot remove location to a Room, as it is a leaf node.");
    }

    /**
     * Calculates the total area of the room.
     * @return The total area of the room.
     */
    @Override
    public double calculateTotalArea() {
        return (this.width * this.length);
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
        return this.lighting;
    }
}

