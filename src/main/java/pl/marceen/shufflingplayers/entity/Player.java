package pl.marceen.shufflingplayers.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin Zaremba
 */
public class Player {
    private String name;
    private List<Fixture> homeFixtures;
    private List<Fixture> awayFixtures;
    private List<Player> homeOpponentList;
    private List<Player> awayOpponentList;

    public Player(String name) {
        this.name = name;
        homeFixtures = new ArrayList<>();
        awayFixtures = new ArrayList<>();
        homeOpponentList = new ArrayList<>();
        awayOpponentList = new ArrayList<>();
    }

    public int numberOfMatches() {
        return homeOpponentList.size() + awayOpponentList.size();
    }

    public void addHomeFixture(Fixture fixture) {
        homeFixtures.add(fixture);
    }

    public void addAwayFixture(Fixture fixture) {
        awayFixtures.add(fixture);
    }

    public void addHomeOpponent(Player player) {
        homeOpponentList.add(player);
    }

    public void addAwayOpponent(Player player) {
        awayOpponentList.add(player);
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public List<Fixture> getHomeFixtures() {
        return homeFixtures;
    }

    public List<Fixture> getAwayFixtures() {
        return awayFixtures;
    }

    public List<Player> getHomeOpponentList() {
        return homeOpponentList;
    }

    public List<Player> getAwayOpponentList() {
        return awayOpponentList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", homeFixtures=").append(homeFixtures.size());
        sb.append(", awayFixtures=").append(awayFixtures.size());
        sb.append(", homeOpponentList=").append(homeOpponentList.size());
        sb.append(", awayOpponentList=").append(awayOpponentList.size());
        sb.append('}');
        return sb.toString();
    }
}
