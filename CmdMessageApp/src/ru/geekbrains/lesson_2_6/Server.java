package ru.geekbrains.lesson_2_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private DataInputStream acceptMsg;

    private BufferedReader msg;
    private DataOutputStream sendServerMsg;


    public static void main(String[] args) {

        new Server().runServer();

    }

    public void runServer() {

        try (ServerSocket serverSocket = new ServerSocket(503)) {
            System.out.println("\n-= Starting server (local port = " + serverSocket.getLocalPort() + "). Waiting for connection =-");
            socket = serverSocket.accept();
            System.out.println(" -= Client connected =-");

            Thread thread1 = new Thread(() -> {
                try {
                    acceptMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    sendMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            thread1.start();
            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void acceptMsg() throws IOException {

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String message = in.readUTF();
            System.out.println("Server take message from client = " + message);
            if (message.equals("/disconnect")) {
                System.out.println("Client disconnect");
                break;
            }
            System.out.println("Server Wrote message to client.");
            out.writeUTF(message);

        }
    }


    public void sendMsg() throws IOException {

        acceptMsg = new DataInputStream(socket.getInputStream());
        sendServerMsg = new DataOutputStream(socket.getOutputStream());
        msg = new BufferedReader(new InputStreamReader(System.in));

        while (!socket.isOutputShutdown()) {
            if (msg.ready()) {
                String textToClient = msg.readLine();
                sendServerMsg.writeUTF(textToClient);
                System.out.println("Server send msg = " + textToClient);
                if (textToClient.equals("/disconnect")) {
                    System.out.println("Connection lost");
                    break;
                }
                System.out.println("Server send msg to client");
                String message = acceptMsg.readUTF();
                System.out.println("Server take message from server = " + message);
            }
        }
    }
}

