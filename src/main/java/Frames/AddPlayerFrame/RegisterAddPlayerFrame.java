package Frames.AddPlayerFrame;

import Structures.Player;

import javax.swing.*;
import java.awt.*;

public class RegisterAddPlayerFrame extends JPanel {
    public JLabel labelRegStatus, labelReg;
    public JTextField textNickName;
    public JButton butRegister;

    public RegisterAddPlayerFrame(Player currentPlayer) {
        super();
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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelReg);
        this.add(labelRegStatus);
        this.add(textNickName);
        this.add(butRegister);
    }
}
