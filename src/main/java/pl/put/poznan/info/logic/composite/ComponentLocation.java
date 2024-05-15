package pl.put.poznan.info.logic.composite;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

import java.util.ArrayList;

public interface ComponentLocation {

    String getId();
    String getName();
    double calculateTotalArea();
    double calculateTotalVolume();
    double calculateTotalHeatingEnergy();
    double calculateTotalLightingPower();
    void addLocation(ComponentLocation location);

    ArrayList<ComponentLocation> getList();

    BuildingInfo accept(LocationVisitorInt visitor);
}
