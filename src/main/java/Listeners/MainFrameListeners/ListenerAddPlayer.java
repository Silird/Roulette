package Listeners.MainFrameListeners;

import Frames.AddPlayerFrame.AddPlayerFrame;
import Frames.MainFrame.PlayersMainFrame;
import Frames.MainFrame.StatusMainFrame;
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
    private PlayersMainFrame playersStruct;
    private StatusMainFrame statusStruct;

    public ListenerAddPlayer(Game g, JFrame o, PlayersMainFrame pS, StatusMainFrame sS) {
        owner = o;
        game = g;
        playersStruct = pS;
        statusStruct = sS;
    }

    public void actionPerformed(ActionEvent e) {
        new AddPlayerFrame(game, owner);
        new RefreshPlayerTable(playersStruct.modelPlayers, game);
        statusStruct.labelActivePlayers.setText("Игроков в игре: " + String.valueOf(game.getCountPlayers()) + "    ");
        int remainPlayers;
        if ((game.getMinPlayers() - game.getCountPlayers()) < 0) {
            remainPlayers = 0;
        }
        else {
            remainPlayers = game.getMinPlayers() - game.getCountPlayers();
        }
        statusStruct.labelRemainPlayers.setText("Игроков для начала: " + String.valueOf(remainPlayers) + "    ");
    }
}
