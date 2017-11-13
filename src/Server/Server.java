package Server;

import Client.MultithreadedClient;
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

    static HashMap<String ,MultithreadedServer> connectionsUsers = new HashMap<>();

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
        System.out.println("amir1");
        User user = new User(username,name);
        System.out.println("amir2");
        try
        {
            System.out.println("amir3");
            serverDao.storeInFile(user);
            System.out.println("amir4");
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM <><><> Server.java <><>< signUp ><><>");
        }

    }

    public void signIn(String username){
        System.out.println("SingInServer1");
        if (serverDao.readOnFile(username)!=null)
        {
            User user = (User)serverDao.readOnFile(username);
            System.out.println("user synced *.*.*.* [Server]><><><[signIn]");
            connectionsUsers.put(user.getUsername(),serverThread);
            serverThread.sendLoginAccesToClient(true);
        }
        else
        {
            serverThread.sendLoginAccesToClient(false);
        }
    }



    public List<MultithreadedServer> getConnections() {
        return connections;
    }
}
