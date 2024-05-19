package pl.put.poznan.info.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingInfo {

    /**
     * Enum for type of information.
     */
    public enum Type {
        AREA, VOLUME, LIGTHING
    }
    private Type type;
    private String name;
    private double value;

    /**
     * Default constructor.
     */
    public BuildingInfo(){};

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
    }

    /**
     * Gets the type of the building's information
     * @return     The type of building information
     */
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    /**
     * Gets the name of the building's information
     * @return     The name of building information
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Gets the value of the building's information
     * @return     The value of building information
     */
    @JsonProperty("value")
    public double getValue() {
        return value;
    }


}
