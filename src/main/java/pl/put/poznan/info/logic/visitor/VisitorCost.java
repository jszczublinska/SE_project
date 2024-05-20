package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating maintenance cost of a location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorCost implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorCost.class);

    /**
     *Visits component location and calculates its maintenance cost.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing updated maintenance cost of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalCost = 0.0;
        logger.info("Calculated total volume for {}: {}", comBuild.getName(), totalCost);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.COST, comBuild.getName(), totalCost);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",
                report.getType(), report.getName(), report.getValue());
        return report;
    }
}
