package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.BuildingInfo;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class BuildingInfoController {

     // Marysia tutaj jest pole dla Ciebie z Restem i JSON
     // ogolnie nic nie usuwalam abys miala jakis wzor
     // oczywiscie zamiast transforms mysle ze bedziemy mialy tablice tych location(?)
     private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

     @RequestMapping(method = RequestMethod.GET, produces = "application/json")
     public String get(@PathVariable String text,
                               @RequestParam(value="transforms", defaultValue="upper,escape") String transforms) {

         // log the parameters
         logger.debug(text);
//         logger.debug(Arrays.toString(transforms));

         // perform the transformation, you should run your logic here, below is just a silly example
         BuildingInfo centrumWykladowe = new BuildingInfo();
         return centrumWykladowe.Info();
     }

     @RequestMapping(method = RequestMethod.POST, produces = "application/json")
     public String post(@PathVariable String text,
                       @RequestBody String[] transforms) {

         // log the parameters
         logger.debug(text);
         logger.debug(Arrays.toString(transforms));

         // perform the transformation, you should run your logic here, below is just a silly example
         BuildingInfo centrumWykladowe = new BuildingInfo();
         return centrumWykladowe.toString();
     }



}


