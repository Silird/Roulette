package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;

public class ControlAddPlayerFrame extends JPanel {
    public JButton butCancel, butAccept;

    public ControlAddPlayerFrame(Player currentPlayer) {
        super();
        butAccept = new JButton("Добавить игрока");
        if (currentPlayer.getNickName() == null) {
            butAccept.setEnabled(false);
        }
        butCancel = new JButton("Отмена");
        this.add(butAccept);
        this.add(butCancel);
    }
}
