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
 * // TODO: 2018-03-29 do dopracowania
 */
public class FixturesBuilder2Test {

    private FixturesBuilder2 sut;

    @Before
    public void setUp() {
        sut = new FixturesBuilder2();
    }

    @Test
    public void build() throws Exception {
        //given
        var players = new ArrayList<>(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis"));

        //when
        var fixtureList = sut.build(players);

        //then

    }
}