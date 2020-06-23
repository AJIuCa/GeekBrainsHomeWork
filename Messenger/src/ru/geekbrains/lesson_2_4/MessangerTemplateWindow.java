package ru.geekbrains.lesson_2_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MessangerTemplateWindow extends JFrame {

    protected JTextField textAddWindow;
    protected JTextArea textViewWindow;

    public MessangerTemplateWindow(String title) {

        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
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


// Зона просмотра текста

        JPanel viewTextZone = new JPanel();
        viewTextZone.setPreferredSize(new Dimension(500, 420));
        viewTextZone.setBackground(new Color(0x62CD88D2, true));
        JPanel windowForViewText = new JPanel();
        windowForViewText.setPreferredSize(new Dimension(400, 400));
        windowForViewText.setLayout(new BorderLayout());

        textViewWindow = new JTextArea();
        textViewWindow.setEditable(false);
        JScrollPane scrollingHistory = new JScrollPane(textViewWindow);
        windowForViewText.add(scrollingHistory, BorderLayout.CENTER);
        viewTextZone.add(windowForViewText, BorderLayout.CENTER);


// Добавление наших зон

        add(addTextZone, BorderLayout.CENTER);
        revalidate();
        add(viewTextZone, BorderLayout.NORTH);
        revalidate();


    }

    public void sendMessage() {

        String message = textAddWindow.getText();

        if (textViewWindow.getText() != null) {

            textViewWindow.setText(textViewWindow.getText() + ("\n" + message));
            textAddWindow.setText("");

        } else {

            textViewWindow.setText(message);
            textAddWindow.setText("");
        }
    }
}
