package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.dataStructures.ComponentLocation;
import pl.put.poznan.info.logic.dataStructures.CompositeBuilding;
import pl.put.poznan.info.logic.dataStructures.CompositeFloor;
import pl.put.poznan.info.logic.dataStructures.Room;

public class VisitorVolume implements LocationVisitorInt{

    @Override
    public BuildingInfo visit(CompositeBuilding comBuild) {
        // DO ZMIANT TO TYLKO BY SIE NIE ZEPSULO
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, "IDK", 0.0);
        return report;
        // TU KONIEC
    }

    @Override
    public BuildingInfo visit(CompositeFloor comFloor) {

        // DO ZMIANT TO TYLKO BY SIE NIE ZEPSULO
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, "IDK", 0.0);
        return report;
        // TU KONIEC
    }

    @Override
    public BuildingInfo visit(Room room) {

        // DO ZMIANT TO TYLKO BY SIE NIE ZEPSULO
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, "IDK", 0.0);
        return report;
        // TU KONIEC
    }
}
