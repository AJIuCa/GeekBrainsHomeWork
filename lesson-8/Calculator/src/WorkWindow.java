import javax.swing.*;
import java.awt.*;

public class WorkWindow extends JFrame {


    public WorkWindow(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel windowForCalcSymbols = new JPanel();
        windowForCalcSymbols.setPreferredSize(new Dimension(300, 300));

        JPanel windowForText = new JPanel();
        windowForCalcSymbols.setPreferredSize(new Dimension(100, 100));


        JPanel textZone = new JPanel();
        textZone.setPreferredSize(new Dimension(300, 50));
        textZone.setLayout(new BorderLayout());

        JTextField textWindow = new JTextField();
        textWindow.setEditable(false);

        textZone.add(textWindow, BorderLayout.CENTER);

        JPanel calcSymblos = new JPanel();
        calcSymblos.setPreferredSize(new Dimension(300, 300));
        calcSymblos.setLayout(new GridLayout(4, 4, 10, 10));

        String[] calcSymbols = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "+/-", "x", "0", "/", "="};
        for (int i = 0; i < calcSymbols.length; i++) {
            JButton button = new JButton(String.valueOf(calcSymbols[i]));
            button.setSize(50, 30);
            button.addActionListener(new Action(textWindow));

            calcSymblos.add(button);
        }

        windowForCalcSymbols.add(calcSymblos);
        windowForText.add(textZone);

        add(windowForText, BorderLayout.NORTH);
        add(windowForCalcSymbols, BorderLayout.CENTER);
    }
}


