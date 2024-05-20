package pl.put.poznan.info.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = (Logger) LoggerFactory.getLogger(BuildingInfoApplication.class);

    /**
     *
     * @param args The arguments provided while running the program
     */
    public static void main(String[] args) {
        logger.info("Starting application");
        SpringApplication.run(BuildingInfoApplication.class, args);
        //http://localhost:8080/

    }
}
