package Frames.AddLotFrame;

import javax.swing.*;
import java.awt.*;

public class LotAddLotFrame {
    public JPanel panelLot;
    public JLabel labelName, labelCost, labelCount;
    public JTextField textName, textCost, textCount;

    public LotAddLotFrame() {
        labelName = new JLabel("Название:");
        textName = new JTextField();
        textName.setMaximumSize(new Dimension(300, 100));
        labelCost = new JLabel("Цена:");
        textCost = new JTextField();
        textCost.setMaximumSize(new Dimension(200, 100));
        labelCount = new JLabel("Количество предметов:");
        textCount = new JTextField("1");
        textCount.setForeground(Color.LIGHT_GRAY);
        textCount.setMaximumSize(new Dimension(200, 100));
        panelLot = new JPanel();
        panelLot.setLayout(new BoxLayout(panelLot, BoxLayout.Y_AXIS));
        panelLot.add(labelName);
        panelLot.add(textName);
        panelLot.add(labelCost);
        panelLot.add(textCost);
        panelLot.add(labelCount);
        panelLot.add(textCount);
    }
}
