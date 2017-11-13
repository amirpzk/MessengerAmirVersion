package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by amirpez on 11/11/17.
 */
public class MultithreadedClient extends Thread {
    private Socket clientSocket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean shouldRun = true;
//    private ClientGUI gui;

    public MultithreadedClient(Socket clientSocket, Client client) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {

            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());

            while (shouldRun) {
                try {
                    while (dis.available() == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                            System.out.println("Problem1 , Class MultiThreadedCient , Method >> run() ");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Problem2 , Class MultiThreadedCient , Method >> run() ");
                }
            }
            String reply = dis.readUTF();

            System.out.println("THIS IS MESSEGE " + reply);

        } catch (Exception e) {
            System.out.println("Problem3 , Class MultiThreadedCient , Method >> run() ");
        }
    }

    public void sendStringToServer(String text) {
        try {
            dos.flush();
            dos.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getLoginAccesFromServer(){
        boolean isTrue = false ;
        while (true){
            try {
                System.out.println("before begayi");
                System.out.println(dis.readUTF());
                String iisTrue = dis.readUTF();
                System.out.println("after begayi");
                if ( iisTrue.equalsIgnoreCase("true")){
                    isTrue = true;
                }
                return isTrue ;
            } catch (IOException e) {
                System.out.println("CHANCHI IS HERE");
                e.printStackTrace();
            }
        }
    }

    protected void close() {
        try {
            dis.close();
            dos.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
