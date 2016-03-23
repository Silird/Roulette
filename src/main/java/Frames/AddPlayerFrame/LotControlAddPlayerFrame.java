package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;

public class LotControlAddPlayerFrame {
    public JPanel panelLotControl;
    public JButton butAddLot, butRemoveLot;

    public LotControlAddPlayerFrame(Player currentPlayer) {
        butAddLot = new JButton("Добавить предмет");
        butRemoveLot = new JButton("Удалить предмет");
        if (currentPlayer.getNickName() == null) {
            butAddLot.setEnabled(false);
            butRemoveLot.setEnabled(false);
        }
        panelLotControl = new JPanel();
        panelLotControl.setLayout(new BoxLayout(panelLotControl, BoxLayout.X_AXIS));
        panelLotControl.add(butAddLot);
        panelLotControl.add(butRemoveLot);
    }
}
