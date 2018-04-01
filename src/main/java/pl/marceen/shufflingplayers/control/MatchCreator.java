package pl.marceen.shufflingplayers.control;

import pl.marceen.shufflingplayers.entity.Match;
import pl.marceen.shufflingplayers.entity.Pair;
import pl.marceen.shufflingplayers.entity.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Marcin Zaremba
 */
class MatchCreator {
    static List<Match> create(List<Player> playerList) throws Exception {
        List<Match> matches = new ArrayList<>();

        Comparator<Player> numberOfMatchesComparator = MatchCreator::compareNumberOfMatches;

        for (int i = 0; i < MatchCalculator.calcuateNumberOfMatches(playerList.size()); i++) {
            Player homePlayer = playerList.stream()
                    .min(numberOfMatchesComparator.thenComparingInt(player -> player.getHomeOpponentList().size()))
                    .orElseThrow(() -> new Exception("Cant find home player"));

            Player awayPlayer = playerList.stream()
                    .filter(player -> !player.getName().equals(homePlayer.getName()))
                    .filter(player -> player.getAwayOpponentList().stream().map(Player::getName).noneMatch(name -> name.equals(homePlayer.getName())))
                    .filter(player -> player.getHomeOpponentList().stream().map(Player::getName).noneMatch(name -> name.equals(homePlayer.getName())))
                    .min(numberOfMatchesComparator.thenComparingInt(player -> player.getAwayOpponentList().size()))
                    .orElseThrow(() -> new Exception("Cant find away player"));

            Match match = new Match(i, new Pair(homePlayer, awayPlayer));

            homePlayer.addHomeOpponent(awayPlayer);
            awayPlayer.addAwayOpponent(homePlayer);

            matches.add(match);
        }

        return matches;
    }

    private static int compareNumberOfMatches(Player o1, Player o2) {
        if (o1.numberOfMatches() == o2.numberOfMatches()) {
            return 0;
        }

        return o1.numberOfMatches() > o2.numberOfMatches() ? 1 : -1;
    }
}
