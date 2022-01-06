package dev.suminki.dal;

import dev.suminki.ce.BadConnection;
import dev.suminki.entities.Greeting;
import dev.suminki.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GreetingDAOImp implements GreetingDAO{

    static final public Logger greetingLogger = LoggerFactory.getLogger(GreetingDAOImp.class);

    @Override
    public Greeting getGreeting(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select message from greeting where message_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Greeting(rs.getString("message"));
        } catch (SQLException e){
            greetingLogger.warn(e.toString(), e);
            throw new BadConnection("There was an error: please try again!");
        }
    }
}
