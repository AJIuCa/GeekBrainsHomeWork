package Messenger.Server.handler;

import Messenger.Server.inter.Server;
import Messenger.Server.service.ServerImpl;
import javafx.fxml.FXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

    public static final Logger LOGGER = LogManager.getLogger(ServerImpl.class);

    private Server server;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String nick;

    public String getNick() {

        return this.nick;

    }

    @FXML
    TextField textField;
    TextField clientWindow;



//    public ClientHandler(Server server, Socket socket) {
//
//        try {
//            this.server = server;
//            this.socket = socket;
//            this.dis = new DataInputStream(socket.getInputStream());
//            this.dos = new DataOutputStream(socket.getOutputStream());
//            this.nick = " ";
//            new Thread(() -> {
//                try {
//                    boolean authenticationSuccessful = false;
//                    int timeout = 120000;
//                    long connectionTime = System.currentTimeMillis();
//                    while (System.currentTimeMillis() - connectionTime <= timeout) {
//                        authenticationSuccessful = authentication();
//                        if(authenticationSuccessful){break;}
//                    }
//                    if(authenticationSuccessful) {
//                        readMessage();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    closeConnection();
//                }
//            }).start();
//
//
//
//        } catch (IOException e) {
//            throw new RuntimeException("Проблемы при создании обработчика клиента");
//        }
//    }


    public ClientHandler(Server server, Socket socket) {



             ExecutorService execute = Executors.newCachedThreadPool();

                try {
                    this.server = server;
                    this.socket = socket;
                    this.dis = new DataInputStream(socket.getInputStream());
                    this.dos = new DataOutputStream(socket.getOutputStream());
                    this.nick = " ";


                    execute.submit(() -> {

                        LOGGER.info("New Thread created");

                        try {
                        boolean authenticationSuccessful = false;
                        int timeout = 120000;
                        long connectionTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - connectionTime <= timeout) {
                            authenticationSuccessful = authentication();

                            if(authenticationSuccessful){break;}
                         }
                            if(authenticationSuccessful) {
                            readMessage();
                         }
                             } catch (IOException e) {
                                 e.printStackTrace();
                             } finally {
                                 closeConnection();
                                }
                            });


                } catch (IOException e) {
                    throw new RuntimeException("Проблемы при создании обработчика клиента");
                }
        }

    private boolean authentication() throws IOException {
        while (true) {
            String str = dis.readUTF();
            if (str.startsWith("/auth")) {
                String[] dataArray = str.split("\\s");
                String nick = server.getAuthService().getNick(dataArray[1], dataArray[2]);
                if (nick != null) {
                    if (!server.isNickBusy(nick)) {
//                        sendMsg("/authOk " + nick);
                        LOGGER.info("Client successful join to channel");
                        sendMsg("Client " + nick + " join to chat");
                        this.nick = nick;
                        server.broadcastMsg(this.nick + " join the chat \n");
                        server.subscribe(this);

  //                      clientWindow = this.nick;

                    } else {
                        sendMsg("You are already logged in");
                    }
                    return true;
                } else {
                    sendMsg("Incorrect password or login");
                    return false;
                }
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String clientStr = dis.readUTF();
            if (clientStr.startsWith("/")) {
                if (clientStr.equals("/exit")) {
                    return;
                }
                if (clientStr.startsWith("/w")) {
                    String[] strArray = clientStr.split("\\s");
                    String nickName = strArray[1];
                    String msg = clientStr.substring(4 + nickName.length());
                    server.sendMsgToClient(this, nickName, msg);
                }
                continue;
            }
            server.broadcastMsg(this.nick + ": " + clientStr);
        }
    }

    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMsg(this.nick + ": out from chat");

        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}