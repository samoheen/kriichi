package org.samoheen.kriichi.tile

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WindTileTest {

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.Wind.South.isDora(Tiles.Wind.East))
        assertTrue(Tiles.Wind.West.isDora(Tiles.Wind.South))
        assertTrue(Tiles.Wind.North.isDora(Tiles.Wind.West))
        assertTrue(Tiles.Wind.East.isDora(Tiles.Wind.North))
        // ~
        assertFalse(Tiles.Wind.East.isDora(Tiles.Pin(1)))
    }
}
