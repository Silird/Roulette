package Listeners.AddPlayerListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Отмена добавления игрока
 * Закрытие формы
 */
public class ListenerPlayerCancel implements ActionListener {
    private JDialog owner;

    public ListenerPlayerCancel(JDialog o) {
        owner = o;
    }

    public void actionPerformed(ActionEvent e) {
        owner.setVisible(false);
    }
}
