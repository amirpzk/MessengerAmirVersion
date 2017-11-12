package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Created by amirpez on 11/11/17.
 */
public class MultithreadedServer extends Thread{
    private Socket clientSocket;
    private Server server;
    private List<MultithreadedServer> connections;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean shouldRun = true;
    private Controller controller = new Controller();

    public MultithreadedServer(Server server , Socket socket){
        super("ServerConnectionThread");
        System.out.println("22");
        this.clientSocket = socket;
        System.out.println("33");
        this.server = server;
        System.out.println("44");
        this.connections = server.getConnections();
    }

//    public void sendStringToClient(String msg){
//        try
//        {
//            dos.writeUTF(msg);
//            dos.flush();
//        }
//        catch (Exception e)
//        {
//            System.out.println("PROBLEM <><><><> MultiThreadedServer >>>>> sentStringToClient");
//        }
//    }

//    public void sendStringToAllClients(String text) {
//        for(int index = 0; index < connections.size(); index++) {
//            MultithreadedServer serverThread = connections.get(index);
//            serverThread.sendStringToClient(text);
//        }
//    }

    public void run() {
        try {
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());

            while(shouldRun) {
                while(dis.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String textIn = dis.readUTF();
//                sendStringToAllClients(textIn);
                getFromClient();
            }

//            dis.close();
//            dos.close();
//            clientSocket.close();

        }
        catch (IOException e)
        {
            System.out.println("ERROR <><><><><>< MultiThreadedServer >>> run()");
            e.printStackTrace();
        }
    }


    public void getFromClient(){


                while (true)
                {
                    try {
                        controller.identifiear(dis.readUTF());
                    } catch (IOException e) {
                        System.out.println("Problem , MultiThreadedServer >>> getFromClient");
                        e.printStackTrace();
                    }
                }
            }
}

