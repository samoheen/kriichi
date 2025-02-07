package org.samoheen.kriichi.tile

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DragonTileTest {

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.Dragon.Green.isDora(Tiles.Dragon.White))
        assertTrue(Tiles.Dragon.Red.isDora(Tiles.Dragon.Green))
        assertTrue(Tiles.Dragon.White.isDora(Tiles.Dragon.White))
        // ~
        assertFalse(Tiles.Dragon.White.isDora(Tiles.Pin(1)))
    }
}
