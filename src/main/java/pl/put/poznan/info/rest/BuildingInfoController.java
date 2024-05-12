package pl.put.poznan.info.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.info.dataStructures.Room;

import java.util.HashMap;
import java.util.Map;


@RestController
//@RequestMapping("/{text}")
public class BuildingInfoController {

    private Map<String, Room> roomMap = new HashMap<>();

    public BuildingInfoController(){
        roomMap.put("201", new Room("201", "CW8", 10, 2, 2, 50, 20));
        roomMap.put("102", new Room("102", "BT102", 20, 4, 3, 80, 10));
    }

    @PostMapping("/addRoom/")
    public void createRoom(@RequestBody Room room){
        roomMap.put(room.getId(), room);
    }

//    // Marysia tutaj jest pole dla Ciebie z Restem i JSON
//    // ogolnie nic nie usuwalam abys miala jakis wzor
//    // oczywiscie zamiast transforms mysle ze bedziemy mialy tablice tych location(?)
//    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
//
//    @GetMapping("/aplication/rooms")
//    public String getString(){
//        return roomMap.get(ID);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public String get(@PathVariable String text,
//                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {
//
//        // log the parameters
//        logger.debug(text);
//        logger.debug(Arrays.toString(transforms));
//
//        // perform the transformation, you should run your logic here, below is just a silly example
//        //BuildingInfo info = new BuildingInfo(transforms);
//        //return info.transform(text);
//        return centrumWykladowe.Info();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    public String post(@PathVariable String text,
//                      @RequestBody String[] transforms) {
//
//        // log the parameters
//        logger.debug(text);
//        logger.debug(Arrays.toString(transforms));
//
//        // perform the transformation, you should run your logic here, below is just a silly example
//        //BuildingInfo info = new BuildingInfo(transforms);
//        //return info.transform(text);
//        return centrumWykladowe.toString();
//    }

}


