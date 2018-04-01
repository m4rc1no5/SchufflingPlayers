package pl.marceen.shufflingplayers.control

import org.junit.Test
import java.util.*

/**
 * @author Marcin Zaremba
 */
class MatchCreatorTest {

    @Test
    @Throws(Exception::class)
    fun build() {
        //given
        val players = ArrayList(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis", "jolo"))

        //when
        val matchList = MatchCreator.create(PlayerMapper.map(players))

        //then
        println(matchList)
    }
}