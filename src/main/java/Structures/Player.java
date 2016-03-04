package Structures;

import java.util.TreeSet;

public class Player implements Comparable<Player> {
    private String nickName;
    private TreeSet<Lot> lots;
    private int rate;

    public Player(String nick) {
        nickName = nick;
        lots = new TreeSet<Lot>();
        rate = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getCountLots() {
        return lots.size();
    }

    public int compareTo(Player o) {
        return nickName.compareTo(o.getNickName());
    }

    public boolean equals(Player o) {
        return nickName.equals(o.getNickName());
    }
}
