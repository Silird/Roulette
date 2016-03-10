package Frames;


import Listeners.AddPlayerListeners.ListenerFocusNickField;
import Structures.Game;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddPlayerFrame extends JDialog {
    private boolean isReg;
    private Game game;
    private Player currentPlayer;
    private JPanel panelRegister, panelLot, panelLotControl, panelControl;
    private JLabel labelRegStatus, labelRegisterNick, labelReg, labelLots;
    private JTextField textNickName;
    private MyTable TableLots;
    private DefaultTableModel ModelLots;
    private JScrollPane scrollLots;
    private JButton butRegister, butAddLot, butRemoveLot, butCancel, butAccept;

    public AddPlayerFrame(Game g, JFrame owner) {
        super(owner);
        game = g;
        isReg = false;
        this.Show(owner);
    }

    /**
     * Отображение формы
     * @param owner
     */
    public void Show(JFrame owner) {
        FrameInit(owner);
        RegisterInit(); //Сверху
        LotInit(null); //Посередине
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
        labelRegStatus = new JLabel();
        if (isReg) {
            labelRegStatus.setText("Регистрация выполнена");
        }
        else {
            labelRegStatus.setText("Регистрация не пройдена");
        }
        textNickName = new JTextField("никнейм");
        textNickName.setForeground(Color.LIGHT_GRAY);
        textNickName.setMaximumSize(new Dimension(300, 100));
        butRegister = new JButton("Регистрация");
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
    private void LotInit(String nick) {
        labelLots = new JLabel("Выставленные предметы:");
        if (nick != null) {
            labelRegisterNick = new JLabel("Игрок: " + nick);
        }
        else {
            labelRegisterNick = new JLabel("Регистрация не пройдена");
        }

        String columns[] = {"Предмет", "Цена"};
        ModelLots = new DefaultTableModel(null, columns);
        TableLots = new MyTable(ModelLots);
        scrollLots = new JScrollPane();
        scrollLots.add(TableLots);
        butAddLot = new JButton("Добавить предмет");
        butRemoveLot = new JButton("Удалить предмет");
        panelLotControl = new JPanel();
        panelLotControl.setLayout(new BoxLayout(panelLotControl, BoxLayout.X_AXIS));
        panelLotControl.add(butAddLot);
        panelLotControl.add(butRemoveLot);
        //panelControl.setEnabled(false);
        panelLot = new JPanel();
        panelLot.setLayout(new BoxLayout(panelLot, BoxLayout.Y_AXIS));
        panelLot.add(labelLots);
        panelLot.add(labelRegisterNick);
        panelLot.add(scrollLots);
        panelLot.add(panelLotControl);
        this.add(panelLot, BorderLayout.CENTER);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        butAccept = new JButton("Добавить игрока");
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
    }
}
