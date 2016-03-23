package Listeners.AddPlayerListeners;

import Frames.AddPlayerFrame.LotAddPlayerFrame;
import Frames.MyTable;
import Listeners.AddPlayerListeners.Functions.RefreshLotTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Удаление выделенного лота
 */
public class ListenerRemoveLot implements ActionListener {
    private JDialog owner;
    private Player currentPlayer;
    private LotAddPlayerFrame lotStruct;

    public ListenerRemoveLot(JDialog o, Player cP, LotAddPlayerFrame lS) {
        owner = o;
        currentPlayer = cP;
        lotStruct = lS;
    }

    private class NotSelectedLotException extends Exception {
        public NotSelectedLotException() {
            super("Не выбран лот для удаления");
        }
    }

    private class DoubleSelectedLotException extends Exception {
        public DoubleSelectedLotException() {
            super("Выбрано несколько лотов");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (lotStruct.tableLots.getSelectedRowCount() == 0) {
                throw new NotSelectedLotException();
            }
            if (lotStruct.tableLots.getSelectedRowCount() > 1) {
                throw new DoubleSelectedLotException();
            }
            currentPlayer.RemoveLot(lotStruct.tableLots.getSelectedRow());
            new RefreshLotTable(lotStruct.modelLots, currentPlayer);
            lotStruct.labelRate.setText("Общая цена: " + String.valueOf(currentPlayer.getRate()));
        }
        catch (NotSelectedLotException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
        catch (DoubleSelectedLotException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
    }
}
