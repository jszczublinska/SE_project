package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.ComponentLocation;

/**
 * Visitor implementation for calculating cost of maintenance of the location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorMaintenance implements LocationVisitorInt{
    private static final Logger logger = LoggerFactory.getLogger(VisitorMaintenance.class);

    /**
     *Visits component location and calculates cost of maintenance of the visited location.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing cost of maintenance of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalCost = comBuild.calculateTotalMaintenance();
        logger.info("Calculated total volume for {}: {}", comBuild.getName(), totalCost);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.COST, comBuild.getName(), totalCost);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",
                report.getType(), report.getName(), report.getValue());
        return report;
    }

}
