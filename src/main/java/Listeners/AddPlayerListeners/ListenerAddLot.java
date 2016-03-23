package Listeners.AddPlayerListeners;

import Frames.AddLotFrame.AddLotFrame;
import Listeners.AddPlayerListeners.Functions.RefreshLotTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Открытие формы для добавления нового лота
 * Обновление таблицы и лэйблов
 */
public class ListenerAddLot implements ActionListener {
    private JDialog owner;
    private Player currentPlayer;
    private DefaultTableModel modelLots;
    private JLabel labelRate;

    public ListenerAddLot(JDialog o, Player cP, DefaultTableModel mL, JLabel lR) {
        owner = o;
        currentPlayer = cP;
        modelLots = mL;
        labelRate = lR;
    }

    public void actionPerformed(ActionEvent e) {
        new AddLotFrame(currentPlayer, owner);
        new RefreshLotTable(modelLots, currentPlayer);
        labelRate.setText("Общая цена: " + String.valueOf(currentPlayer.getRate()));
    }
}
