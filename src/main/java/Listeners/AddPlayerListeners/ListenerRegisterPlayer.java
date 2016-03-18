package Listeners.AddPlayerListeners;

import Structures.Exeptions.PlayerAlreadyExist;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRegisterPlayer implements ActionListener {
    private Player currentPlayer;
    private JTextField textNickName;
    private JDialog owner;
    private JLabel labelRegStatus, labelRegisterNick;
    private JButton butRegister, butAddLot, butRemoveLot, butAccept;
    private Game game;

    public ListenerRegisterPlayer(JDialog o, Player p, JTextField n, JLabel lR, JLabel lRN, JButton bR, JButton bAL,
                                  JButton bRL, JButton bA, Game g) {
        owner = o;
        currentPlayer = p;
        textNickName = n;
        labelRegStatus = lR;
        labelRegisterNick = lRN;
        butRegister = bR;
        butAddLot = bAL;
        butRemoveLot = bRL;
        butAccept = bA;
        game = g;
    }

    public void actionPerformed(ActionEvent e) {
        String nickName = textNickName.getText();
        if (nickName.equals("никнейм") || nickName.equals("")) {
            JOptionPane.showMessageDialog(owner, "Поле ввода никнейма не заполнено");
        }
        else {
            //currentPlayer = new Player(nickName);
            try {
                currentPlayer.Register(nickName, game.getAllNickNames());
                labelRegStatus.setText("Регистрация пройдена");
                labelRegisterNick.setText("Игрок: " + currentPlayer.getNickName());
                butRegister.setEnabled(false);
                butAddLot.setEnabled(true);
                butRemoveLot.setEnabled(true);
                butAccept.setEnabled(true);
            }
            catch (PlayerAlreadyExist ex) {
                JOptionPane.showMessageDialog(owner, ex.getMessage());
            }
        }
    }
}
