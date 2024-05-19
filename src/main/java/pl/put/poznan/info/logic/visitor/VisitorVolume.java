package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating volume of a location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorVolume implements LocationVisitorInt{

    /**
     *Visits component location and calculates its volume.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing updated volume of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalVolume = comBuild.calculateTotalVolume();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, comBuild.getName(), totalVolume);
        return report;
    }
}
