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

    public Controller(Server server) {
        this.server = server;
    }

    public void identifiear(String str){
        System.out.println("Avale begayi");
        String[] words= str.split("#");
        System.out.println("dovom");
        if (words[0].equalsIgnoreCase("signup")){
            System.out.println(words[0]);
            System.out.println("sevom");
            server.signUp(words[1],words[2]);
            System.out.println("11111111111");
        }
        if (words[0].equalsIgnoreCase("signin")){
            System.out.println("===");
            System.out.println(words[1]+"  [R][A][D][ * ][M][D][M][A]");
            server.signIn(words[1]);
        }
    }

}
