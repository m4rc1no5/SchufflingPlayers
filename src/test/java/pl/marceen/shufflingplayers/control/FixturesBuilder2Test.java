package pl.marceen.shufflingplayers.control;

import org.junit.Before;
import org.junit.Test;
import pl.marceen.shufflingplayers.entity.Fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Marcin Zaremba
 */
public class FixturesBuilder2Test {
    private FixturesBuilder2 sut;


    @Before
    public void setUp() throws Exception {
        sut = new FixturesBuilder2();
    }

    @Test
    public void build() throws Exception {
        //given
        List<String> players = new ArrayList<>(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis", "jolo"));

        //when
        List<Fixture> fixtureList = sut.build(players);

        //then

    }
}