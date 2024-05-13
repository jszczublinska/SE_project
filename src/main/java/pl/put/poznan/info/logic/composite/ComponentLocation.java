package pl.put.poznan.info.logic.composite;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

public interface ComponentLocation {

    String getId();
    String getName();
    double calculateTotalArea();
    double calculateTotalVolume();
    double calculateTotalHeatingEnergy();
    double calculateTotalLightingPower();

    BuildingInfo accept(LocationVisitorInt visitor);
}
