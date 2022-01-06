package com.suminski.tests.slt;

import dev.suminki.ce.BadConnection;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.dal.GreetingDAOImp;
import dev.suminki.entities.Greeting;
import dev.suminki.sl.GreetingService;
import dev.suminki.sl.GreetingServiceImp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GreetingServiceTests {

    public static GreetingDAO greetingDAO;
    public static GreetingService greetingService;

    @BeforeClass
    public void setup(){
        greetingDAO = new GreetingDAOImp();
        greetingService = new GreetingServiceImp(greetingDAO);
    }

    @Test(expectedExceptions = BadConnection.class, expectedExceptionsMessageRegExp = "There was an error: please try again!")
    public void getExceptionMessage(){
        Greeting greeting = greetingService.getGreetingService(1111);
    }


}
