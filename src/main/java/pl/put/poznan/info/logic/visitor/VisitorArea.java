package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.dataStructures.*;

public class VisitorArea implements LocationVisitorInt{

    @Override
    public double visit(CompositeBuilding comBuild) {

        return 0.0;
    }

    @Override
    public double visit(ComponentLocation comFloor) {
        double totalArea = 0.0;

        return totalArea;
    }

    @Override
    public double visit(Room room) {

        return room.calculateTotalArea();
    }
}
