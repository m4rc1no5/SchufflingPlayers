package pl.marceen.shufflingplayers.entity;

/**
 * @author Marcin Zaremba
 */
public class Fixture {
    private int number;
    private Player homePlayer;
    private Player awayPlayer;

    public Fixture(int number, Player homePlayer, Player awayPlayer) {
        this.number = number;
        this.homePlayer = homePlayer;
        this.awayPlayer = awayPlayer;
    }

    public int getNumber() {
        return number;
    }

    public Fixture setNumber(int number) {
        this.number = number;
        return this;
    }

    public Player getHomePlayer() {
        return homePlayer;
    }

    public Fixture setHomePlayer(Player homePlayer) {
        this.homePlayer = homePlayer;
        return this;
    }

    public Player getAwayPlayer() {
        return awayPlayer;
    }

    public Fixture setAwayPlayer(Player awayPlayer) {
        this.awayPlayer = awayPlayer;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fixtures{");
        sb.append("number=").append(number);
        sb.append(", homePlayer=").append(homePlayer);
        sb.append(", awayPlayer=").append(awayPlayer);
        sb.append('}');
        return sb.toString();
    }
}
