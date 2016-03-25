package Listeners.MainFrameListeners;

import Frames.MainFrame.GameMainFrame;
import Structures.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.Math;

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
        try {
            //TODO
            //Не прорисовывает изменения до окончания потока!!
            gameStruct.labelGame.setText("Игра началась!");
            //owner.revalidate();
            final Random random = new Random();
            String strWinners[][] = game.StartGame();

            for (int i = 0; i < 20; i++) {
                Thread.sleep((Math.round(Math.pow(1.4, i))));
                gameStruct.labelFirstNick.setText(strWinners[0][i]);
                if (i != 19) {
                    gameStruct.labelFirstNick.setForeground(getRandomColor(random.nextInt() % 4));
                }
                else {
                    gameStruct.labelFirstNick.setForeground(Color.GREEN);
                }
                //owner.repaint();
            }

            for (int i = 0; i < 20; i++) {
                Thread.sleep((Math.round(Math.pow(1.4, i))));
                gameStruct.labelSecondNick.setText(strWinners[1][i]);
                if (i != 19) {
                    gameStruct.labelSecondNick.setForeground(getRandomColor(random.nextInt() % 4));
                }
                else {
                    gameStruct.labelSecondNick.setForeground(Color.GREEN);
                }
                //owner.repaint();
            }

            for (int i = 0; i < 20; i++) {
                Thread.sleep((Math.round(Math.pow(1.4, i))));
                gameStruct.labelThirdNick.setText(strWinners[1][i]);
                if (i != 19) {
                    gameStruct.labelThirdNick.setForeground(getRandomColor(random.nextInt() % 4));
                }
                else {
                    gameStruct.labelThirdNick.setForeground(Color.GREEN);
                }
                //owner.repaint();
            }
        }

        catch (java.lang.InterruptedException ex) {
            ex.printStackTrace();
        }

        gameStruct.labelGame.setText("Игра ожидает начала");
        /*
        gameStruct.labelFirstNick.setText(strWinners[0][19]);
        gameStruct.labelSecondNick.setText(strWinners[1][19]);
        gameStruct.labelThirdNick.setText(strWinners[2][19]);
        */
    }

    private Color getRandomColor(int number) {
        switch (number) {
            case 0: {
                return Color.CYAN;
            }
            case 1: {
                return Color.ORANGE;
            }
            case 2: {
                return Color.YELLOW;
            }
            case 3: {
                return Color.PINK;
            }
        }
        return null;
    }
}
