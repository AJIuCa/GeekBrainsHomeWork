package ru.geekbrains.lesson_2_8;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements BrowseConnection {

    public static void main (String[] args) {

        new Server();

    }

    private ArrayList <Client> clients = new ArrayList<>();

    @Override
    public synchronized void connectionSuccessfull(Client client) {
        clients.add(client);
        try {
            sendMsgToChat("-= " + client + " is connected =-");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void incomingMessage(Client client, String value) {
        try {
            sendMsgToChat(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public synchronized void connectionLost(Client client) {
        clients.remove(client);
        try {
            sendMsgToChat("-= Client RIP =-");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private Server()  {

        try {
            ServerSocket serverSocket = new ServerSocket(5003);

            System.out.println("-= Local port: " + serverSocket.getLocalPort() + " =- ");
            System.out.println("-= Server staring =- ");

            while (true) {
                try {
                    new Client(serverSocket.accept(), this);
                    System.out.println("-= Client connected =-");
                }
                catch (IOException e) {

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendMsgToChat (String value) throws IOException {
        System.out.println(value);
        for (int i=0; i<clients.size();i++) {
            clients.get(i).sendMsg(value);
        }

    }


}
