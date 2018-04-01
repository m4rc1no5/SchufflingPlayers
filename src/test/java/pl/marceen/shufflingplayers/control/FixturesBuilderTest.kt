package pl.marceen.shufflingplayers.control

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.util.*

/**
 * @author Marcin Zaremba
 */
@Ignore
class FixturesBuilderTest {
    private var sut: FixturesBuilder? = null

    @Before
    fun setUp() {
        sut = FixturesBuilder()
    }

    @Test
    @Throws(Exception::class)
    fun build() {
        //given
        val players = ArrayList(Arrays.asList("Bruce Lee", "Alan Wilder", "David Bowie", "Michale Jackson", "Bruce Willis", "jolo"))

        //when
        val fixtures = sut!!.build(players)

        //then
        println(fixtures)
    }
}