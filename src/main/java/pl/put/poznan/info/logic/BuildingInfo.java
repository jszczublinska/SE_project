package pl.put.poznan.info.logic;

import pl.put.poznan.info.logic.dataStructures.*;


public class BuildingInfo {

    public enum Type {
        AREA, VOLUME, LIGTHING
    }
    private Type type;
    private String name;
    private double value;

    public BuildingInfo(Type type, String name, double value){
        this.type = type;
        this.name = name;
        this.value = value;
    }


}
