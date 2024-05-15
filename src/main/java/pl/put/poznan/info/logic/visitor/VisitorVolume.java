package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;


public class VisitorVolume implements LocationVisitorInt{

    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalVolume = comBuild.calculateTotalVolume();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, comBuild.getName(), totalVolume);
        return report;
    }
}
