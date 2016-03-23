package Frames.MainFrame;

import Frames.MyTable;
import Listeners.MainFrameListeners.ListenerAddPlayer;
import Listeners.MainFrameListeners.ListenerExit;
import Listeners.MainFrameListeners.ListenerRemovePlayer;
import Structures.Game;

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
    public void InitListeners() {
        controlStruct.butAddPlayer.addActionListener(new ListenerAddPlayer(game, this, viewStruct.playersStruct,
                statusStruct));
        controlStruct.butExit.addActionListener(new ListenerExit());
        controlStruct.butRemovePlayer.addActionListener(new ListenerRemovePlayer(this, viewStruct.playersStruct, game,
                statusStruct));
    }
}
