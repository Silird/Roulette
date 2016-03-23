package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;
import java.awt.*;

public class RegisterAddPlayerFrame {
    public JPanel panelRegister;
    public JLabel labelRegStatus, labelReg;
    public JTextField textNickName;
    public JButton butRegister;

    public RegisterAddPlayerFrame(Player currentPlayer) {
        labelReg = new JLabel("Регистрация:");
        if (currentPlayer.getNickName() != null) {
            labelRegStatus = new JLabel("Регистрация выполнена");
            textNickName = new JTextField(currentPlayer.getNickName());
        }
        else {
            labelRegStatus = new JLabel("Регистрация не пройдена");
            textNickName = new JTextField("никнейм");
        }
        textNickName.setForeground(Color.LIGHT_GRAY);
        textNickName.setMaximumSize(new Dimension(300, 100));
        butRegister = new JButton("Регистрация");
        if (currentPlayer.getNickName() != null) {
            butRegister.setEnabled(false);
        }
        panelRegister = new JPanel();
        panelRegister.setLayout(new BoxLayout(panelRegister, BoxLayout.Y_AXIS));
        panelRegister.add(labelReg);
        panelRegister.add(labelRegStatus);
        panelRegister.add(textNickName);
        panelRegister.add(butRegister);
    }
}
