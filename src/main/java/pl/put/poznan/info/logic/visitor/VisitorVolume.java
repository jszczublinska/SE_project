package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating volume of a location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorVolume implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorVolume.class);

    /**
     *Visits component location and calculates its volume.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing updated volume of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalVolume = comBuild.calculateTotalVolume();
        logger.info("Calculated total volume for {}: {}", comBuild.getName(), totalVolume);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.VOLUME, comBuild.getName(), totalVolume);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",
                report.getType(), report.getName(), report.getValue());
        return report;
    }
}
