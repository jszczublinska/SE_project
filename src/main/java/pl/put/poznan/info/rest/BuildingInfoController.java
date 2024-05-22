package pl.put.poznan.info.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.logic.BuildingInfo;

import pl.put.poznan.info.logic.composite.ComponentLocation;
import pl.put.poznan.info.logic.visitor.*;
import pl.put.poznan.info.logic.composite.CompositeBuilding;
import pl.put.poznan.info.logic.composite.CompositeFloor;
import pl.put.poznan.info.logic.composite.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for managing building information.
 * <p>
 * This controller provides endpoints for retrieving and posting information about buildings, floors, and rooms.
 * It also posts information about their Information including area, volume, and lighting.
 * </p>
 */
@RestController
@RequestMapping("/building_{buildingId}")
public class BuildingInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private Map<String, CompositeBuilding> buildingInfoMap = new HashMap<>();
    private VisitorArea visitorArea = new VisitorArea();
    private VisitorVolume visitorVolume = new VisitorVolume();
    private VisitorLighting visitorLighting = new VisitorLighting();
    private VisitorHeating visitorHeating = new VisitorHeating();
    private VisitorWater visitorWater = new VisitorWater();

    private VisitorMaintenance visitorMaintenance = new VisitorMaintenance();

    // jesli bedzimey chcialy miec ten parametr ( 6 BacklogItem ) to bedzimey uzywac dodatkowo
    //  @RequestParam(value="parameter", default
    // Value="None") double parameter)

    /**
     * Retrieves information about building based on type(area, volume, lighting)
     *
     * @param buildingId    Building's identifier from URL
     * @param type          Information we want to retrieve
     * @return              Value of the Information in JSON format
     */
    @RequestMapping( value ="/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getBuilding(@PathVariable String buildingId , @PathVariable String type) {

        logger.debug("getBuilding called with buildingId: {} and type: {}", buildingId, type);
        CompositeBuilding mainBuilding = buildingInfoMap.get(buildingId);
        BuildingInfo info = new BuildingInfo();
        logger.debug("Getting building information");
        if (type.equalsIgnoreCase("AREA")){
            info = mainBuilding.accept(visitorArea);

        } else if (type.equalsIgnoreCase("VOLUME")) {
            info = mainBuilding.accept(visitorVolume);

        } else if (type.equalsIgnoreCase("LIGHTING")) {
            info = mainBuilding.accept(visitorLighting);
        }  else if (type.equalsIgnoreCase("HEATING")){
            info = mainBuilding.accept(visitorHeating);

        } else if (type.equalsIgnoreCase("WATER")) {
            info = mainBuilding.accept(visitorWater);

        } else if (type.equalsIgnoreCase("COST")){
                info = mainBuilding.accept(visitorMaintenance);
        } else{
            logger.debug("Couldn't retrieve information");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(info);
            logger.info("Successfully retrieved {} info for buildingId: {}", type, buildingId);
            return result;
        } catch (JsonProcessingException e) {
            logger.debug("Error in JSON processing: {}", e.getMessage());
            e.printStackTrace();
            return "Error in JSON format";
        }
    }

    /**
     * Retrieves information about specific floor based on type(area, volume, lighting)
     *
     * @param buildingId    Building's identifier from URL
     * @param floorId       Floor's identifier from URL
     * @param type          Information we want to retrieve
     * @return              Value of the Information in JSON format
     */
    @RequestMapping( value ="/floor_{floorId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getFloor(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String type) {

        logger.debug("getFloor called with buildingId: {}, floorId: {}, and type: {}", buildingId, floorId, type);
        BuildingInfo info = new BuildingInfo();
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor: floors){
            if (floor.getId().equals(floorId)) {
                logger.debug("Getting floor information..");
                if (type.equalsIgnoreCase("AREA")) {
                    info = floor.accept(visitorArea);
                } else if (type.equalsIgnoreCase("VOLUME")) {
                    info = floor.accept(visitorVolume);
                } else if (type.equalsIgnoreCase("LIGHTING")) {
                    info = floor.accept(visitorLighting);
                } else if (type.equalsIgnoreCase("HEATING")) {
                    info = floor.accept(visitorHeating);
                } else if (type.equalsIgnoreCase("WATER")) {
                    info = floor.accept(visitorWater);
                } else if (type.equalsIgnoreCase("COST")){
                    info = floor.accept(visitorMaintenance);
                } else{
                    logger.debug("Couldn't retrieve information");
                }
                break;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(info);
            logger.info("Successfully retrieved {} info for floorId: {} in buildingId: {}", type, floorId, buildingId);
            return result;
        } catch (JsonProcessingException e) {
            logger.debug("Error in JSON processing: {}", e.getMessage());
            e.printStackTrace();
            return "Error in JSON format";
        }

    }

    /**
     * Retrieves information about specific room based on type(area, volume, lighting)
     *
     * @param buildingId    Building's identifier from URL
     * @param floorId       Floor's identifier from URL
     * @param roomId        Room's identifier from URL
     * @param type          Information we want to retrieve
     * @return              Value of the Information in JSON format
     */
    @RequestMapping( value ="/floor_{floorId}/room_{roomId}/{type}", method = RequestMethod.GET, produces = "application/json")
    public String getRoom(@PathVariable String buildingId , @PathVariable String floorId, @PathVariable String roomId, @PathVariable String type) {

        logger.debug("getRoom called with buildingId: {}, floorId: {}, roomId: {}, and type: {}", buildingId, floorId, roomId, type);
        BuildingInfo info = new BuildingInfo();
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor : floors) {
            if (floor.getId().equals(floorId)) {
                ArrayList<ComponentLocation> rooms = floor.getList();
                for (ComponentLocation room : rooms) {
                    if (room.getId().equals(roomId)) {
                        logger.debug("Getting room information..");
                        if (type.equalsIgnoreCase("AREA")) {
                            info = room.accept(visitorArea);
                        } else if (type.equalsIgnoreCase("VOLUME")) {
                            info = room.accept(visitorVolume);
                        } else if (type.equalsIgnoreCase("LIGHTING")) {
                            info = room.accept(visitorLighting);
                        } else if (type.equalsIgnoreCase("HEATING")) {
                            info = room.accept(visitorHeating);
                        } else if (type.equalsIgnoreCase("WATER")) {
                            info = room.accept(visitorWater);
                        } else if (type.equalsIgnoreCase("COST")){
                            info = room.accept(visitorMaintenance);
                        } else {
                            logger.debug("Couldn't retrieve information");
                        }
                        break;
                    }
                }
            }

        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(info);
            logger.info("Successfully retrieved {} info for roomId: {} in floorId: {} of buildingId: {}", type, roomId, floorId, buildingId);
            return result;
        } catch (JsonProcessingException e) {
            logger.debug("Error in JSON processing: {}", e.getMessage());
            e.printStackTrace();
            return "Error in JSON format";
        }

    }

    /**
     * Creates new building in the system.
     *
     * @param buildingId            Building's identifier
     * @param compositeBuilding     Building's information to add
     * @return                      The added building
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding post(@PathVariable String buildingId, @RequestBody CompositeBuilding compositeBuilding) {
        logger.debug("postBuilding called with buildingId: {}", buildingId);
        buildingInfoMap.put(buildingId, compositeBuilding);
        logger.info("Building with id {} created successfully", buildingId);
        return compositeBuilding;
    }

    /**
     * Creates new floor in a building
     *
     * @param buildingId            Building's identifier
     * @param floorId               Floor's identifier
     * @param compositeFloor        Floor's information to add
     * @return                      The updated building with a new floor
     */
    @RequestMapping(value = "/floor_{floorId}",method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding postFloor(@PathVariable String buildingId, @PathVariable String floorId, @RequestBody CompositeFloor compositeFloor) {

        logger.debug("postFloor called with buildingId: {} and floorId: {}", buildingId, floorId);
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        compositeBuilding.addLocation(compositeFloor);

        logger.info("Floor with id {} added to buildingId: {}", floorId, buildingId);
        return compositeBuilding;
    }


    /**
     * Creates new room in a buildingc
     *
     * @param buildingId        Building's identifier
     * @param floorId           Floor's identifier
     * @param roomId            Room's identifier
     * @param room              Room's information to add
     * @return                  The updated building with a new room
     */
    @RequestMapping(value = "/floor_{floorId}/room_{roomId}",method = RequestMethod.POST, produces = "application/json")
    public CompositeBuilding postRoom(@PathVariable String buildingId, @PathVariable String floorId, @PathVariable String roomId, @RequestBody Room room) {
        logger.debug("postRoom called with buildingId: {}, floorId: {}, and roomId: {}", buildingId, floorId, roomId);
        CompositeBuilding compositeBuilding = buildingInfoMap.get(buildingId);
        ArrayList<ComponentLocation> floors = compositeBuilding.getList();
        for (ComponentLocation floor: floors){
            if (floor.getId().equals(floorId)){
                compositeBuilding.removeLocation(floor);
                floor.addLocation(room);
                compositeBuilding.addLocation(floor);
                logger.info("Room with id {} added to floorId: {} in buildingId: {}", roomId, floorId, buildingId);
                break;
            }
        }

        return compositeBuilding;
    }

}


