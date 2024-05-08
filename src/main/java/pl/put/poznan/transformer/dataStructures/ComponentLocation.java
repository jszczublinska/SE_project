package pl.put.poznan.transformer.dataStructures;

public interface ComponentLocation {
    int getId();
    String getName();
    void addLocation(ComponentLocation location);
    void removeLocation(ComponentLocation location);
    double calculateTotalArea();
    double calculateTotalVolume();
    double calculateTotalHeatingEnergy();
    double calculateTotalLightingPower();
}
