package Frames.MainFrame;

import javax.swing.*;

public class ControlMainFrame extends JPanel {
    public JButton butExit, butAddPlayer, butRemovePlayer, butStartGame;

    public ControlMainFrame() {
        super();
        butAddPlayer = new JButton("Добавить игрока");
        butRemovePlayer = new JButton("Удалить игрока");
        butStartGame = new JButton("Начать игру");
        butExit = new JButton("Выход");

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(butAddPlayer);
        this.add(butRemovePlayer);
        this.add(butStartGame);
        this.add(butExit);
    }
}
