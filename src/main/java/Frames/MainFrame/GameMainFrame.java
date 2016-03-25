package Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JPanel {
    public JLabel labelGame;
    public JLabel labelFirstWinner, labelFirstNick;
    public JLabel labelSecondWinner, labelSecondNick;
    public JLabel labelThirdWinner, labelThirdNick;
    public JPanel panelFirst, panelSecond, panelThird;

    public GameMainFrame() {
        super();

        this.setMaximumSize(new Dimension(500, 500));
        this.setMinimumSize(new Dimension(500, 500));

        labelGame = new JLabel("Игра ожидает начала");

        labelFirstWinner = new JLabel("15%:    ");
        labelFirstNick = new JLabel("_____");
        panelFirst = new JPanel();
        panelFirst.setLayout(new BoxLayout(panelFirst, BoxLayout.X_AXIS));
        panelFirst.add(labelFirstWinner);
        panelFirst.add(labelFirstNick);

        labelSecondWinner = new JLabel("25%:    ");
        labelSecondNick = new JLabel("_____");
        panelSecond = new JPanel();
        panelSecond.setLayout(new BoxLayout(panelSecond, BoxLayout.X_AXIS));
        panelSecond.add(labelSecondWinner);
        panelSecond.add(labelSecondNick);

        labelThirdWinner = new JLabel("50%:    ");
        labelThirdNick = new JLabel("_____");
        panelThird = new JPanel();
        panelThird.setLayout(new BoxLayout(panelThird, BoxLayout.X_AXIS));
        panelThird.add(labelThirdWinner);
        panelThird.add(labelThirdNick);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelGame);
        this.add(panelFirst);
        this.add(panelSecond);
        this.add(panelThird);
    }
}
