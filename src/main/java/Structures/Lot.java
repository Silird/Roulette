package Structures;

/**
 * Структура лота в количестве @count
 */
public class Lot implements Comparable<Lot> {
    private String name;
    private int cost, count;

    public Lot (String n, int c, int cou) {
        name = n;
        cost = c;
        count = cou;
    }

    /**
     * Увеличить количесво данных лотов на @param cou
     */
    public void Increase(int cou) {
        count += cou;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    /**
     * Получить полную цену всех лотов
     * @return
     */
    public int getOverallCost() {
        return count*cost;
    }

    public int compareTo(Lot o) {
        return name.compareTo(o.getName());
    }

    public boolean equals(Lot o) {
        return name.equals(o.getName());
    }
}
