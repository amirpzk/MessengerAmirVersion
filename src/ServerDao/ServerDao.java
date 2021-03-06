package ServerDao;

import Domain.User;
import Server.MultithreadedServer;

import java.io.*;
import java.util.HashMap;

/**
 * Created by amirpez on 11/11/17.
 */
public class ServerDao {
    private static HashMap<String, MultithreadedServer> usersAndConnections = new HashMap<>();

    public void storeInFile(User user){
        File file = new File("/Users/amirpez/Desktop/"+user.getUsername()+".ser");
        System.out.println("Davood");
        try
        {
            FileOutputStream f = new FileOutputStream(file);
            System.out.println("00000");
            ObjectOutputStream os = new ObjectOutputStream(f);
            System.out.println("111111");
            os.writeObject(user);
            System.out.println("222222");
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM <> ServerDao >> storeInFile");
        }

    }

    public Object readOnFile(String username){
        try
        {
            FileInputStream f = new FileInputStream("/Users/amirpez/Desktop/"+username+".ser");
            ObjectInputStream oi = new ObjectInputStream(f);
            return oi.readObject();
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM <><><> ServerDao >>> readOnFile");
            return null;
        }
    }

    public HashMap<String,MultithreadedServer> getUsersAndConnections(){
        return usersAndConnections;
    }
}
