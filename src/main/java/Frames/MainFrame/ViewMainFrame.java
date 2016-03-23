package Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ViewMainFrame extends JPanel {
    public PlayersMainFrame playersStruct;

    public ViewMainFrame() {
        super();
        playersStruct = new PlayersMainFrame();

        this.add(playersStruct, BorderLayout.WEST);
    }
}
