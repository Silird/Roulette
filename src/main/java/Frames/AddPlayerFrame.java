package Frames;


import Structures.Game;
import Structures.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddPlayerFrame extends JDialog {
    private Game game;
    private Player currentPlayer;
    private JPanel registerPanel, lotPanel, lotControlPanel;
    private JLabel regStatus, registerNick, regLabel, lotsLabel;
    private JTextField nickNameF;
    private MyTable lotsTable;
    private DefaultTableModel lotsModel;
    private JScrollPane lotsScroll;
}
