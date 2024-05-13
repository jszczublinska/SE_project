package pl.put.poznan.info.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingInfo {

    public enum Type {
        AREA, VOLUME, LIGTHING
    }
    private Type type;
    private String name;
    private double value;

    public BuildingInfo(){};

    public BuildingInfo(Type type, String name, double value){
        this.type = type;
        this.name = name;
        this.value = value;
    }
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("value")
    public double getValue() {
        return value;
    }


}
