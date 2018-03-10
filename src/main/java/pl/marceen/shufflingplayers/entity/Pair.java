package pl.marceen.shufflingplayers.entity;

/**
 * @author Marcin Zaremba
 */
public class Pair {
    private Player homePlayer;
    private Player awayPlayer;

    public Pair(Player homePlayer, Player awayPlayer) {
        this.homePlayer = homePlayer;
        this.awayPlayer = awayPlayer;
    }

    public Player getHomePlayer() {
        return homePlayer;
    }

    public Player getAwayPlayer() {
        return awayPlayer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("homePlayer=").append(homePlayer);
        sb.append(", awayPlayer=").append(awayPlayer);
        sb.append('}');
        return sb.toString();
    }
}
