package pl.marceen.shufflingplayers.entity;

/**
 * @author Marcin Zaremba
 */
public class Match {
    private int number;
    private Pair pair;

    public Match(int number, Pair pair) {
        this.number = number;
        this.pair = pair;
    }

    public Pair getPair() {
        return pair;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Match{");
        sb.append("number=").append(number);
        sb.append(", pair=").append(pair);
        sb.append('}');
        return sb.toString();
    }
}
