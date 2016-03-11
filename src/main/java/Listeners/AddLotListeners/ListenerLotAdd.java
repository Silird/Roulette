package Listeners.AddLotListeners;

import Structures.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerLotAdd implements ActionListener {
    private JDialog owner;
    private JTextField textName, textCost;
    private Player currentPlayer;

    public ListenerLotAdd(JDialog o, JTextField tN, JTextField tC, Player cP) {
        owner = o;
        textName = tN;
        textCost = tC;
        currentPlayer = cP;
    }

    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        int cost = Integer.valueOf(textCost.getText());
        currentPlayer.addLot(name, cost);
        owner.setVisible(false);
    }
}
