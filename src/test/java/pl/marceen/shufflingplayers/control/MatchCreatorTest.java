package pl.marceen.shufflingplayers.control;

import org.junit.Test;
import pl.marceen.shufflingplayers.entity.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marcin Zaremba
 */
public class MatchCreatorTest {

    @Test
    public void build() throws Exception {
        //given
        List<String> players = new ArrayList<>(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis", "jolo"));

        //when
        List<Match> matchList = MatchCreator.create(PlayerMapper.map(players));

        //then
        System.out.println(matchList);
    }
}