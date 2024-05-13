package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.dataStructures.*;

public class VisitorArea implements LocationVisitorInt{

    @Override
    public BuildingInfo visit(CompositeBuilding comBuild) {
        double totalArea = comBuild.calculateTotalArea();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, comBuild.getName(), totalArea);
        return report;
    }

    @Override
    public BuildingInfo visit(CompositeFloor comFloor) {
        double totalArea = comFloor.calculateTotalArea();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, comFloor.getName(), totalArea);
        return report;
    }

    @Override
    public BuildingInfo visit(Room room) {
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, room.getName(), room.calculateTotalArea());
        return report;
    }
}
