package Frames;

import Listeners.AddLotListeners.ListenerLotAdd;
import Listeners.AddPlayerListeners.ListenerPlayerCancel;
import Structures.Player;

import javax.swing.*;
import java.awt.*;

public class AddLotFrame extends JDialog {
    private Player currentPlayer;
    private JPanel panelLot, panelControl;
    private JLabel labelName, labelCost;
    private JTextField textName, textCost;
    private JButton butAdd, butCancel;

    public AddLotFrame(Player cP, JDialog owner) {
        super(owner);
        //isReg = false;
        currentPlayer = cP;
        this.Show(owner);
    }

    /**
     * Отображение формы
     *
     * @param owner
     */
    public void Show(JDialog owner) {
        FrameInit(owner);
        LotInit(); //Сверху
        ControlInit(); //Внизу
        ListenersInit();

        setVisible(true);
    }

    /**
     * Инициализация формы
     *
     * @param owner
     */
    private void FrameInit(JDialog owner) {
        setTitle("Добавление лота");
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Инициализация панели лота
     */
    private void LotInit() {
        labelName = new JLabel("Название:");
        textName = new JTextField();
        textName.setMaximumSize(new Dimension(300, 100));
        labelCost = new JLabel("Цена:");
        textCost = new JTextField();
        textCost.setMaximumSize(new Dimension(200, 100));
        panelLot = new JPanel();
        panelLot.setLayout(new BoxLayout(panelLot, BoxLayout.Y_AXIS));
        panelLot.add(labelName);
        panelLot.add(textName);
        panelLot.add(labelCost);
        panelLot.add(textCost);
        this.add(panelLot, BorderLayout.NORTH);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        butAdd = new JButton("Добавить");
        butCancel = new JButton("Отмена");
        panelControl = new JPanel();
        panelControl.add(butAdd);
        panelControl.add(butCancel);
        this.add(panelControl, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {
        butCancel.addActionListener(new ListenerPlayerCancel(this));
        butAdd.addActionListener(new ListenerLotAdd(this, textName, textCost, currentPlayer));
    }
}
