package pl.marceen.shufflingplayers.control;

import org.junit.Before;
import org.junit.Test;
import pl.marceen.shufflingplayers.entity.Fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marcin Zaremba
 */
public class FixturesBuilderTest {
    private FixturesBuilder sut;

    @Before
    public void setUp() {
        sut = new FixturesBuilder();
    }

    @Test
    public void build() throws Exception {
        //given
        List<String> players = new ArrayList<>(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson"));

        //when
        List<Fixture> fixtures = sut.build(players, 2);

        //then
        System.out.println(fixtures);
    }
}