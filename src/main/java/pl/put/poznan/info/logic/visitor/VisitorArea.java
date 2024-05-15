package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

public class VisitorArea implements LocationVisitorInt{

    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalArea = comBuild.calculateTotalArea();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, comBuild.getName(), totalArea);
        return report;
    }
}
