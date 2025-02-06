package org.samoheen.kriichi.tile

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WindTileTest {

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.SouthWind.isDora(Tiles.EastWind))
        assertTrue(Tiles.WestWind.isDora(Tiles.SouthWind))
        assertTrue(Tiles.NorthWind.isDora(Tiles.WestWind))
        assertTrue(Tiles.EastWind.isDora(Tiles.NorthWind))
        // ~
        assertFalse(Tiles.EastWind.isDora(Tiles.Pin(1)))
    }
}
