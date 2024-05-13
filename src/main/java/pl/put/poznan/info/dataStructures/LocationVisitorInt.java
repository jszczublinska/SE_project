package pl.put.poznan.info.dataStructures;

public interface LocationVisitorInt {
    double visit( CompositeBuilding comBuild);
    double visit( ComponentLocation comFloor);
    double visit( Room room);
}
