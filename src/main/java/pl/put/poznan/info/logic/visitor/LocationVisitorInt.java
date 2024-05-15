package pl.put.poznan.info.logic.visitor;

import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.composite.*;

public interface LocationVisitorInt {
    BuildingInfo visit(ComponentLocation comBuild);

}
