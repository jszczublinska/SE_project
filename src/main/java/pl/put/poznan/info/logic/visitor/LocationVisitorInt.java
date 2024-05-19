package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

/**
 * Interface for the visitor that takes action based on locations.
 */
public interface LocationVisitorInt {
    /**
     * Visits the component location and returns an information about the building.
     *
     * @param comBuild  The location to be visited
     * @return          The information about location
     */
    BuildingInfo visit(ComponentLocation comBuild);

}
