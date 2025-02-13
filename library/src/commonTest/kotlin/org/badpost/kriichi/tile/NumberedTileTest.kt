package org.badpost.kriichi.tile

import org.badpost.kriichi.tile.Tiles
import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumberedTileTest {

    @Test
    fun `test number bounds`() {
        assertFails { Tiles.Man(0).validate() }
        assertFails { Tiles.Pin(10).validate() }
        // ~
        Tiles.Sou(1).validate()
        Tiles.Man(9).validate()
    }

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.Man(2).isDora(Tiles.Man(1)))
        assertTrue(Tiles.Man(1).isDora(Tiles.Man(9)))
        // ~
        assertFalse(Tiles.Man(2).isDora(Tiles.Pin(1)))
        // ~
        assertTrue(Tiles.RedFive.Man.isDora(Tiles.Man(4)))
        assertTrue(Tiles.Man(6).isDora(Tiles.RedFive.Man))
    }
}
