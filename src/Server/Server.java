package Server;

import Domain.User;
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
    private static ServerSocket serverSocket;
    private Socket clientSocket;
    private Controller controller;
    private ServerDao serverDao = new ServerDao();
    private boolean shouldRun = true;
    private final int PORT = 1343;
    private static List<MultithreadedServer> connections = new ArrayList<>();
    private MultithreadedServer serverThread;

    HashMap<String ,MultithreadedServer> connectionsUsers = serverDao.getUsersAndConnections();

    @Override
    public void startServer(){
        try
        {
            this.serverSocket = new ServerSocket(PORT);
            System.out.println("1");
            while (shouldRun)
            {
                System.out.println("2");
                clientSocket = serverSocket.accept();
                System.out.println("3");
                serverThread = new MultithreadedServer(this ,clientSocket);
                System.out.println("4");
                serverThread.start();
                System.out.println("5");
                connections.add(serverThread);
//                connectionsUsers.put()
            }
        }
        catch (Exception e)
        {
            System.out.println(
                    "PROBLEM ><><><>< Server.Java >><><><><><><><><><><><>< startServer() ><><><><><><><><><><><><><><><><");
        }
    }

    public ServerSocket getServerSocket(){
        return this.serverSocket;
    }

    public void signUp(String username,String name){
        User user = new User(username,name);
        try
        {
            System.out.println("CHANCHINCHANDICHANDYFUIEBRENWRERO");
            serverDao.storeInFile(user);
        }
        catch (Exception e)
        {
            System.out.println("KONETON PARAST");
        }

    }



    public List<MultithreadedServer> getConnections() {
        return connections;
    }
}
