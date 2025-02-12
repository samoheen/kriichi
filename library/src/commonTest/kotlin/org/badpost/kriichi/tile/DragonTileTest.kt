package org.badpost.kriichi.tile

import org.badpost.tile.Tiles
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DragonTileTest {

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.Dragon.Green.isDora(Tiles.Dragon.White))
        assertTrue(Tiles.Dragon.Red.isDora(Tiles.Dragon.Green))
        assertTrue(Tiles.Dragon.White.isDora(Tiles.Dragon.Red))
        // ~
        assertFalse(Tiles.Dragon.White.isDora(Tiles.Pin(1)))
    }
}
