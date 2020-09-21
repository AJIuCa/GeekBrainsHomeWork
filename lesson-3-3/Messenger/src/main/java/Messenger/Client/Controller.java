package Messenger.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Controller {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String myNick;

    @FXML
    TextArea mainTextArea;

    @FXML
    TextArea clientWindow;

    @FXML
    TextField textField;

    byte[] history = new byte[1000];

    public Controller() {
    }

    public void start() {

        myNick = " ";

        try {
            socket = new Socket("localhost", 8189);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(() -> {
                try {
                    while (true) {
                        String strMsg = dis.readUTF();
                        if (strMsg.startsWith("Client")) {



//                            try (FileInputStream filesInputStream = new FileInputStream("historyLogs.txt")) {
//                                if (filesInputStream == null) {
//                                    FileOutputStream createFile = new FileOutputStream("historyLogs.txt");
//                                }
//                                ArrayList<String> historyArrString = new ArrayList<>();
//                                int count;
//
//                                while ((count = filesInputStream.read(history)) > 0) {
//                                    for (int i = 0; i < count; i++) {
//                                        historyArrString.add(String.valueOf((char) history[i]));
//                                    }
//                                }
//                                    if (historyArrString.size() > 10) {
//                                        for (int i=historyArrString.size()-10; i<=historyArrString.size()-1; i++) {
//                                            mainTextArea.appendText(historyArrString.get(i) + "\n");
//                                        }
//                                        } else {
//                                        mainTextArea.appendText("\n");
//                                    }
//
//                            } catch (IOException e) {
//                            }

                            try (FileInputStream filesInputStream = new FileInputStream("historyLogs.txt")) {
                                if (filesInputStream == null) {
                                    FileOutputStream createFile = new FileOutputStream("historyLogs.txt");
                                }

                                ArrayList<String> historyArrString = new ArrayList<>();
                                Path path = Paths.get("historyLogs.txt");
                                historyArrString = (ArrayList<String>) Files.readAllLines(path);


//                                ArrayList<String> historyArrString = new ArrayList<>();
//                                try (FileReader historyReader = new FileReader("historyLogs.txt")) {
//                                    StringBuffer sb = new StringBuffer();
//                                    while (historyReader.ready()) {
//                                        char chr = (char) historyReader.read();
//                                        if (chr == '\n') {
//                                            historyArrString.add(sb.toString());
//                                        } else {
//                                            sb.append(chr);


                                        if (historyArrString.size() > 10) {
                                        for (int i=historyArrString.size()-10; i<=historyArrString.size()-1; i++) {
                                            mainTextArea.appendText(historyArrString.get(i) + "\n");
                                        }
                                        } else {
                                        mainTextArea.appendText("\n");
                                    }
                                            mainTextArea.appendText("\n");

                            } catch (IOException e) {
                            }

                            myNick = strMsg.split("\\s")[1];
                            mainTextArea.appendText(strMsg + "\n");
                            clientWindow.appendText(myNick + "\n");
                            break;
                        }
                    }
                    while (true) {
                        String strMsg = dis.readUTF();
                        if (strMsg.equals("/exit")) {
                            break;
                        }
                        mainTextArea.appendText(strMsg + " " + "\n");


                        strMsg = strMsg + "\n";
                        history = strMsg.getBytes();
                        try (FileOutputStream out = new FileOutputStream("historyLogs.txt",true)) {
                            out.write(history);
                        } catch (IOException e) {

                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        mainTextArea.appendText("Вы вышли из чата.");
                        socket.close();
                        myNick = "";
                        System.exit(0);
                    } catch (IOException e) {

                    }
                }
            });
            t1.setDaemon(true);
            t1.start();
        } catch (IOException e) {
        }
    }

    public void sendMsg(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            start();
        }
        try {
            if (textField.getText().trim().isEmpty() || textField.getText().trim().equals("")) {
                textField.clear();
                return;
            }
            dos.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            System.out.println("По техническим причинам сообщение не было отправлено");
        }
    }
}