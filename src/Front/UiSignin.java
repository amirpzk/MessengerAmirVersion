package Front;

import Client.Client;
import Client.MultithreadedClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amirpez on 11/4/17.
 */
public class UiSignin extends JFrame{

    private JTextField tfUsername;
    private JButton btnSubmit;
    Client c;
    private MultithreadedClient client;


    public UiSignin(Client client) {
        this.c = client;

        this.setSize(300, 100);
        this.setTitle("UiRegister");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());


        this.tfUsername = new JTextField("User");
        this.btnSubmit = new JButton("Submit");

        this.tfUsername.setPreferredSize(new Dimension(100, 30));

        this.add(tfUsername);
        this.add(btnSubmit);

        c.startClient();
        MultithreadedClient clientThread = c.getClientThread();

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("-00");
                clientThread.sendStringToServer("signin#" + tfUsername.getText());
                System.out.println("00");
                if (clientThread.getLoginAccesFromServer() == true) {
                    System.out.println("11");
                    System.out.println("LoginAccepted");
                } else {
                    System.out.println("22");
                    System.out.println("LoginFailed");
                }
            }
        });

        this.setVisible(true);
    }




}