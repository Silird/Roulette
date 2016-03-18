package Listeners.MainFrameListeners;

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
    private MyTable tablePlayers;
    private DefaultTableModel modelPlayers;
    private Game game;
    private JLabel labelActivePlayers, labelRemainPlayers;

    public ListenerRemovePlayer(JFrame o, MyTable tP, DefaultTableModel mP, Game g, JLabel lAP, JLabel lRP) {
        owner = o;
        tablePlayers = tP;
        modelPlayers = mP;
        game = g;
        labelActivePlayers = lAP;
        labelRemainPlayers = lRP;
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
            if (tablePlayers.getSelectedRowCount() == 0) {
                throw new NotSelectedPlayerException();
            }
            if (tablePlayers.getSelectedRowCount() > 1) {
                throw new DoubleSelectedPlayerException();
            }
            game.RemovePlayer(tablePlayers.getSelectedRow());
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
        catch (NotSelectedPlayerException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
        catch (DoubleSelectedPlayerException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
    }
}
