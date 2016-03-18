package Listeners.AddPlayerListeners.Functions;

import Structures.Player;

import javax.swing.table.DefaultTableModel;

/**
 * Функция для обновления таблицы лотов
 */
public class RefreshLotTable {
    public RefreshLotTable(DefaultTableModel modelLots, Player currentPlayer) {
        int rows = modelLots.getRowCount();
        for (int i = 0; i < rows; i++) {
            modelLots.removeRow(0);
        }
        String tmp[][] = currentPlayer.giveAllInfo();
        if (tmp == null) {
            return;
        }
        for (int i = 0; i < tmp.length; i++) {
            modelLots.addRow(tmp[i]);
        }
    }
}
