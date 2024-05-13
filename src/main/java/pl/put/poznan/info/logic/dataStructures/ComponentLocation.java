package pl.put.poznan.info.logic.dataStructures;

public interface ComponentLocation {

    String getId();
    String getName();
    double calculateTotalArea();
    double calculateTotalVolume();
    double calculateTotalHeatingEnergy();
    double calculateTotalLightingPower();
}
