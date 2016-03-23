package Frames.AddPlayerFrame;


import Listeners.AddPlayerListeners.*;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Форма для добавления нового игрока
 */
public class AddPlayerFrame extends JDialog {
    private Game game;
    private Player currentPlayer;
    private RegisterAddPlayerFrame registerStruct;
    private ControlAddPlayerFrame controlStruct;
    private LotAddPlayerFrame lotStruct;

    public AddPlayerFrame(Game g, JFrame owner) {
        super(owner);
        game = g;
        currentPlayer = new Player();
        this.Show(owner);
    }

    /**
     * Отображение формы
     * @param owner
     */
    public void Show(JFrame owner) {
        FrameInit(owner);
        RegisterInit(); //Сверху
        LotInit(); //Посередине
        ControlInit(); //Внизу
        ListenersInit();

        setVisible(true);
    }

    /**
     * Инициализация формы
     * @param owner
     */
    private void FrameInit(JFrame owner) {
        setTitle("Регистрация игрока");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Инициализация панели регистрации
     */
    private void RegisterInit() {
        registerStruct = new RegisterAddPlayerFrame(currentPlayer);

        this.add(registerStruct.panelRegister, BorderLayout.NORTH);
    }

    /**
     * Инициализация панели лотов
     */
    private void LotInit() {
        lotStruct = new LotAddPlayerFrame(currentPlayer);

        this.add(lotStruct.panelLot, BorderLayout.CENTER);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        controlStruct = new ControlAddPlayerFrame(currentPlayer);

        this.add(controlStruct.panelControl, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {
        registerStruct.textNickName.addFocusListener(new ListenerFocusNickField(registerStruct.textNickName));
        registerStruct.butRegister.addActionListener(new ListenerRegisterPlayer(this, currentPlayer, registerStruct,
                lotStruct, controlStruct, game));
        controlStruct.butCancel.addActionListener(new ListenerPlayerCancel(this));
        lotStruct.lotControlStruct.butAddLot.addActionListener(new ListenerAddLot(this, currentPlayer, lotStruct));
        lotStruct.lotControlStruct.butRemoveLot.addActionListener(new ListenerRemoveLot(this, currentPlayer, lotStruct));
        controlStruct.butAccept.addActionListener(new ListenerPlayerAdd(this, game, currentPlayer));
    }
}
