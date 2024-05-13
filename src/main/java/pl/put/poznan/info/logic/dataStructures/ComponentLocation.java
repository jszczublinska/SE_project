package pl.put.poznan.info.logic.dataStructures;

import pl.put.poznan.info.logic.visitor.LocationVisitorInt;

public interface ComponentLocation {

    String getId();
    String getName();
    double calculateTotalArea();
    double calculateTotalVolume();
    double calculateTotalHeatingEnergy();
    double calculateTotalLightingPower();

    double accept(LocationVisitorInt visitor);
}
