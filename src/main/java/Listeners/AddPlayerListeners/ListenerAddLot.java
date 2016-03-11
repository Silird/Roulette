package Listeners.AddPlayerListeners;

import Frames.AddLotFrame;
import Listeners.AddPlayerListeners.Functions.RefreshTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAddLot implements ActionListener {
    private JDialog owner;
    private Player currentPlayer;
    private DefaultTableModel modelLots;

    public ListenerAddLot(JDialog o, Player cP, DefaultTableModel mL) {
        owner = o;
        currentPlayer = cP;
        modelLots = mL;
    }

    public void actionPerformed(ActionEvent e) {
        new AddLotFrame(currentPlayer, owner);
        new RefreshTable(modelLots, currentPlayer);
    }
}