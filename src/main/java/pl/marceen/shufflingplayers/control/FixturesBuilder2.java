package pl.marceen.shufflingplayers.control;

import pl.marceen.shufflingplayers.entity.Fixture;
import pl.marceen.shufflingplayers.entity.Match;
import pl.marceen.shufflingplayers.entity.Pair;
import pl.marceen.shufflingplayers.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Marcin Zaremba
 */
public class FixturesBuilder2 {

    public List<Fixture> build(List<String> players) throws Exception {
        List<Fixture> fixtureList = new ArrayList<>();

        List<Player> playerList = PlayerMapper.map(players);
        List<Match> matchList = MatchCreator.create(playerList);

        for (int i = 0; i < playerList.size(); i++) {
            Fixture fixture = new Fixture(i);
            List<Player> tempPlayerList = new ArrayList<>();

            Iterator<Match> iterator = matchList.iterator();
            while (iterator.hasNext()) {
                Match match = iterator.next();
                Pair pair = match.getPair();
                Optional<Player> playerOptional = playerList.stream()
                        .filter(player -> player.getName().equals(pair.getHomePlayer().getName()) || player.getName().equals(pair.getAwayPlayer().getName()))
                        .filter(player -> tempPlayerList.stream().map(Player::getName).noneMatch(s -> s.equals(player.getName())))
                        .findFirst();

                if (playerOptional.isPresent()) {
                    fixture.addPair(pair);
                    iterator.remove();
                    tempPlayerList.add(pair.getHomePlayer());
                    tempPlayerList.add(pair.getAwayPlayer());
                }
            }

            fixtureList.add(fixture);
        }

        return fixtureList;
    }
}
