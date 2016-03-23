package Frames.AddPlayerFrame;


import Frames.MyTable;
import Listeners.AddPlayerListeners.*;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Форма для добавления нового игрока
 */
public class AddPlayerFrame extends JDialog {
    private Game game;
    private Player currentPlayer;
    private JPanel panelRegister, panelLot, panelLotControl, panelControl;
    private JLabel labelRegStatus, labelRegisterNick, labelReg, labelRate, labelLots;
    private JTextField textNickName;
    private MyTable tableLots;
    private DefaultTableModel modelLots;
    private JScrollPane scrollLots;
    private JButton butRegister, butAddLot, butRemoveLot, butCancel, butAccept;

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

        this.add(panelRegister, BorderLayout.NORTH);
    }

    /**
     * Инициализация панели лотов
     */
    private void LotInit() {
        labelLots = new JLabel("Выставленные предметы:");
        if (currentPlayer.getNickName() != null) {
            labelRegisterNick = new JLabel("Игрок: " + currentPlayer.getNickName());
        }
        else {
            labelRegisterNick = new JLabel("Регистрация не пройдена");
        }
        labelRate = new JLabel("Общая цена: " + String.valueOf(currentPlayer.getRate()));
        String columns[] = {"Предмет", "Цена", "Количество"};
        modelLots = new DefaultTableModel(null, columns);
        tableLots = new MyTable(modelLots);
        scrollLots = new JScrollPane(tableLots);
        butAddLot = new JButton("Добавить предмет");
        butRemoveLot = new JButton("Удалить предмет");
        if (currentPlayer.getNickName() == null) {
            butAddLot.setEnabled(false);
            butRemoveLot.setEnabled(false);
        }
        panelLotControl = new JPanel();
        panelLotControl.setLayout(new BoxLayout(panelLotControl, BoxLayout.X_AXIS));
        panelLotControl.add(butAddLot);
        panelLotControl.add(butRemoveLot);
        panelLot = new JPanel();
        panelLot.setLayout(new BoxLayout(panelLot, BoxLayout.Y_AXIS));
        panelLot.add(labelLots);
        panelLot.add(labelRegisterNick);
        panelLot.add(labelRate);
        panelLot.add(scrollLots);
        panelLot.add(panelLotControl);
        this.add(panelLot, BorderLayout.CENTER);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        butAccept = new JButton("Добавить игрока");
        if (currentPlayer.getNickName() == null) {
            butAccept.setEnabled(false);
        }
        butCancel = new JButton("Отмена");
        panelControl = new JPanel();
        panelControl.add(butAccept);
        panelControl.add(butCancel);
        this.add(panelControl, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {
        textNickName.addFocusListener(new ListenerFocusNickField(textNickName));
        butRegister.addActionListener(new ListenerRegisterPlayer(this, currentPlayer, textNickName, labelRegStatus, labelRegisterNick,
                butRegister, butAddLot, butRemoveLot, butAccept, game));
        butCancel.addActionListener(new ListenerPlayerCancel(this));
        butAddLot.addActionListener(new ListenerAddLot(this, currentPlayer, modelLots, labelRate));
        butRemoveLot.addActionListener(new ListenerRemoveLot(this, tableLots, modelLots, currentPlayer, labelRate));
        butAccept.addActionListener(new ListenerPlayerAdd(this, game, currentPlayer));
    }
}
