package Frames.AddLotFrame;

import javax.swing.*;

public class ControlAddLotFrame extends JPanel {
    public JButton butAdd, butCancel;

    public ControlAddLotFrame() {
        super();
        butAdd = new JButton("Добавить");
        butCancel = new JButton("Отмена");
        this.add(butAdd);
        this.add(butCancel);
    }
}
