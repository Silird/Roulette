package Structures;

import Structures.Exeptions.PlayerAlreadyExist;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Класс всей игры
 * Содержит:
 * Список всех игроков, общую вложённую сумму
 */
public class Game {
    private TreeSet<Player> players;
    private int bank;
    final int minPlayers = 4;


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
        double dRate, dChance, dBank;
        String tmp[][] = new String[players.size()][6];
        Iterator<Player> it = players.iterator();
        Player tmpPlayer;
        int i = 0;
        while (it.hasNext()) {
            tmpPlayer = it.next();
            tmp[i][0] = tmpPlayer.getNickName();
            tmp[i][1] = String.valueOf(tmpPlayer.getRate());
            dRate = tmpPlayer.getRate();
            dBank = bank;
            dChance = dRate/dBank*100;
            tmp[i][2] = String.valueOf(dChance) + "%";
            i++;
        }
        return tmp;
    }

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
