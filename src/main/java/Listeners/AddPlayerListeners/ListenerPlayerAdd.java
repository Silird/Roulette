package Listeners.AddPlayerListeners;

import Structures.Game;
import Structures.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Добавление нового игрока
 * Закрытие формы
 */
public class ListenerPlayerAdd implements ActionListener {
    private JDialog owner;
    private Game game;
    private Player player;

    public ListenerPlayerAdd(JDialog o, Game g, Player p) {
        owner = o;
        game = g;
        player = p;
    }

    public void actionPerformed(ActionEvent e) {
        game.addPlayer(player);
        owner.setVisible(false);
    }
}
