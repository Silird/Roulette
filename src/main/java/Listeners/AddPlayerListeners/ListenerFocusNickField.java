package Listeners.AddPlayerListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Фокус слушатель для поля ввода никнейма
 */
public class ListenerFocusNickField implements FocusListener {
    private JTextField textNickName;

    public ListenerFocusNickField(JTextField n) {
        textNickName = n;
    }

    public void focusGained(FocusEvent e) {
        if (textNickName.getText().equals("никнейм")) {
            textNickName.setText("");
            textNickName.setForeground(Color.BLACK);
        }
    }

    public void focusLost(FocusEvent e) {
        if (textNickName.getText().equals("")) {
            textNickName.setText("никнейм");
            textNickName.setForeground(Color.LIGHT_GRAY);
        }
    }
}
