package Listeners.MainFrameListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Выход из программы
 */
public class ListenerExit implements ActionListener {
    /**
     * Выход из программы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
