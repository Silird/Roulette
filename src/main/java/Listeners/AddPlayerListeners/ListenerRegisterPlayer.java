package Listeners.AddPlayerListeners;

import Frames.AddPlayerFrame.ControlAddPlayerFrame;
import Frames.AddPlayerFrame.LotAddPlayerFrame;
import Frames.AddPlayerFrame.RegisterAddPlayerFrame;
import Structures.Exeptions.PlayerAlreadyExist;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Регистрация игрока
 */
public class ListenerRegisterPlayer implements ActionListener {
    private Player currentPlayer;
    private JDialog owner;
    private RegisterAddPlayerFrame registerStruct;
    private LotAddPlayerFrame lotStruct;
    private Game game;
    private ControlAddPlayerFrame controlStruct;

    public ListenerRegisterPlayer(JDialog o, Player p, RegisterAddPlayerFrame rS, LotAddPlayerFrame lS,
                                  ControlAddPlayerFrame cS, Game g) {
        owner = o;
        currentPlayer = p;
        registerStruct = rS;
        lotStruct = lS;
        controlStruct = cS;
        game = g;
    }

    public void actionPerformed(ActionEvent e) {
        String nickName = registerStruct.textNickName.getText();
        if (nickName.equals("никнейм") || nickName.equals("")) {
            JOptionPane.showMessageDialog(owner, "Поле ввода никнейма не заполнено");
        }
        else {
            try {
                currentPlayer.Register(nickName, game.getAllNickNames());
                registerStruct.labelRegStatus.setText("Регистрация пройдена");
                lotStruct.labelRegisterNick.setText("Игрок: " + currentPlayer.getNickName());
                registerStruct.butRegister.setEnabled(false);
                lotStruct.lotControlStruct.butAddLot.setEnabled(true);
                lotStruct.lotControlStruct.butRemoveLot.setEnabled(true);
                controlStruct.butAccept.setEnabled(true);
            }
            catch (PlayerAlreadyExist ex) {
                JOptionPane.showMessageDialog(owner, ex.getMessage());
            }
        }
    }
}
