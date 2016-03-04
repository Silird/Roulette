package Structures;

public class Lot implements Comparable<Lot> {
    private String name;
    private int cost;

    public Lot (String n, int c) {
        name = n;
        cost = c;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int compareTo(Lot o) {
        return name.compareTo(o.getName());
    }
    /*
    public boolean equals(Lot o) {
        return
    }
    */
}
