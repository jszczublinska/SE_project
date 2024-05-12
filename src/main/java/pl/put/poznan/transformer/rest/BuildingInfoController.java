package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.dataStructures.ComponentLocation;
import pl.put.poznan.transformer.dataStructures.CompositeBuilding;
import pl.put.poznan.transformer.dataStructures.CompositeFloor;
import pl.put.poznan.transformer.dataStructures.Room;
import pl.put.poznan.transformer.logic.BuildingInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/{buildingId}")
public class BuildingInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private Map<String, CompositeBuilding> buildingInfoMap = new HashMap<>();

    // jesli bedzimey chcialy miec ten parametr ( 6 BacklogItem ) to bedzimey uzywac dodatkowo
    //  @RequestParam(value="parameter", defaultValue="None") double parameter)
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String buildingId) {
        return buildingInfoMap.get(buildingId).getName();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding post(@PathVariable String buildingId, @RequestBody CompositeBuilding compositeBuilding) {
        buildingInfoMap.put(buildingId, compositeBuilding);
        return compositeBuilding;
    }


}


