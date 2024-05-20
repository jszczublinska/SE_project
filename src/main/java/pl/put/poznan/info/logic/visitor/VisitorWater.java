package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating water consumption of a location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorWater implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorWater.class);

    /**
     *Visits component location and calculates its water consumption.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing water consumption of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalWater = comBuild.calculateTotalWaterConsumption();
        logger.info("Calculated total volume for {}: {}", comBuild.getName(), totalWater);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.WATER, comBuild.getName(), totalWater);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",
                report.getType(), report.getName(), report.getValue());
        return report;
    }
}
