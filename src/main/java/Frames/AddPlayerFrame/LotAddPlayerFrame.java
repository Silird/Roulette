package Frames.AddPlayerFrame;

import Frames.MyTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LotAddPlayerFrame extends JPanel {
    public JLabel labelRegisterNick, labelRate, labelLots;
    public MyTable tableLots;
    public DefaultTableModel modelLots;
    public JScrollPane scrollLots;
    public LotControlAddPlayerFrame lotControlStruct;

    public LotAddPlayerFrame(Player currentPlayer) {
        super();
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelLots);
        this.add(labelRegisterNick);
        this.add(labelRate);
        this.add(scrollLots);
        this.add(lotControlStruct);
    }
}
