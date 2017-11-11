package ServerDao;

import Server.MultithreadedServer;

import java.util.HashMap;

/**
 * Created by amirpez on 11/11/17.
 */
public class ServerDao {
    private static HashMap<String, MultithreadedServer> usersAndConnections = new HashMap<>();

    public HashMap<String,MultithreadedServer> getUsersAndConnections(){
        return usersAndConnections;
    }
}
