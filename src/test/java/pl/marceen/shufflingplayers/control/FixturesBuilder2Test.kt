package pl.marceen.shufflingplayers.control

import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * @author Marcin Zaremba
 */
class FixturesBuilder2Test {
    private var sut: FixturesBuilder2? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        sut = FixturesBuilder2()
    }

    @Test
    @Throws(Exception::class)
    fun build() {
        //given
        val players = ArrayList(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis", "jolo"))

        //when
        val fixtureList = sut!!.build(players)

        //then

    }
}