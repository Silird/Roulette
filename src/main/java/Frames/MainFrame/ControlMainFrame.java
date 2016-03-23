package Frames.MainFrame;

import javax.swing.*;

public class ControlMainFrame extends JPanel {
    public JButton butExit, butAddPlayer, butRemovePlayer;

    public ControlMainFrame() {
        super();
        butAddPlayer = new JButton("Добавить игрока");
        butRemovePlayer = new JButton("Удалить игрока");
        butExit = new JButton("Выход");

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(butAddPlayer);
        this.add(butRemovePlayer);
        this.add(butExit);
    }
}
