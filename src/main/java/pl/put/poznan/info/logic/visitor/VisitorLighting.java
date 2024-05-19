package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating lighting of a location.
 *  Implements LocationVisitorInt Interface.
 *
 */
public class VisitorLighting implements LocationVisitorInt{

    /**
     *Visits component location and calculates its lighting.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object with updated information about lighting of visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalLightening = comBuild.calculateTotalLightingPower();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGHTING, comBuild.getName(), totalLightening);
        return report;
    }
}
