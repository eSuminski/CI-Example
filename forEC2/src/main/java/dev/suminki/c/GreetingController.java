package dev.suminki.c;

import com.google.gson.Gson;
import dev.suminki.ce.BadConnection;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.dal.GreetingDAOImp;
import dev.suminki.entities.Greeting;
import dev.suminki.sl.GreetingService;
import dev.suminki.sl.GreetingServiceImp;
import io.javalin.http.Handler;

public class GreetingController {

    public GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    public Handler getGreeting = ctx -> {
        try{
            int id = Integer.parseInt(ctx.pathParam("id"));
            try{
                Greeting greeting = this.greetingService.getGreetingService(id);
                Gson gson = new Gson();
                String greetingJSON = gson.toJson(greeting);
                ctx.result(greetingJSON);
                ctx.status(200);
            } catch (BadConnection e){
                Greeting greeting = new Greeting(e.getMessage());
                Gson gson = new Gson();
                String greetingJSON = gson.toJson(greeting);
                ctx.result(greetingJSON);
                ctx.status(404);
            }
        } catch (NumberFormatException e){
            Greeting greeting = new Greeting("Please enter a valid number in the URL");
            Gson gson = new Gson();
            String greetingJSON = gson.toJson(greeting);
            ctx.result(greetingJSON);
            ctx.status(418);
        }

    };

}
