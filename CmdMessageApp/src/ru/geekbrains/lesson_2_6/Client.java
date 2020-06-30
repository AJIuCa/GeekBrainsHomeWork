package ru.geekbrains.lesson_2_6;

import java.io.*;
import java.net.Socket;

public class Client {

    private final String SERVER_Address = "localhost";
    private final int SERVER_PORT = 503;
    private DataInputStream in;
    private DataOutputStream out;
    private DataInputStream accept;
    private DataOutputStream send;
    private BufferedReader text;
    private Socket socket;

    public static void main(String[] args) throws IOException {

        new Client().runClient();
    }

    public void runClient() throws IOException {

        try {
            socket = new Socket(SERVER_Address, SERVER_PORT);
            text = new BufferedReader(new InputStreamReader(System.in));
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connecting to server");

            Thread outcome = new Thread(()-> {
                try {
                    sendMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread income = new Thread(()-> {
                try {
                    acceptMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            outcome.start();
            income.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public void sendMsg() throws IOException {

            while (!socket.isOutputShutdown()) {
                if (text.ready()) {
                    String textToServer = text.readLine();
                    out.writeUTF(textToServer);
                    System.out.println("Client send msg = " + textToServer);
                    if (textToServer.equals("/disconnect")) {
                        System.out.println("Connection lost");
                        break;
                    }
                    System.out.println("Client send msg and wait server echo");
                    String message = in.readUTF();
                    System.out.println("Client take message from server = " + message);
                }
            }
         }
     public void acceptMsg () throws IOException {
             accept = new DataInputStream(socket.getInputStream());
             send = new DataOutputStream(socket.getOutputStream());

             while (true) {
                 String message = accept.readUTF();
                 System.out.println("Server take message from client = " + message);
                 if (message.equals("/disconnect")) {
                     System.out.println("Client disconnect");
                     break;
                 }
                 System.out.println("Server Wrote message to client.");
                 send.writeUTF(message);

             }
         }
    }
