package pl.put.poznan.info.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.visitor.VisitorArea;
import pl.put.poznan.info.logic.visitor.VisitorLigthing;
import pl.put.poznan.info.logic.visitor.VisitorVolume;
import pl.put.poznan.info.logic.composite.CompositeBuilding;
import pl.put.poznan.info.logic.composite.CompositeFloor;
import pl.put.poznan.info.logic.composite.Room;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/{buildingId}")
public class BuildingInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private Map<String, CompositeBuilding> buildingInfoMap = new HashMap<>();

    private VisitorArea visitorArea = new VisitorArea();
    private VisitorVolume visitorVolume = new VisitorVolume();
    private VisitorLigthing visitorLigthing = new VisitorLigthing();


    // jesli bedzimey chcialy miec ten parametr ( 6 BacklogItem ) to bedzimey uzywac dodatkowo
    //  @RequestParam(value="parameter", default
    // Value="None") double parameter)

    @RequestMapping( value ="{type}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String buildingId , @PathVariable String type) {

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

    @RequestMapping( value ="/floor/{floorId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String type) {

        CompositeBuilding mainBuilding = buildingInfoMap.get(buildingId);
        CompositeFloor mainFloor = new CompositeFloor();

        for (CompositeFloor floor : mainBuilding.getListOfLevels()){
            if (floor.getId().equals(floorId)){
                mainFloor = floor;
                break;
            }
        }

        BuildingInfo info = new BuildingInfo();

        if (type.equalsIgnoreCase("AREA")){
            info = mainFloor.accept(visitorArea);

        } else if (type.equalsIgnoreCase("VOLUME")) {
            info = mainFloor.accept(visitorVolume);

        } else if (type.equalsIgnoreCase("LIGTHING")) {
            info = mainFloor.accept(visitorLigthing);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error in JSON format";
        }
    }

    @RequestMapping( value ="/floor/{floorId}/room/{roomId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String roomId, @PathVariable String type) {

        CompositeBuilding mainBuilding = buildingInfoMap.get(buildingId);
        CompositeFloor mainFloor = new CompositeFloor();
        Room mainRoom = new Room();

        for (CompositeFloor floor : mainBuilding.getListOfLevels()){
            if (floor.getId().equals(floorId)){
                mainFloor = floor;
                break;
            }
        }

        for (Room room : mainFloor.getListOfRooms()){
            if (room.getId().equals(roomId)){
                mainRoom = room;
                break;
            }
        }

        BuildingInfo info = new BuildingInfo();

        if (type.equalsIgnoreCase("AREA")){
            info = mainRoom.accept(visitorArea);

        } else if (type.equalsIgnoreCase("VOLUME")) {
            info = mainRoom.accept(visitorVolume);

        } else if (type.equalsIgnoreCase("LIGTHING")) {
            info = mainRoom.accept(visitorLigthing);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error in JSON format";
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding post(@PathVariable String buildingId, @RequestBody CompositeBuilding compositeBuilding) {
        buildingInfoMap.put(buildingId, compositeBuilding);
        return compositeBuilding;
    }

}


