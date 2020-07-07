package ru.geekbrains.lesson_2_8;

import java.io.*;
import java.net.Socket;

public class Client {

    private final Socket socket;
    private final BufferedReader in;
    private final BufferedWriter out;
    private final Thread serverThread;
    private BrowseConnection browseConnection;



//    public static void main (String[] args) throws IOException {
//
//        new Client(5003, this);
//
//    }

    public Client (String IP, int Port, BrowseConnection listener) throws IOException {
        this(new Socket(IP, Port), listener);
    }


    public Client(Socket socket, BrowseConnection listener) throws IOException {

        this.browseConnection = listener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    browseConnection.connectionSuccessfull(Client.this);
                    while (!serverThread.isInterrupted()) {
                        String msg = in.readLine();
                        browseConnection.incomingMessage(Client.this, msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    ;
                } finally {

                    browseConnection.connectionLost(Client.this);

                }
            }
        });
        serverThread.start();
    }


    public void disconnect () throws IOException {
        serverThread.isInterrupted();
        socket.close();
    }

    public void sendMsg (String value) throws IOException {
        try {
            out.write(value + "\n");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
            disconnect();
        }
    }



}
