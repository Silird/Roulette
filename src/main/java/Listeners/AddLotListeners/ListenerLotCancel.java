package Listeners.AddLotListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Отмена добавления лота
 * Закрытие формы
 */
public class ListenerLotCancel implements ActionListener {
    private JDialog owner;

    public ListenerLotCancel(JDialog o) {
        owner = o;
    }

    public void actionPerformed(ActionEvent e) {
        owner.setVisible(false);
    }
}
