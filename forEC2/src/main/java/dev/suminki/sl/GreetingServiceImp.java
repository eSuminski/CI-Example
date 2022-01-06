package dev.suminki.sl;

import dev.suminki.ce.BadConnection;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.entities.Greeting;

public class GreetingServiceImp implements GreetingService{
    private GreetingDAO greetingDAO;

    public GreetingServiceImp(GreetingDAO greetingDAO){
        this.greetingDAO = greetingDAO;
    }

    @Override
    public Greeting getGreetingService(int id) {
        try{
            return this.greetingDAO.getGreeting(id);
        } catch (BadConnection e){
            throw new BadConnection(e.getMessage());
        }
    }
}
