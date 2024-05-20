package pl.put.poznan.info.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents information about a building, including its type, name, and value.
 */
public class BuildingInfo {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfo.class);

    /**
     * Enum for type of information.
     */
    public enum Type {
        AREA, VOLUME, LIGHTING, HEATING, WATER, COST
    }
    private Type type;
    private String name;
    private double value;

    /**
     * Default constructor.
     */
    public BuildingInfo(){logger.debug("Default BuildingInfo constructor called");}

    /**
     * Constructor for a building information with a specifies type, name and value
     *
     * @param type      The type of characteristic (Enum from [area, volume, lighting])
     * @param name      The name of characteristic.
     * @param value     The value stored.
     */
    public BuildingInfo(Type type, String name, double value){
        this.type = type;
        this.name = name;
        this.value = value;
        logger.debug("BuildingInfo constructor called with type: {}, name: {}, value: {}", type, name, value);
    }

    /**
     * Gets the type of the building's information
     * @return     The type of building information
     */
    @JsonProperty("type")
    public Type getType() {
        logger.debug("getType called, returning: {}", type);
        return type;
    }

    /**
     * Gets the name of the building's information
     * @return     The name of building information
     */
    @JsonProperty("name")
    public String getName() {
        logger.debug("getName called, returning: {}", name);
        return name;
    }

    /**
     * Gets the value of the building's information
     * @return     The value of building information
     */
    @JsonProperty("value")
    public double getValue() {
        logger.debug("getValue called, returning: {}", value);
        return value;
    }


}
