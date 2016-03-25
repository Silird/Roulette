package Frames.MainFrame;

import Frames.MyTable;
import Listeners.MainFrameListeners.Funcions.RefreshPlayerTable;
import Listeners.MainFrameListeners.ListenerAddPlayer;
import Listeners.MainFrameListeners.ListenerExit;
import Listeners.MainFrameListeners.ListenerRemovePlayer;
import Listeners.MainFrameListeners.ListenerStartGame;
import Structures.Exeptions.PlayerAlreadyExist;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Главная форма
 */

public class MainFrame extends JFrame {
    private Game game;
    private ViewMainFrame viewStruct;
    private StatusMainFrame statusStruct;
    private ControlMainFrame controlStruct;

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

        TestPlayers();

        setVisible(true);
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

    /**
     * Панель статуса игры
     */
    private void InitStatus() {
        statusStruct = new StatusMainFrame(game);

        this.add(statusStruct, BorderLayout.NORTH);
    }

    /**
     * Инициализация панели для отображения информации по ходу игры
     * Делится на информацию по игрокам и на поле для провождения самой игры
     */
    private void InitView() {
        viewStruct = new ViewMainFrame();

        this.add(viewStruct, BorderLayout.CENTER);
    }

    /**
     * Инициализация кнопок
     */
    private void InitControl() {
        controlStruct = new ControlMainFrame();

        this.add(controlStruct, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void InitListeners() {
        controlStruct.butAddPlayer.addActionListener(new ListenerAddPlayer(game, this, viewStruct.playersStruct,
                statusStruct));
        controlStruct.butExit.addActionListener(new ListenerExit());
        controlStruct.butRemovePlayer.addActionListener(new ListenerRemovePlayer(this, viewStruct.playersStruct, game,
                statusStruct));
        controlStruct.butStartGame.addActionListener(new ListenerStartGame(this, game, viewStruct.gameStruct));
    }

    //Добавление тестируемых игроков
    private void TestPlayers() {
        try {
            Player tmpPlayer;

            tmpPlayer = new Player();
            tmpPlayer.Register("Player1", game.getAllNickNames());
            tmpPlayer.addLot("Lot11", 500, 3);
            tmpPlayer.addLot("Lot12", 300, 4);
            tmpPlayer.addLot("Lot13", 200, 7);
            tmpPlayer.addLot("Lot14", 250, 3);
            game.addPlayer(tmpPlayer);

            tmpPlayer = new Player();
            tmpPlayer.Register("Player2", game.getAllNickNames());
            tmpPlayer.addLot("Lot22", 400, 3);
            tmpPlayer.addLot("Lot23", 100, 8);
            game.addPlayer(tmpPlayer);

            tmpPlayer = new Player();
            tmpPlayer.Register("Player3", game.getAllNickNames());
            tmpPlayer.addLot("Lot31", 10000, 1);
            game.addPlayer(tmpPlayer);

            tmpPlayer = new Player();
            tmpPlayer.Register("Player4", game.getAllNickNames());
            tmpPlayer.addLot("Lot41", 100, 2);
            game.addPlayer(tmpPlayer);

            new RefreshPlayerTable(viewStruct.playersStruct.modelPlayers, game);
            statusStruct.labelActivePlayers.setText("Игроков в игре: " + String.valueOf(game.getCountPlayers()) + "    ");
            int remainPlayers;
            if ((game.getMinPlayers() - game.getCountPlayers()) < 0) {
                remainPlayers = 0;
            }
            else {
                remainPlayers = game.getMinPlayers() - game.getCountPlayers();
            }
            statusStruct.labelRemainPlayers.setText("Игроков для начала: " + String.valueOf(remainPlayers) + "    ");
            statusStruct.labelBank.setText("Общая сумма: " + String.valueOf(game.getBank()) + "    ");
        }
        catch (PlayerAlreadyExist ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
