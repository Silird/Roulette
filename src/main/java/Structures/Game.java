package Structures;

import Structures.Exeptions.PlayerAlreadyExist;

import java.util.Iterator;
import java.util.TreeSet;

public class Game {
    private TreeSet<Player> players;
    private int bank;
    final int minPlayers = 4;

    public Game() {
        players = new TreeSet<Player>();
        bank = 0;
    }

    /*public Player registerPlayer(String nickName) throws PlayerAlreadyExist {
        Player tmp = new Player();
        if (players.contains(tmp)) {
            throw new PlayerAlreadyExist();
        }
        return tmp;
    }*/

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

    public void addPlayer(Player p) {
        players.add(p);
        bank += p.getRate();
    }

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
