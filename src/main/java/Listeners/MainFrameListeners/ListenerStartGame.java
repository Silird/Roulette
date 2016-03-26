package Listeners.MainFrameListeners;

import Frames.MainFrame.GameMainFrame;
import Structures.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerStartGame implements ActionListener {
    private JFrame owner;
    private Game game;
    private GameMainFrame gameStruct;

    public ListenerStartGame(JFrame o, Game g, GameMainFrame gS) {
        owner = o;
        game = g;
        gameStruct = gS;
    }

    public void actionPerformed(ActionEvent e) {
        String strWinners[][] = game.StartGame();

        gameStruct.labelFirstNick.setText(strWinners[0][19]);
        gameStruct.labelSecondNick.setText(strWinners[1][19]);
        gameStruct.labelThirdNick.setText(strWinners[2][19]);
        gameStruct.labelGame.setText("Игра окончена, ожидает начала");
    }
}
