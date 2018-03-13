package pl.marceen.shufflingplayers.control;

import pl.marceen.shufflingplayers.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcin Zaremba
 */
public class PlayerMapper {
    public static List<Player> map(List<String> players) {
        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
