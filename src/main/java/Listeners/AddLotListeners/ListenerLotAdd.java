package Listeners.AddLotListeners;

import Frames.AddLotFrame.AddLotFrame;
import Frames.AddLotFrame.LotAddLotFrame;
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
    private LotAddLotFrame lotStruct;
    //private JTextField textName, textCost, textCount;
    private Player currentPlayer;

    public ListenerLotAdd(JDialog o, LotAddLotFrame lS, Player cP) {
        owner = o;
        lotStruct = lS;
        currentPlayer = cP;
    }

    public void actionPerformed(ActionEvent e) {
        String name = lotStruct.textName.getText();
        int cost = Integer.valueOf(lotStruct.textCost.getText());
        int count = Integer.valueOf(lotStruct.textCount.getText());
        currentPlayer.addLot(name, cost, count);
        owner.setVisible(false);
    }
}
