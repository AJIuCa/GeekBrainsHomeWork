package ru.geekbrains.lesson_2_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ClientSkin extends JFrame implements BrowseConnection {

    private JTextField textAddWindow;
    private JTextArea textViewWindow;
    private JTextField nickName;
    private static final String IP = "localhost";
    private static final int PORT = 5003;
    private Client clientConnection;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientSkin( "New Messenger");
            }
        });

    }

    private ClientSkin(String value) {
//        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        try {
            clientConnection = new Client(IP, PORT, this);
        } catch (IOException e) {
            printMsg("Error connection: " + e);
        }
        setResizable(true);
        setLayout(new BorderLayout());


// Зона набора текста

        JPanel addTextZone = new JPanel();
        addTextZone.setPreferredSize(new Dimension(500, 60));
        addTextZone.setBackground(new Color(0x62CD88D2, true));

        JPanel windowForAddText = new JPanel();
        windowForAddText.setPreferredSize(new Dimension(340, 30));
        windowForAddText.setLayout(new BorderLayout());

        textAddWindow = new JTextField("", 1);
        textAddWindow.setEditable(true);
        textAddWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                    textAddWindow.grabFocus();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JButton enterButton = new JButton("➤✉");
        enterButton.setSize(50, 30);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
                textAddWindow.grabFocus();
            }
        });

        windowForAddText.add(textAddWindow, BorderLayout.CENTER);
        addTextZone.add(windowForAddText, BorderLayout.CENTER);
        addTextZone.add(enterButton, BorderLayout.EAST);


// Зона просмотра текста и ника

        JPanel viewTextZone = new JPanel();
        viewTextZone.setPreferredSize(new Dimension(500, 420));
        viewTextZone.setBackground(new Color(0x62CD88D2, true));
        JPanel windowForViewText = new JPanel();
        windowForViewText.setPreferredSize(new Dimension(400, 420));
        windowForViewText.setLayout(new BorderLayout());

        JPanel nickNameZone = new JPanel();
        nickNameZone.setPreferredSize(new Dimension(60, 420));
        nickNameZone.setBackground(new Color(0x62CD88D2, true));

        nickName = new JTextField("Bob");
        nickName.setPreferredSize(new Dimension(60, 420));
        nickName.setEditable(false);


        textViewWindow = new JTextArea();
        textViewWindow.setEditable(false);
        JScrollPane scrollingHistory = new JScrollPane(textViewWindow);
        windowForViewText.add(scrollingHistory, BorderLayout.CENTER);
        viewTextZone.add(windowForViewText, BorderLayout.CENTER);

        viewTextZone.add(nickNameZone, BorderLayout.EAST);
        nickNameZone.add (nickName, BorderLayout.NORTH);







// Добавление наших зон

        add(addTextZone, BorderLayout.CENTER);
        add(viewTextZone, BorderLayout.NORTH);
        revalidate();



    }

    public void sendMessage() {

        String message = textAddWindow.getText();

        if (textViewWindow.getText() != null) {

            textViewWindow.setText(textViewWindow.getText() + ("\n"+ nickName.getText() + ": " + message));
            textAddWindow.setText("");

        } else {

            textViewWindow.setText(message);
            textAddWindow.setText("");
        }
    }

    @Override
    public void connectionSuccessfull(Client client) {
        printMsg("Connection Successfull");
    }

    @Override
    public void incomingMessage(Client client, String value) {
        printMsg(value);
    }

    @Override
    public void connectionLost(Client client) {
        printMsg("Connection lost");

    }

    private synchronized void printMsg (String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textViewWindow.append(msg + "\n");
            }
        });

    }


}
