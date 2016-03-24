package Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ViewMainFrame extends JPanel {
    public PlayersMainFrame playersStruct;
    public GameMainFrame gameStruct;

    public ViewMainFrame() {
        super();
        playersStruct = new PlayersMainFrame();

        gameStruct = new GameMainFrame();

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(playersStruct);
        this.add(gameStruct);
    }
}
