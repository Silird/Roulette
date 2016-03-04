package Structures;

import Structures.Exeptions.PlayerAlreadyExist;

import java.util.TreeSet;

public class Game {
    private TreeSet<Player> players;
    private int bank;
    final int minPlayers = 4;

    public Game() {
        players = new TreeSet<Player>();
        bank = 0;
    }

    public Player registerPlayer(String nickName) throws PlayerAlreadyExist {
        Player tmp = new Player(nickName);
        if (players.contains(tmp)) {
            throw new PlayerAlreadyExist();
        }
        return tmp;
    }

    public void addPlayer(Player p) {
        players.add(p);
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
