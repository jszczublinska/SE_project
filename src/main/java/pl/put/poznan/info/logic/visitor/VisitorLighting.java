package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating lighting of a location.
 *  Implements LocationVisitorInt Interface.
 *
 */
public class VisitorLighting implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorVolume.class);

    /**
     *Visits component location and calculates its lighting.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object with updated information about lighting of visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalLightening = comBuild.calculateTotalLightingPower();
        logger.info("Calculated total lighting for {}: {}", comBuild.getName(), totalLightening);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.LIGHTING, comBuild.getName(), totalLightening);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}", report.getType(), report.getName(), report.getValue());
        return report;
    }
}
