package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;

public class LotControlAddPlayerFrame extends JPanel {
    public JButton butAddLot, butRemoveLot;

    public LotControlAddPlayerFrame(Player currentPlayer) {
        super();
        butAddLot = new JButton("Добавить предмет");
        butRemoveLot = new JButton("Удалить предмет");
        if (currentPlayer.getNickName() == null) {
            butAddLot.setEnabled(false);
            butRemoveLot.setEnabled(false);
        }
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(butAddLot);
        this.add(butRemoveLot);
    }
}
