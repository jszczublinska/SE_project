package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating area of a location.
 *  Implements LocationVisitorInt Interface.
 */
public class VisitorArea implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorLighting.class);

    /**
     *Visits component location and calculates its area.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object with updated information about area of visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalArea = comBuild.calculateTotalArea();
        logger.info("Calculated total area for {}: {}", comBuild.getName(), totalArea);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.AREA, comBuild.getName(), totalArea);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",report.getType(), report.getName(), report.getValue());
        return report;
    }
}
