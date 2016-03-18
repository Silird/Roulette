package Listeners.AddLotListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Фокус слушатель для поля количества создаваемых лотов
 */
public class ListenerFocusCountField implements FocusListener {
    private JTextField textCount;

    public ListenerFocusCountField(JTextField c) {
        textCount = c;
    }

    public void focusGained(FocusEvent e) {
        if (textCount.getText().equals("1")) {
            textCount.setText("");
            textCount.setForeground(Color.BLACK);
        }
    }

    public void focusLost(FocusEvent e) {
        if (textCount.getText().equals("")) {
            textCount.setText("1");
            textCount.setForeground(Color.LIGHT_GRAY);
        }
    }
}
