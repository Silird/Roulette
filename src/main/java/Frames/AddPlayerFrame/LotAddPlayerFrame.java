package Frames.AddPlayerFrame;

import Frames.MyTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LotAddPlayerFrame {
    public JPanel panelLot;
    public JLabel labelRegisterNick, labelRate, labelLots;
    public MyTable tableLots;
    public DefaultTableModel modelLots;
    public JScrollPane scrollLots;
    public LotControlAddPlayerFrame lotControlStruct;

    public LotAddPlayerFrame(Player currentPlayer) {
        labelLots = new JLabel("Выставленные предметы:");
        if (currentPlayer.getNickName() != null) {
            labelRegisterNick = new JLabel("Игрок: " + currentPlayer.getNickName());
        }
        else {
            labelRegisterNick = new JLabel("Регистрация не пройдена");
        }
        labelRate = new JLabel("Общая цена: " + String.valueOf(currentPlayer.getRate()));
        String columns[] = {"Предмет", "Цена", "Количество"};
        modelLots = new DefaultTableModel(null, columns);
        tableLots = new MyTable(modelLots);
        scrollLots = new JScrollPane(tableLots);

        lotControlStruct = new LotControlAddPlayerFrame(currentPlayer);

        panelLot = new JPanel();
        panelLot.setLayout(new BoxLayout(panelLot, BoxLayout.Y_AXIS));
        panelLot.add(labelLots);
        panelLot.add(labelRegisterNick);
        panelLot.add(labelRate);
        panelLot.add(scrollLots);
        panelLot.add(lotControlStruct.panelLotControl);
    }
}
