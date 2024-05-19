package pl.put.poznan.info.logic.composite;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

/**
 * Interface of component location within a building.
 * This interface defines the methods for getting details about the location,
 * calculating area, volume, heating and lighting, managing sub-locations, and accepting a visitor.
 */
public interface ComponentLocation {

    /**
     *Retrieves ID of a location
     * @return  ID of a location
     */
    String getId();
    /**
     * Retrieves name of a location.
     * @return  name of a location
     */
    String getName();
    /**
     * Calculates total area of a location.
     * @return  total area of a location
     */
    double calculateTotalArea();
    /**
     * Retrieves total volume of a location.
     * @return  total volume of a location.
     */
    double calculateTotalVolume();

    /**
     * Retrieves total heating energy of a location.
     * @return  total heating energy of a location
     */
    double calculateTotalHeatingEnergy();

    /**
     * Retrieves total lighting power of a location.
     * @return  total lighting power of a location
     */
    double calculateTotalLightingPower();

    /**
     * Adds a sub-location to current location.
     * @param location      location where the sub-location should be added
     */
    void addLocation(ComponentLocation location);

    /**
     *Retrieves a list of sub-locations of current location.
     * @return      list of sub-locations
     */
    ArrayList<ComponentLocation> getList();

    /**
     * Accepts a visitor and returns a BuildingInfo object based on visitor's logic.
     * @param visitor   visitor to accept
     * @return          BuildingInfo object changes accordingly to visitor's logic.
     */
    BuildingInfo accept(LocationVisitorInt visitor);
}
