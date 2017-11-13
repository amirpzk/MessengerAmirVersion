package Main;

import Client.Client;
import Front.UISignUp;
import Client.MultithreadedClient;

/**
 * Created by amirpez on 11/12/17.
 */
public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client() ;
        MultithreadedClient c = client.getClientThread();
        UISignUp uiSignUp = new UISignUp(client);
    }
}
