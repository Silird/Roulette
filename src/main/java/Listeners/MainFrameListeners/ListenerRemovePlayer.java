package Listeners.MainFrameListeners;

import Frames.MainFrame.PlayersMainFrame;
import Frames.MainFrame.StatusMainFrame;
import Frames.MyTable;
import Listeners.MainFrameListeners.Funcions.RefreshPlayerTable;
import Structures.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Удаление выделенного игрока
 */
public class ListenerRemovePlayer implements ActionListener {
    private JFrame owner;
    private PlayersMainFrame playersStruct;
    private Game game;
    private StatusMainFrame statusStruct;

    public ListenerRemovePlayer(JFrame o, PlayersMainFrame pS, Game g, StatusMainFrame sS) {
        owner = o;
        playersStruct = pS;
        game = g;
        statusStruct = sS;
    }

    private class NotSelectedPlayerException extends Exception {
        public NotSelectedPlayerException() {
            super("Не выбран игрок для удаления");
        }
    }

    private class DoubleSelectedPlayerException extends Exception {
        public DoubleSelectedPlayerException() {
            super("Выбрано несколько игроков");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (playersStruct.tablePlayers.getSelectedRowCount() == 0) {
                throw new NotSelectedPlayerException();
            }
            if (playersStruct.tablePlayers.getSelectedRowCount() > 1) {
                throw new DoubleSelectedPlayerException();
            }
            game.RemovePlayer(playersStruct.tablePlayers.getSelectedRow());
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
        catch (NotSelectedPlayerException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
        catch (DoubleSelectedPlayerException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
    }
}
