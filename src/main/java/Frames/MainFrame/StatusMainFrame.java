package Frames.MainFrame;

import Structures.Game;

import javax.swing.*;

public class StatusMainFrame extends JPanel {
    public JLabel labelActivePlayers, labelRemainPlayers, labelBank;

    public StatusMainFrame(Game game) {
        super();
        labelActivePlayers = new JLabel("Игроков в игре: " + String.valueOf(game.getCountPlayers()) + "    ");
        labelRemainPlayers = new JLabel("Игроков для начала: " + String.valueOf(game.getMinPlayers()) + "    ");
        labelBank = new JLabel("Общая сумма: " + String.valueOf(game.getBank()) + "    ");

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(labelActivePlayers);
        this.add(labelRemainPlayers);
        this.add(labelBank);
    }
}
