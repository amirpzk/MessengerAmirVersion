package Server;

import Controller.Controller;
import ServerDao.ServerDao;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by amirpez on 11/11/17.
 */
public class Server implements ImpServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Controller controller;
    private ServerDao serverDao;
    private boolean shouldRun = true;
    private final int PORT = 6969;
    private static List<MultithreadedServer> connections = new ArrayList<>();

    HashMap<String ,MultithreadedServer> connectionsUsers = serverDao.getUsersAndConnections();

    @Override
    public void startServer(){
        try
        {
            this.serverSocket = new ServerSocket(PORT);
            while (shouldRun)
            {
                clientSocket = serverSocket.accept();
                MultithreadedServer serverThread = new MultithreadedServer(this ,clientSocket);
                serverThread.start();
                connections.add(serverThread);
                connectionsUsers.put()
            }
        }
        catch (Exception e)
        {
            System.out.println(
                    "PROBLEM ><><><>< Server.Java >><><><><><><><><><><><>< startServer() ><><><><><><><><><><><><><><><><");
        }
    }

    public List<MultithreadedServer> getConnections() {
        return connections;
    }
}
