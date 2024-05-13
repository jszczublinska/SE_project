package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.dataStructures.*;

public interface LocationVisitorInt {
    double visit( CompositeBuilding comBuild);
    double visit( CompositeFloor comFloor);
    double visit( Room room);
}
