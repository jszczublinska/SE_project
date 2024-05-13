package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.dataStructures.*;

public class VisitorArea implements LocationVisitorInt{

    @Override
    public double visit(CompositeBuilding comBuild) {
        double totalArea = 0.0;
        for (CompositeFloor compFloor : comBuild.getListOfLevels() ){
            totalArea += compFloor.calculateTotalArea();
        }

        return totalArea;
    }

    @Override
    public double visit(CompositeFloor comFloor) {
        double totalArea = 0.0;
        for (Room room : comFloor.getListOfRooms() ){
            totalArea += room.calculateTotalArea();
        }

        return totalArea;
    }

    @Override
    public double visit(Room room) {
        return room.calculateTotalArea();
    }
}
