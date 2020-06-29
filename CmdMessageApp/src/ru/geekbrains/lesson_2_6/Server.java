package ru.geekbrains.lesson_2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        new Server().runServer();
    }

    public void runServer() {

        try (ServerSocket serverSocket = new ServerSocket(503)) {
            System.out.println("\n-= Starting server (local port = " + serverSocket.getLocalPort() + "). Waiting for connection =-");
            Socket socket = serverSocket.accept();
            System.out.println(" -= Client connected =-");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
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

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

