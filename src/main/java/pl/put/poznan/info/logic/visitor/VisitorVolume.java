package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.dataStructures.ComponentLocation;
import pl.put.poznan.info.logic.dataStructures.CompositeBuilding;
import pl.put.poznan.info.logic.dataStructures.CompositeFloor;
import pl.put.poznan.info.logic.dataStructures.Room;

public class VisitorVolume implements LocationVisitorInt{

    @Override
    public double visit(CompositeBuilding comBuild) {
        return 0;
    }

    @Override
    public double visit(CompositeFloor comFloor) {
        return 0;
    }

    @Override
    public double visit(Room room) {
        return 0;
    }
}
