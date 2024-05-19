package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating area of a location.
 *  Implements LocationVisitorInt Interface.
 */
public class VisitorArea implements LocationVisitorInt{

    /**
     *Visits component location and calculates its area.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object with updated information about area of visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        double totalArea = comBuild.calculateTotalArea();
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, comBuild.getName(), totalArea);
        return report;
    }
}
