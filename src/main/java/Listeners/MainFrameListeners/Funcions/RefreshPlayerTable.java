package Listeners.MainFrameListeners.Funcions;

import Structures.Game;

import javax.swing.table.DefaultTableModel;

/**
 * Функция для обновления таблицы игроков
 */
public class RefreshPlayerTable {
    public RefreshPlayerTable(DefaultTableModel modelPlayers, Game game) {
        int rows = modelPlayers.getRowCount();
        for (int i = 0; i < rows; i++) {
            modelPlayers.removeRow(0);
        }
        String tmp[][] = game.giveAllInfo();
        if (tmp == null) {
            return;
        }
        for (int i = 0; i < tmp.length; i++) {
            modelPlayers.addRow(tmp[i]);
        }
    }
}
