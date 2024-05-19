package pl.put.poznan.info.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * The main class for the Building Info application.
 * <p>
 * This is the entry point for the Spring Boot application.
 * </p>
 *<p>
 * The application will be accessible at <a href="http://localhost:8080/">http://localhost:8080/</a>.
 * </p>
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.info.rest"})
public class BuildingInfoApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
        //http://localhost:8080/

    }
}
