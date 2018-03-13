package pl.marceen.shufflingplayers.control;

/**
 * @author Marcin Zaremba
 */
public class MatchCalculator {
    public static int calcuateNumberOfMatches(int numberOfPlayers) {
        double numberOfFixtures = (numberOfPlayers - 1) * ((double) numberOfPlayers / 2);
        return (int) numberOfFixtures;
    }
}
