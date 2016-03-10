package Frames;

import Listeners.MainFrameListeners.ListenerAddPlayer;
import Listeners.MainFrameListeners.ListenerExit;
import Structures.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel panelControl, panelStatus, panelView, panelPlayers;
    private JButton butExit, butAddPlayer;
    private JLabel labelPlayers, labelActivePlayers, labelRemainPlayers;
    private JScrollPane scrollPlayers;
    private MyTable tablePlayers;
    private DefaultTableModel modelPlayers;
    private Game game;

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void Show() {
        InitGame();
        InitFrame();
        InitStatus(); //Сверху
        InitView(); //Посередине
        InitControl(); //Снизу
        InitListeners();

        setVisible(true);

        //new AddPlayerFrame(game, this);
    }

    private void InitGame() {
        game = new Game();
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
        labelActivePlayers = new JLabel("Игроков в игре: " + String.valueOf(game.getCountPlayers()) + "    ");
        labelRemainPlayers = new JLabel("Игроков для начала: " + String.valueOf(game.getMinPlayers()) + "    ");

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
        tablePlayers = new MyTable(modelPlayers);
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

        butAddPlayer = new JButton("Добавить игрока");
        butExit = new JButton("Выход");

        panelControl = new JPanel();
        panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.X_AXIS));
        panelControl.add(butAddPlayer);
        panelControl.add(butExit);

        this.add(panelControl, BorderLayout.SOUTH);
    }

    public void InitListeners() {
        butAddPlayer.addActionListener(new ListenerAddPlayer(game, this));
        butExit.addActionListener(new ListenerExit());
    }
}
