package Structures;

import java.util.Iterator;
import java.util.TreeSet;

public class Player implements Comparable<Player> {
    private String nickName;
    private TreeSet<Lot> lots;
    private int rate;

    public Player() {
        nickName = null;
        lots = new TreeSet<Lot>();
        rate = 0;
    }

    public void Register(String nick) {
        nickName = nick;
    }

    public void addLot(String name, int cost) {
        lots.add(new Lot(name, cost));
        rate += cost;
    }

    /**
     * Количество лотов в множестве
     * @return
     */
    public int NumberOfLots() {
        int i;
        Iterator<Lot> it = lots.iterator();
        i = 0;
        while (it.hasNext()) {
            i++;
            it.next();
        }
        return i;
    }

    public String[][] giveAllInfo() {
        if (NumberOfLots() == 0) {
            return null;
        }
        String tmp[][] = new String[NumberOfLots()][6];
        Iterator<Lot> it = lots.iterator();
        Lot tmpLot;
        int i = 0;
        while (it.hasNext()) {
            tmpLot = it.next();
            tmp[i][0] = tmpLot.getName();
            tmp[i][1] = String.valueOf(tmpLot.getCost());
            i++;
        }
        return tmp;
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
