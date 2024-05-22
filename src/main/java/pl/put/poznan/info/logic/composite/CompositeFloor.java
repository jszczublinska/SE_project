package pl.put.poznan.info.logic.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Represents a single floor is a part of building and contains multiple rooms.
 * Implements the ComponentLocation interface.
 */
public class CompositeFloor implements ComponentLocation{

    private static final Logger logger = LoggerFactory.getLogger(CompositeFloor.class);

    private String id;
    private String name;
    private ArrayList<ComponentLocation> listOfRooms =  new ArrayList<ComponentLocation>();


    /**
     * Default constructor for CompositeFloor object.
     */
    public CompositeFloor(){logger.debug("Default constructor called for Floor");
    }

    /**
     * Constructs a CompositeFloor object.
     * @param id The unique identifier of the floor.
     * @param name The name of the floor.
     */
    public CompositeFloor(String id, String name) {
        this.id = id;
        this.name = name;
        logger.debug("Constructor for Floor run with parameters {}, {}", id, name);

    }

    /**
     * Constructs a CompositeFloor object.
     * @param id The unique identifier of the floor.
     */
    public CompositeFloor(String id) {
        this(id, null);
        logger.debug("Constructor for Floor run with parameter {}", id);

    }

    /**
     * Retrieves the unique identifier of the floor.
     * @return The unique identifier of the floor.
     */
    @Override
    public String getId() {
        logger.debug("getId called, returning: {}", id);
        return id;
    }

    /**
     * Retrieves the name of the floor.
     * @return The name of the floor.
     */
    @Override
    public String getName() {
        logger.debug("getName called, returning: {}", name);
        return name;
    }

    /**
     * Adds a location (Room object) to the floor.
     * @param location The location (Room object) to be added.
     */
    public void addLocation(ComponentLocation location) {
        logger.info("addLocation called for Floor with id {}", id);
        listOfRooms.add(location);
    }

    /**
     * Retrieves a list of sub-locations: here rooms within location.
     * @return an ArrayList of objects representing rooms.
     */
    @Override
    public ArrayList<ComponentLocation> getList() {
        logger.debug("getList called for Floor with id {}, returning {}", id, listOfRooms);
        return listOfRooms;
    }

    /**
     * Removes a location (Room object) from the floor.
     * @param location The location (Room object) to be removed.
     */
    public void removeLocation(ComponentLocation location) {
        logger.info("removeLocation called for Floor with id {}", id);
        listOfRooms.remove(location);
    }

    /**
     * Calculates the total area of the floor.
     * @return The total area of the floor.
     */
    @Override
    public double calculateTotalArea() {
        double totalArea = 0.0;
        ArrayList<ComponentLocation> RoomsList = getList();
        for (ComponentLocation location : RoomsList) {
            totalArea += location.calculateTotalArea();
        }
        logger.debug("Total area calculated for floor {}: {}", getId(), totalArea);

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
        logger.debug("Total volume calculated for floor {}: {}", id, totalVolume);

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
        logger.debug("Total heating energy calculated for floor {}: {}", id, totalHeating);

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
        logger.debug("Total lighting power calculated for floor {}: {}", id, totalLightening);

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
     * Calculates the average cost of maintenance of the floor
     * @return The average cost of maintenance of the floor
     */
    @Override
    public double calculateTotalMaintenance() {
        double totalCost = 0.0;
        for(ComponentLocation location: listOfRooms){
            totalCost += location.calculateTotalMaintenance();
        }
        return  totalCost;
    }


    /**
     * Accepts a visitor and lets it perform its operation on this location.
     * @param visitor   visitor to accept
     * @return          BuildingInfo object containing information accordingly to visitor
     */
    @Override
    public BuildingInfo accept(LocationVisitorInt visitor) {
        logger.debug("Accept method called for CompositeFloor {}", id);
        return visitor.visit(this);
    }

}
