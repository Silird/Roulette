package Frames;


import Structures.Game;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddPlayerFrame extends JDialog {
    private boolean isReg;
    private Game game;
    private Player currentPlayer;
    private JPanel registerPanel, lotPanel, lotControlPanel, controlPanel;
    private JLabel regStatus, registerNick, regLabel, lotsLabel;
    private JTextField nickNameF;
    private MyTable lotsTable;
    private DefaultTableModel lotsModel;
    private JScrollPane lotsScroll;
    private JButton registerBut, addLotBut, removeLotBut, cancelBut, acceptBut;

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
        regLabel = new JLabel("Регистрация:");
        regStatus = new JLabel();
        if (isReg) {
            regStatus.setText("Регистрация выполнена");
        }
        else {
            regStatus.setText("Регистрация не пройдена");
        }
        nickNameF = new JTextField("никнейм");
        nickNameF.setForeground(Color.LIGHT_GRAY);
        nickNameF.setMaximumSize(new Dimension(300, 100));
        registerBut = new JButton("Регистрация");
        registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.add(regLabel);
        registerPanel.add(regStatus);
        registerPanel.add(nickNameF);
        registerPanel.add(registerBut);

        this.add(registerPanel, BorderLayout.NORTH);
    }

    /**
     * Инициализация панели лотов
     */
    private void LotInit(String nick) {
        lotsLabel = new JLabel("Выставленные предметы:");
        if (nick != null) {
            registerNick = new JLabel("Игрок: " + nick);
        }
        else {
            registerNick = new JLabel("Регистрация не пройдена");
        }

        String columns[] = {"Предмет", "Цена"};
        lotsModel = new DefaultTableModel(null, columns);
        lotsTable = new MyTable(lotsModel);
        lotsScroll = new JScrollPane();
        lotsScroll.add(lotsTable);
        addLotBut = new JButton("Добавить предмет");
        removeLotBut = new JButton("Удалить предмет");
        lotControlPanel = new JPanel();
        lotControlPanel.setLayout(new BoxLayout(lotControlPanel, BoxLayout.X_AXIS));
        lotControlPanel.add(addLotBut);
        lotControlPanel.add(removeLotBut);
        lotPanel = new JPanel();
        lotPanel.setLayout(new BoxLayout(lotPanel, BoxLayout.Y_AXIS));
        lotPanel.add(lotsLabel);
        lotPanel.add(registerNick);
        lotPanel.add(lotsScroll);
        lotPanel.add(lotControlPanel);
        this.add(lotPanel, BorderLayout.CENTER);
    }

    /**
     * Инициализация Кнопок
     */
    private void ControlInit() {
        acceptBut = new JButton("Добавить игрока");
        cancelBut = new JButton("Отмена");
        controlPanel = new JPanel();
        controlPanel.add(acceptBut);
        controlPanel.add(cancelBut);
        this.add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * Инициализация слушателей
     */
    private void ListenersInit() {

    }
}
