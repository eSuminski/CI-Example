package dev.suminki.app;

import dev.suminki.c.GreetingController;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.dal.GreetingDAOImp;
import dev.suminki.sl.GreetingService;
import dev.suminki.sl.GreetingServiceImp;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Creating Javalin object");
        Javalin app = Javalin.create(
                javalinConfig -> {
                    javalinConfig.enableCorsForAllOrigins();
                    javalinConfig.enableDevLogging();
                }
        );

        logger.info("Creating DAO, Service, and Controller objects");
        GreetingDAO greetingDAO = new GreetingDAOImp();
        GreetingService greetingService = new GreetingServiceImp(greetingDAO);
        GreetingController greetingController = new GreetingController(greetingService);

        app.get("/", greetingController.landingPage);

        app.get("/greeting/{id}", greetingController.getGreeting);

        logger.info("Starting Javalin on port ");
        app.start(8081);

    }
}
