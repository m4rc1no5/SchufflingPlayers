package pl.marceen.shufflingplayers.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin Zaremba
 */
public class Fixture {
    private int number;
    private List<Pair> pairList;

    public Fixture(int number) {
        this.number = number;
        pairList = new ArrayList<>();
    }

    public void addPair(Pair pair) {
        pairList.add(pair);
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fixture{");
        sb.append("number=").append(number);
        sb.append(", pairList=").append(pairList);
        sb.append('}');
        return sb.toString();
    }
}
