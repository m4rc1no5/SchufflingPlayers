package pl.marceen.shufflingplayers.control;

import pl.marceen.shufflingplayers.entity.Fixture;
import pl.marceen.shufflingplayers.entity.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcin Zaremba
 */
public class FixturesBuilder {
    public List<Fixture> build(List<String> players, int numberOfRounds) throws Exception {
        List<Fixture> fixtures = new ArrayList<>();

        int numberOfMatchesInRound = players.size() - 1;
        int numberOfFixtures = numberOfMatchesInRound * numberOfRounds;

        List<Player> playerList = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        Comparator<Player> comparator = (o1, o2) -> {
            int o1GamesPlayed = o1.getHomeFixtures().size() + o1.getAwayFixtures().size();
            int o2GamesPlayed = o2.getHomeFixtures().size() + o2.getAwayFixtures().size();

            if (o1GamesPlayed == o2GamesPlayed) {
                return 0;
            }

            return o1GamesPlayed > o2GamesPlayed ? 1 : -1;
        };

        for (int i = 0; i < numberOfFixtures; i++) {
            Player homePlayer = playerList.stream()
                    .min(comparator.thenComparing(Comparator.comparingInt(o -> o.getHomeFixtures().size())))
                    .orElseThrow(() -> new Exception("Cant find home player"));

            Player awayPlayer = playerList.stream()
                    .filter(player -> !player.equals(homePlayer))
                    .min(comparator.thenComparing(Comparator.comparingInt(o -> o.getHomeFixtures().size())))
                    .orElseThrow(() -> new Exception("Cant find away player"));

            Fixture fixture = new Fixture(i, homePlayer, awayPlayer);
            fixtures.add(fixture);
            homePlayer.addHomeFixture(fixture);
            awayPlayer.addAwayFixture(fixture);
        }

        return fixtures;
    }
}
