package Listeners.MainFrameListeners;

import Frames.AddPlayerFrame;
import Structures.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAddPlayer implements ActionListener {
    private JFrame owner;
    private Game game;

    public ListenerAddPlayer(Game g, JFrame o) {
        owner = o;
        game = g;
    }
    public void actionPerformed(ActionEvent e) {
        new AddPlayerFrame(game, owner);
    }
}
