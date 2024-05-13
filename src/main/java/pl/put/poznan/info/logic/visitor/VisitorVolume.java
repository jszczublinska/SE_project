package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.CompositeBuilding;
import pl.put.poznan.info.logic.composite.CompositeFloor;
import pl.put.poznan.info.logic.composite.Room;

public class VisitorVolume implements LocationVisitorInt{

    @Override
    public BuildingInfo visit(CompositeBuilding comBuild) {
        double totalVolume = comBuild.calculateTotalVolume();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, comBuild.getName(), totalVolume);
        return report;
    }

    @Override
    public BuildingInfo visit(CompositeFloor comFloor) {
        double totalVolume = comFloor.calculateTotalVolume();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, comFloor.getName(), totalVolume);
        return report;
    }

    @Override
    public BuildingInfo visit(Room room) {
        double totalVolume = room.calculateTotalVolume();;
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, room.getName(), totalVolume);
        return report;
    }
}
