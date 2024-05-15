package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

public class VisitorLigthing implements LocationVisitorInt{
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalLightening = comBuild.calculateTotalLightingPower();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGTHING, comBuild.getName(), totalLightening);
        return report;
    }
}
