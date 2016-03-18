package Listeners.AddPlayerListeners;

import Frames.MyTable;
import Listeners.AddPlayerListeners.Functions.RefreshTable;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRemoveLot implements ActionListener {
    private JDialog owner;
    private MyTable tableLots;
    private DefaultTableModel modelLots;
    private Player currentPlayer;
    private JLabel labelRate;

    public ListenerRemoveLot(JDialog o, MyTable tL, DefaultTableModel mL, Player cP, JLabel lR) {
        owner = o;
        tableLots = tL;
        modelLots = mL;
        currentPlayer = cP;
        labelRate = lR;
    }

    private class NotSelectedLotException extends Exception {
        public NotSelectedLotException() {
            super("Не выбран мастер для удаления");
        }
    }

    private class DoubleSelectedLotException extends Exception {
        public DoubleSelectedLotException() {
            super("Выбрано несколько лотов");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (tableLots.getSelectedRowCount() == 0) {
                throw new NotSelectedLotException();
            }
            if (tableLots.getSelectedRowCount() > 1) {
                throw new DoubleSelectedLotException();
            }
            currentPlayer.RemoveLot(tableLots.getSelectedRow());
            new RefreshTable(modelLots, currentPlayer);
            labelRate.setText("Общая цена: " + String.valueOf(currentPlayer.getRate()));
        }
        catch (NotSelectedLotException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
        catch (DoubleSelectedLotException ex) {
            JOptionPane.showMessageDialog(owner, ex.getMessage());
        }
    }
}
