package Server;


import Domain.User;
import Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by amirpez on 11/11/17.
 */
public class Controller {
    Server server ;
//    MultithreadedServer connection = new MultithreadedServer(server,socket);

    public Controller() {
        server = new Server();
    }

    public void identifiear(String str){
        String[] words= str.split("#");
        if (words[0].equalsIgnoreCase("signup")){
            server.signUp(words[1],words[2]);
        }
        if (words[0].equalsIgnoreCase("signin")){

        }
    }

}
