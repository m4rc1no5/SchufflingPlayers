package pl.marceen.shufflingplayers.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Marcin Zaremba
 */
public class Player {
    private String name;
    private List<Fixture> homeFixtures;
    private List<Fixture> awayFixtures;

    public Player(String name) {
        this.name = name;
        homeFixtures = new ArrayList<>();
        awayFixtures = new ArrayList<>();
    }

    public void addHomeFixture(Fixture fixture) {
        homeFixtures.add(fixture);
    }

    public void addAwayFixture(Fixture fixture) {
        awayFixtures.add(fixture);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(homeFixtures, player.homeFixtures) &&
                Objects.equals(awayFixtures, player.awayFixtures);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, homeFixtures, awayFixtures);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", homeFixtures=").append(homeFixtures.size());
        sb.append(", awayFixtures=").append(awayFixtures.size());
        sb.append('}');
        return sb.toString();
    }
}
