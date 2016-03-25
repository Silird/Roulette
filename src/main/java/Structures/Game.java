package Structures;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
import java.lang.Math;

/**
 * Класс всей игры
 * Содержит:
 * Список всех игроков, общую вложённую сумму
 */
public class Game {
    private TreeSet<Player> players;
    private int bank;
    final int minPlayers = 4;
    final Random random = new Random();


    public Game() {
        players = new TreeSet<Player>();
        bank = 0;
    }

    /**
     * Выдаёт массив из всех зарегестрированных ников
     */
    public String[] getAllNickNames() {
        String tmp[] = new String[players.size()];
        Iterator<Player> it = players.iterator();
        int i = 0;
        Player tmpPlayer;
        while (it.hasNext()) {
            tmpPlayer = it.next();
            tmp[i] = tmpPlayer.getNickName();
            i++;
        }
        return tmp;
    }

    /**
     * Выдаёт всю информацию, нужную для заполнения таблицы
     */
    public String[][] giveAllInfo() {
        if (players.size() == 0) {
            return null;
        }
        String tmp[][] = new String[players.size()][6];
        Iterator<Player> it = players.iterator();
        Player tmpPlayer;
        int i = 0;
        while (it.hasNext()) {
            tmpPlayer = it.next();
            tmp[i][0] = tmpPlayer.getNickName();
            tmp[i][1] = String.valueOf(tmpPlayer.getRate());
            tmp[i][2] = String.valueOf(getChance(tmpPlayer)) + "%";
            i++;
        }
        return tmp;
    }

    public double getChance(Player tmpPlayer) {
        double dRate, dChance, dBank;
        dRate = tmpPlayer.getRate();
        dBank = bank;
        dChance = dRate/dBank*100;
        return RoundResult(dChance, 1);
    }

    private double RoundResult(double d, int precise) {
        precise = (int) Math.pow(10, precise);
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;
    }

    public String[][] StartGame() {
        final int countToWin = 20;
        String strToWin[][] = new String[3][countToWin];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < countToWin; j++) {
                strToWin[i][j] = getRandomPlayer();
            }
        }
        return strToWin;
    }

    private String getRandomPlayer() {
        double win = RoundResult((random.nextDouble()*100), 1);
        Iterator<Player> it = players.iterator();
        Player tmpPlayer;
        while (win > 0) {
            tmpPlayer = it.next();
            win -= getChance(tmpPlayer);
            if (win < 0) {
                return tmpPlayer.getNickName();
            }
        }
        return null;
    }

    //Рандом - Random ranrom = new Random();
    //random.nextDouble;

    /**
     * Добавление нового игрока
     */
    public void addPlayer(Player p) {
        players.add(p);
        bank += p.getRate();
    }

    /**
     * Удалить игрока под данным номером
     * @param number - данный номер
     */
    public void RemovePlayer(int number) {
        if (players.size() < number) {
            return;
        }
        Iterator<Player> it = players.iterator();
        Player tmpPlayer;
        int i = 0;
        while (it.hasNext()) {
            tmpPlayer = it.next();
            if (i == number) {
                bank -= tmpPlayer.getRate();
                players.remove(tmpPlayer);
                return;
            }
            i++;
        }
    }

    /**
     * Проверка на готовность системы к игре
     */
    public boolean isReady() {
        if (players.size() > minPlayers) {
            return true;
        }
        return false;
    }

    public int getCountPlayers() {
        return players.size();
    }

    public int getBank() {
        return bank;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
}
