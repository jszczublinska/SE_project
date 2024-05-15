package pl.put.poznan.info.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.ComponentLocation;
import pl.put.poznan.info.logic.visitor.VisitorArea;
import pl.put.poznan.info.logic.visitor.VisitorLigthing;
import pl.put.poznan.info.logic.visitor.VisitorVolume;
import pl.put.poznan.info.logic.composite.CompositeBuilding;
import pl.put.poznan.info.logic.composite.CompositeFloor;
import pl.put.poznan.info.logic.composite.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/building_{buildingId}")
public class BuildingInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private Map<String, CompositeBuilding> buildingInfoMap = new HashMap<>();
    private VisitorArea visitorArea = new VisitorArea();
    private VisitorVolume visitorVolume = new VisitorVolume();
    private VisitorLigthing visitorLigthing = new VisitorLigthing();


    // jesli bedzimey chcialy miec ten parametr ( 6 BacklogItem ) to bedzimey uzywac dodatkowo
    //  @RequestParam(value="parameter", default
    // Value="None") double parameter)


    // for getting
    @RequestMapping( value ="/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getBuilding(@PathVariable String buildingId , @PathVariable String type) {

        CompositeBuilding mainBuilding = buildingInfoMap.get(buildingId);
        BuildingInfo info = new BuildingInfo();

        if (type.equalsIgnoreCase("AREA")){
            info = mainBuilding.accept(visitorArea);

        } else if (type.equalsIgnoreCase("VOLUME")) {
            info = mainBuilding.accept(visitorVolume);

        } else if (type.equalsIgnoreCase("LIGTHING")) {
            info = mainBuilding.accept(visitorLigthing);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error in JSON format";
        }
    }

    @RequestMapping( value ="/floor_{floorId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getFloor(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String type) {

        BuildingInfo info = new BuildingInfo();
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor: floors){
            if (floor.getId().equals(floorId)) {

                if (type.equalsIgnoreCase("AREA")) {
                    info = floor.accept(visitorArea);
                } else if (type.equalsIgnoreCase("VOLUME")) {
                    info = floor.accept(visitorVolume);
                } else if (type.equalsIgnoreCase("LIGTHING")) {
                    info = floor.accept(visitorLigthing);
                }
                break;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error in JSON format";
        }

    }

    @RequestMapping( value ="/floor_{floorId}/room_{roomId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getRoom(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String roomId, @PathVariable String type) {

        BuildingInfo info = new BuildingInfo();
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor: floors){
            if (floor.getId().equals(floorId)) {
                ArrayList<ComponentLocation> rooms = floor.getList();
                for (ComponentLocation room: rooms){
                    if(room.getId().equals(roomId)) {
                        if (type.equalsIgnoreCase("AREA")) {
                            info = room.accept(visitorArea);
                        } else if (type.equalsIgnoreCase("VOLUME")) {
                            info = room.accept(visitorVolume);
                        } else if (type.equalsIgnoreCase("LIGTHING")) {
                            info = room.accept(visitorLigthing);
                            break;
                        }
                    }
                }

            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error in JSON format";
        }

    }
    // for posting
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding post(@PathVariable String buildingId, @RequestBody CompositeBuilding compositeBuilding) {
        buildingInfoMap.put(buildingId, compositeBuilding);
        return compositeBuilding;
    }

    @RequestMapping(value = "/floor_{floorId}",method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding postFloor(@PathVariable String buildingId, @PathVariable String floorId, @RequestBody CompositeFloor compositeFloor) {

        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        compositeBuilding.addLocation(compositeFloor);

        return compositeBuilding;
    }

    @RequestMapping(value = "/floor_{floorId}/room_{roomId}",method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding postRoom(@PathVariable String buildingId, @PathVariable String floorId, @PathVariable String roomId, @RequestBody Room room) {
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor: floors){
            if (floor.getId().equals(floorId)){
                compositeBuilding.removeLocation(floor);
                floor.addLocation(room);
                compositeBuilding.addLocation(floor);
                break;
            }
        }

        return compositeBuilding;
    }


}


