package Frames.MainFrame;

import Frames.MyTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlayersMainFrame extends JPanel {
    public JLabel labelPlayers;
    public JScrollPane scrollPlayers;
    public MyTable tablePlayers;
    public DefaultTableModel modelPlayers;

    public PlayersMainFrame() {
        super();
        labelPlayers = new JLabel("Игроки:");
        String columns[] = {"Игрок", "Внесённая сумма", "Шанс победы"};
        modelPlayers = new DefaultTableModel(null, columns);
        tablePlayers = new MyTable(modelPlayers);
        scrollPlayers = new JScrollPane(tablePlayers);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelPlayers, BorderLayout.NORTH);
        this.add(scrollPlayers, BorderLayout.SOUTH);


    }
}
