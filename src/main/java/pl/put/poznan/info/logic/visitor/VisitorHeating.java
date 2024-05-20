package pl.put.poznan.info.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.*;

/**
 * Visitor implementation for calculating heating energy of a location.
 * Implements LocationVisitorInt Interface.
 */
public class VisitorHeating implements LocationVisitorInt{

    private static final Logger logger = LoggerFactory.getLogger(VisitorHeating.class);

    /**
     *Visits component location and calculates its heating energy.
     *
     * @param comBuild  The location to be visited
     * @return          The BuildingInfo object containing updated heating energy of the visited location.
     */
    @Override
    public BuildingInfo visit(ComponentLocation comBuild) {
        logger.debug("visit method called with ComponentLocation: {}", comBuild.getName());
        double totalEnergy = comBuild.calculateTotalHeatingEnergy();
        logger.info("Calculated total volume for {}: {}", comBuild.getName(), totalEnergy);
        BuildingInfo report = new BuildingInfo(BuildingInfo.Type.HEATING, comBuild.getName(), totalEnergy);
        logger.debug("Created BuildingInfo report: type={}, name={}, value={}",
                report.getType(), report.getName(), report.getValue());
        return report;
    }
}
