package pl.put.poznan.info.logic.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Represents a single building containing multiple levels, which are made of Rooms.
 * Implements the ComponentLocation interface.
 */
public class CompositeBuilding implements ComponentLocation {
    private static final Logger logger = LoggerFactory.getLogger(CompositeBuilding.class);

    private String id;
    private String name;
    private ArrayList<ComponentLocation> listOfLevels = new ArrayList<ComponentLocation>();

    /**
     * Default constructor for CompositeBuilding object.
     */
    public CompositeBuilding(){logger.debug("Default constructor called for Building");
    }

    /**
     * Constructs a CompositeBuilding object with optional name.
     * @param id The unique identifier of the building.
     * @param name The name of the building.
     */
    public CompositeBuilding(String id, String name) {
        this.id = id;
        this.name = name;
        logger.debug("Constructor for Building run with parameters {}, {}", id, name);

    }

    /**
     * Constructs a CompositeBuilding object.
     * @param id The unique identifier of the building.
     */
    public CompositeBuilding(String id) {
        this(id,null);
        logger.debug("Constructor for Building run with parameter {}", id);

    }


    /**
     * Retrieves the unique identifier of the building.
     * @return The unique identifier of the building.
     */
    @Override
    public String getId() {
        logger.debug("getId called, returning: {}", id);
        return id;
    }


    /**
     * Retrieves the name of the building.
     * @return The name of the building.
     */
    @Override
    public String getName() {
        logger.debug("getName called, returning: {}", name);
        return name;
    }


    /**
     * Adds a location (Floor object) to the building.
     * @param location The location (Floor object) to be added.
     */
    public void addLocation(ComponentLocation location) {
        logger.info("addLocation called for Building with id {}", id);
        listOfLevels.add(location);
    }

    /**
     * Retrieves a list of sub-locations: here levels within location.
     * @return an ArrayList of objects representing levels.
     */
    @Override
    public ArrayList<ComponentLocation> getList() {
        logger.debug("getList called for Building with id {}, returning {}", id, listOfLevels);
        return listOfLevels;
    }

    /**
     * Removes a location (Floor object) from the building.
     * @param location The location (Floor object) to be removed.
     */
    public void removeLocation(ComponentLocation location) {
        logger.info("removeLocation called for Building with id {}", id);
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
        logger.debug("Total area calculated for building {}: {}", id, totalArea);
        return totalArea;
    }

    /**
     * Calculates the total volume of the building.
     * @return The total volume of the building.
     */
    @Override
    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for(ComponentLocation location: listOfLevels){
            totalVolume += location.calculateTotalVolume();
        }
        logger.debug("Total volume calculated for building {}: {}", id, totalVolume);
        return totalVolume;
    }

    /**
     * Calculates the total heating energy consumption of the building.
     * @return The total heating energy consumption of the building.
     */
    @Override
    public double calculateTotalHeatingEnergy() {
        double totalHeating = 0.0;
        for(ComponentLocation location: listOfLevels){
            totalHeating += location.calculateTotalHeatingEnergy();
        }
        logger.debug("Total heating calculated for building {}: {}", id, totalHeating);
        return totalHeating/listOfLevels.size();
    }

    /**
     * Calculates the total lighting power consumption of the building.
     * @return The total lighting power consumption of the building.
     */
    @Override
    public double calculateTotalLightingPower() {
        double totalLightening = 0.0;
        for(ComponentLocation location: listOfLevels){
            totalLightening += location.calculateTotalLightingPower();
        }
        logger.debug("Total lighting calculated for building {}: {}", id, totalLightening);
        return  totalLightening/listOfLevels.size();
    }

    /**
     * Calculates the average water consumption of the building.
     * @return The average water consumption of the building.
     */
    @Override
    public double calculateTotalWaterConsumption() {
        double totalWater = 0.0;

        for(ComponentLocation location: listOfLevels){
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
        logger.debug("Accept method called for CompositeBuilding {}", id);
        return visitor.visit(this);
    }
}
