package Listeners.AddPlayerListeners;

import Frames.AddLotFrame.AddLotFrame;
import Frames.AddPlayerFrame.LotAddPlayerFrame;
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
    private LotAddPlayerFrame lotStruct;

    public ListenerAddLot(JDialog o, Player cP, LotAddPlayerFrame lS) {
        owner = o;
        currentPlayer = cP;
        lotStruct = lS;
    }

    public void actionPerformed(ActionEvent e) {
        new AddLotFrame(currentPlayer, owner);
        new RefreshLotTable(lotStruct.modelLots, currentPlayer);
        lotStruct.labelRate.setText("Общая цена: " + String.valueOf(currentPlayer.getRate()));
    }
}
