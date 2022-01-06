package com.suminski.tests.dalt;

import dev.suminki.ce.BadConnection;
import dev.suminki.dal.GreetingDAO;
import dev.suminki.dal.GreetingDAOImp;
import dev.suminki.entities.Greeting;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GreetingDAOTests {
    public static GreetingDAO greetingDAO;

    @BeforeClass
    public void setup(){
        greetingDAO = new GreetingDAOImp();
    }

    @Test
    public void getRealGreeting(){
        Greeting greeting = greetingDAO.getGreeting(1);
        Assert.assertEquals(greeting.getMessage(), "Hello! Fine day we are having, isnt it?");
    }

    @Test(expectedExceptions = BadConnection.class, expectedExceptionsMessageRegExp = "There was an error: please try again!")
    public void getNoGreetingMatchingInputFoundMessage(){
        Greeting greeting = greetingDAO.getGreeting(1111);
    }


}
