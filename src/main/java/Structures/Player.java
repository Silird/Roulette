package Structures;

import Structures.Exeptions.PlayerAlreadyExist;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Структура игрока
 * Содержит:
 * Никнейм, все поставленные лоты, суммарный вклад в игру
 */
public class Player implements Comparable<Player> {
    private String nickName;
    private TreeSet<Lot> lots;
    private int rate;

    public Player() {
        nickName = null;
        lots = new TreeSet<Lot>();
        rate = 0;
    }

    /**
     * Регистрация игрока
     * @param registeredPlayers списко уже зарегестрированных игроков
     * @throws PlayerAlreadyExist Если игрок уже зарегестрирован
     */
    public void Register(String nick, String[] registeredPlayers) throws PlayerAlreadyExist {
        for (int i = 0; i < registeredPlayers.length; i++) {
            if (registeredPlayers[i].equals(nick)) {
                throw new PlayerAlreadyExist();
            }
        }
        nickName = nick;
    }

    /**
     * Добавление лота
     */
    public void addLot(String name, int cost, int count) {
        Iterator<Lot> it = lots.iterator();
        Lot tmpLot, SampleLot;
        SampleLot = new Lot(name, cost, count);
        while (it.hasNext()) {
            tmpLot = it.next();
            if (tmpLot.equals(SampleLot)) {
                tmpLot.Increase(SampleLot.getCount());
                rate += tmpLot.getCost()*count;
                return;
            }
        }
        lots.add(SampleLot);
        rate += cost*count;
    }

    /**
     * Получение всей информации для заполнения таблицы
     */
    public String[][] giveAllInfo() {
        if (lots.size() == 0) {
            return null;
        }
        String tmp[][] = new String[lots.size()][6];
        Iterator<Lot> it = lots.iterator();
        Lot tmpLot;
        int i = 0;
        while (it.hasNext()) {
            tmpLot = it.next();
            tmp[i][0] = tmpLot.getName();
            tmp[i][1] = String.valueOf(tmpLot.getCost());
            tmp[i][2] = String.valueOf(tmpLot.getCount());
            i++;
        }
        return tmp;
    }

    public void RemoveLot(int number) {
        if (lots.size() < number) {
            return;
        }
        Iterator<Lot> it = lots.iterator();
        Lot tmpLot;
        int i = 0;
        while (it.hasNext()) {
            tmpLot = it.next();
            if (i == number) {
                rate -= tmpLot.getOverallCost();
                lots.remove(tmpLot);
                return;
            }
            i++;
        }
    }

    public String getNickName() {
        return nickName;
    }

    public int getCountLots() {
        return lots.size();
    }

    public int getRate() {
        return rate;
    }

    public int compareTo(Player o) {
        return nickName.compareTo(o.getNickName());
    }

    public boolean equals(Player o) {
        return nickName.equals(o.getNickName());
    }
}
