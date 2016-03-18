package Listeners.AddLotListeners;

import Structures.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Добавление нового лота
 * Закрытие формы
 */
public class ListenerLotAdd implements ActionListener {
    private JDialog owner;
    private JTextField textName, textCost, textCount;
    private Player currentPlayer;

    public ListenerLotAdd(JDialog o, JTextField tN, JTextField tC, JTextField tCou, Player cP) {
        owner = o;
        textName = tN;
        textCost = tC;
        textCount = tCou;
        currentPlayer = cP;
    }

    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        int cost = Integer.valueOf(textCost.getText());
        int count = Integer.valueOf(textCount.getText());
        currentPlayer.addLot(name, cost, count);
        owner.setVisible(false);
    }
}
