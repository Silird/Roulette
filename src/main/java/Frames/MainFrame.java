package Frames;

import Listeners.MainFrameListeners.ListenerExit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel panelControl, panelStatus, panelView, panelPlayers;
    private JButton butExit;
    private JLabel labelPlayers, labelActivePlayers, labelRemainPlayers;
    private JScrollPane scrollPlayers;
    private JTable tablePlayers;
    private DefaultTableModel modelPlayers;
    final int NeedPlayers = 4;

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void Show() {
        InitFrame();
        InitStatus();
        InitView();
        InitControl();
        InitListeners();

        setVisible(true);
    }

    /**
     * Инициализация главной формы
     */
    private void InitFrame() {
        setTitle("Рулетка");
        setSize(700, 300);
        setMinimumSize(new Dimension(1000, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void InitStatus() {
        labelActivePlayers = new JLabel("Игроков в игре: 0    ");
        labelRemainPlayers = new JLabel("Игроков для начала: " + String.valueOf(NeedPlayers) + "    ");

        panelStatus = new JPanel();
        panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.X_AXIS));
        panelStatus.add(labelActivePlayers);
        panelStatus.add(labelRemainPlayers);

        this.add(panelStatus, BorderLayout.NORTH);
    }

    private void InitView() {
        labelPlayers = new JLabel("Игроки:");
        String columns[] = {"Игрок", "Внесённая сумма", "Шанс победы"};
        modelPlayers = new DefaultTableModel(null, columns);
        tablePlayers = new JTable(modelPlayers);
        scrollPlayers = new JScrollPane();
        scrollPlayers.add(tablePlayers);
        panelPlayers = new JPanel();
        panelPlayers.add(labelPlayers, BorderLayout.NORTH);
        panelPlayers.add(scrollPlayers, BorderLayout.SOUTH);

        panelView = new JPanel();
        panelView.add(panelPlayers, BorderLayout.WEST);

        this.add(panelView, BorderLayout.CENTER);
    }

    private void InitControl() {

        butExit = new JButton("Выход");

        panelControl = new JPanel();
        panelControl.add(butExit, BorderLayout.EAST);

        this.add(panelControl, BorderLayout.SOUTH);
    }

    public void InitListeners() {
        butExit.addActionListener(new ListenerExit());
    }
}
