package pl.put.poznan.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;
import pl.put.poznan.info.logic.dataStructures.CompositeBuilding;
import pl.put.poznan.info.logic.dataStructures.CompositeFloor;
import pl.put.poznan.info.logic.dataStructures.Room;
import pl.put.poznan.info.logic.visitor.VisitorArea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/{buildingId}")
public class BuildingInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private Map<String, CompositeBuilding> buildingInfoMap = new HashMap<>();

    // jesli bedzimey chcialy miec ten parametr ( 6 BacklogItem ) to bedzimey uzywac dodatkowo
    //  @RequestParam(value="parameter", default
    // Value="None") double parameter)

    // String floorId, String roomId, String type
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String buildingId) {

        CompositeBuilding mainBuilding = new CompositeBuilding("1", "Centrum wykladowe");

        // making levels
        CompositeFloor level0 = new CompositeFloor("101", "parter");
        CompositeFloor level1 = new CompositeFloor("102", "1 pietro");
        // making rooms
        Room room1 = new Room("201", "pokoj Lesia", 10, 2, 2, 50, 20);
        Room room2 = new Room("202", "pokoj Dareczka", 60, 2, 2.5, 85, 24.9);

        mainBuilding.addLocation(level0);
        mainBuilding.addLocation(level1);
        level1.addLocation(room1);
        level1.addLocation(room2);
        //////

        VisitorArea visitor = new VisitorArea();
        BuildingInfo num = mainBuilding.accept(visitor);
        return  "idiotA";

    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding post(@PathVariable String buildingId, @RequestBody CompositeBuilding compositeBuilding) {
        buildingInfoMap.put(buildingId, compositeBuilding);
        return compositeBuilding;
    }

}


