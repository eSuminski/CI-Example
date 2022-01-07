package dev.suminki.app;

import dev.suminki.c.GreetingController;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.dal.GreetingDAOImp;
import dev.suminki.sl.GreetingService;
import dev.suminki.sl.GreetingServiceImp;
import io.javalin.Javalin;


public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(
                javalinConfig -> {
                    javalinConfig.enableCorsForAllOrigins();
                    javalinConfig.enableDevLogging();
                }
        );

        GreetingDAO greetingDAO = new GreetingDAOImp();
        GreetingService greetingService = new GreetingServiceImp(greetingDAO);
        GreetingController greetingController = new GreetingController(greetingService);

        app.get("/", greetingController.landingPage);

        app.get("/greeting/{id}", greetingController.getGreeting);

        app.start(8081);

    }
}
