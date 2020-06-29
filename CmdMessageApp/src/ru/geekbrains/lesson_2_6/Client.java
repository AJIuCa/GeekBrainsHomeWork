package ru.geekbrains.lesson_2_6;

import java.io.*;
import java.net.Socket;

public class Client {

    private final String SERVER_Address = "localhost";
    private final int SERVER_PORT = 503;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader text;

    public static void main(String[] args) {

        new Client().runClient();
    }

    public void runClient() {

        try {
            Socket socket = new Socket(SERVER_Address, SERVER_PORT);
            text = new BufferedReader(new InputStreamReader(System.in));
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connecting to server");

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
