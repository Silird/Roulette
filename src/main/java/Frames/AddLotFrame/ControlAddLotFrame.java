package Frames.AddLotFrame;

import javax.swing.*;

public class ControlAddLotFrame {
    public JPanel panelControl;
    public JButton butAdd, butCancel;

    public ControlAddLotFrame() {
        butAdd = new JButton("Добавить");
        butCancel = new JButton("Отмена");
        panelControl = new JPanel();
        panelControl.add(butAdd);
        panelControl.add(butCancel);
    }
}
