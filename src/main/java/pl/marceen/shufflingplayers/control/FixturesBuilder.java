package pl.marceen.shufflingplayers.control;

import pl.marceen.shufflingplayers.entity.Fixture;
import pl.marceen.shufflingplayers.entity.Pair;
import pl.marceen.shufflingplayers.entity.Player;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Marcin Zaremba
 * // TODO: 2018-03-12 do wywalenia
 */
public class FixturesBuilder {
    public List<Fixture> build(List<String> players) throws Exception {
        List<Fixture> fixtures = new ArrayList<>();

        int numberOfFixturesInRound = players.size();
        int maxMatchesPerPlayer = players.size() - 1;
        int matchesInFixture = players.size() / 2;

        List<Player> playerList = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());

//        List<Player> playerListReversed = playerList.stream()
//                .collect(Collectors.toList());

        ArrayDeque<Player> playerListReversed = playerList.stream().collect(Collector.of(ArrayDeque::new, ArrayDeque::addFirst, (d1, d2) -> { d2.addAll(d1); return d2; }));

        Comparator<Player> comparator = (o1, o2) -> {
            int o1GamesPlayed = o1.getHomeFixtures().size() + o1.getAwayFixtures().size();
            int o2GamesPlayed = o2.getHomeFixtures().size() + o2.getAwayFixtures().size();

            if (o1GamesPlayed == o2GamesPlayed) {
                return 0;
            }

            return o1GamesPlayed > o2GamesPlayed ? 1 : -1;
        };

        for (int i = 0; i < numberOfFixturesInRound; i++) {
            Fixture fixture = new Fixture(i);
            List<Player> playersInFixture = new ArrayList<>();

            for (int j = 0; j < matchesInFixture; j++) {

                Stream<Player> playerStream = playerList.stream();
                if ((j + 1) % 2 == 0) {
                    playerStream = playerListReversed.stream();
                }

                Player homePlayer = playerStream
                        .filter(player -> playersInFixture.stream().map(Player::getName).noneMatch(name -> name.equals(player.getName())))
                        .min(comparator.thenComparingInt(player -> player.getHomeFixtures().size()))
                        .orElseThrow(() -> new Exception("Cant find home player"));

                Stream<Player> awayPlayerStream = playerList.stream();
                if ((i + 1) % 2 == 0) {
                    awayPlayerStream = playerListReversed.stream();
                }

                Player awayPlayer = awayPlayerStream
                        .filter(player -> playersInFixture.stream().map(Player::getName).noneMatch(name -> name.equals(player.getName())))
                        .filter(player -> !player.getName().equals(homePlayer.getName()))
                        .filter(player -> player.getAwayOpponentList().stream().map(Player::getName).noneMatch(name -> name.equals(homePlayer.getName())))
                        .filter(player -> player.getHomeOpponentList().stream().map(Player::getName).noneMatch(name -> name.equals(homePlayer.getName())))
                        .min(comparator.thenComparingInt(player -> player.getAwayFixtures().size()))
                        .orElseThrow(() -> new Exception("Cant find away player"));

                // TODO: 2018-03-10 refaktor
                if ((homePlayer.getHomeFixtures().size() + homePlayer.getAwayFixtures().size()) == maxMatchesPerPlayer ||
                                (awayPlayer.getHomeFixtures().size() + awayPlayer.getAwayFixtures().size()) == maxMatchesPerPlayer) {
                    continue;
                }

                Pair pair = new Pair(homePlayer, awayPlayer);
                fixture.addPair(pair);
                homePlayer.addHomeFixture(fixture);
                homePlayer.addHomeOpponent(awayPlayer);
                awayPlayer.addAwayFixture(fixture);
                awayPlayer.addAwayOpponent(homePlayer);

                playersInFixture.add(homePlayer);
                playersInFixture.add(awayPlayer);
            }
            fixtures.add(fixture);

//            p = playerList.stream().collect(Collector.of(ArrayDeque::new, ArrayDeque::addFirst, (d1, d2) -> { d2.addAll(d1); return d2; }));

            System.out.println(fixtures);
        }

        return fixtures;
    }

    public static <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }
}
