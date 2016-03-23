package Frames.AddLotFrame;

import Listeners.AddLotListeners.ListenerFocusCountField;
import Listeners.AddLotListeners.ListenerLotAdd;
import Listeners.AddLotListeners.ListenerLotCancel;
import Listeners.AddPlayerListeners.ListenerPlayerCancel;
import Structures.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Форма для добавлеия нового лота
 */
public class AddLotFrame extends JDialog {
    private Player currentPlayer;
    private LotAddLotFrame lotStruct;
    private ControlAddLotFrame controlStruct;

    public AddLotFrame(Player cP, JDialog owner) {
        super(owner);
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
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Инициализация панели лота
     */
    private void LotInit() {
        lotStruct = new LotAddLotFrame();
        this.add(lotStruct.panelLot, BorderLayout.NORTH);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        controlStruct = new ControlAddLotFrame();

        this.add(controlStruct.panelControl, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {
        controlStruct.butCancel.addActionListener(new ListenerLotCancel(this));
        controlStruct.butAdd.addActionListener(new ListenerLotAdd(this, lotStruct, currentPlayer));
        lotStruct.textCount.addFocusListener(new ListenerFocusCountField(lotStruct.textCount));
    }
}
