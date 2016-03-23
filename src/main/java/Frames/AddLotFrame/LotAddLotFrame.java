package Frames.AddLotFrame;

import javax.swing.*;
import java.awt.*;

public class LotAddLotFrame extends JPanel {
    public JLabel labelName, labelCost, labelCount;
    public JTextField textName, textCost, textCount;

    public LotAddLotFrame() {
        super();
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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(labelName);
        this.add(textName);
        this.add(labelCost);
        this.add(textCost);
        this.add(labelCount);
        this.add(textCount);
    }
}
