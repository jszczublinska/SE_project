package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.dataStructures.ComponentLocation;
import pl.put.poznan.info.logic.dataStructures.CompositeBuilding;
import pl.put.poznan.info.logic.dataStructures.CompositeFloor;
import pl.put.poznan.info.logic.dataStructures.Room;

public class VisitorLigthing implements LocationVisitorInt{
    @Override
    public BuildingInfo visit(CompositeBuilding comBuild) {
        double totalLightening = comBuild.calculateTotalLightingPower();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGTHING, comBuild.getName(), totalLightening);
        return report;
    }

    @Override
    public BuildingInfo visit(CompositeFloor comFloor) {
        double totalLightening = comFloor.calculateTotalLightingPower();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGTHING, comFloor.getName(), totalLightening);
        return report;
    }

    @Override
    public BuildingInfo visit(Room room) {
        double totalLightening = room.calculateTotalLightingPower();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGTHING, room.getName(), totalLightening);
        return report;
    }
}
