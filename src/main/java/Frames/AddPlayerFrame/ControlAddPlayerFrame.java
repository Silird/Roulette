package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;

public class ControlAddPlayerFrame {
    public JPanel panelControl;
    public JButton butCancel, butAccept;

    public ControlAddPlayerFrame(Player currentPlayer) {
        butAccept = new JButton("Добавить игрока");
        if (currentPlayer.getNickName() == null) {
            butAccept.setEnabled(false);
        }
        butCancel = new JButton("Отмена");
        panelControl = new JPanel();
        panelControl.add(butAccept);
        panelControl.add(butCancel);
    }
}
