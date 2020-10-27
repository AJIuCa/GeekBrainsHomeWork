import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {
    private JTextField textField;

    public Action(JTextField jTextField) {
        this.textField = jTextField;
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        JButton pressButton = (JButton) e.getSource();
        textField.setText(textField.getText() + pressButton.getText());
    }
    }
