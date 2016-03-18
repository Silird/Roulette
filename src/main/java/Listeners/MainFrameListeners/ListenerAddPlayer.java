package Listeners.MainFrameListeners;

import Frames.AddPlayerFrame;
import Listeners.MainFrameListeners.Funcions.RefreshPlayerTable;
import Structures.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Открытие формы для добавления игрока
 * Обновление таблицы и лэйблов
 */
public class ListenerAddPlayer implements ActionListener {
    private JFrame owner;
    private Game game;
    private DefaultTableModel modelPlayers;
    private JLabel labelActivePlayers, labelRemainPlayers;

    public ListenerAddPlayer(Game g, JFrame o, DefaultTableModel mP, JLabel lAP, JLabel lRP) {
        owner = o;
        game = g;
        modelPlayers = mP;
        labelActivePlayers = lAP;
        labelRemainPlayers = lRP;
    }

    public void actionPerformed(ActionEvent e) {
        new AddPlayerFrame(game, owner);
        new RefreshPlayerTable(modelPlayers, game);
        labelActivePlayers.setText("Игроков в игре: " + String.valueOf(game.getCountPlayers()) + "    ");
        int remainPlayers;
        if ((game.getMinPlayers() - game.getCountPlayers()) < 0) {
            remainPlayers = 0;
        }
        else {
            remainPlayers = game.getMinPlayers() - game.getCountPlayers();
        }
        labelRemainPlayers.setText("Игроков для начала: " + String.valueOf(remainPlayers) + "    ");
    }
}
