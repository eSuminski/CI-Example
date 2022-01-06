package dev.suminki.dal;

import dev.suminki.entities.Greeting;

import java.sql.SQLException;

public interface GreetingDAO {

    Greeting getGreeting(int id);

}
