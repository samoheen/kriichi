package org.samoheen.kriichi.tile

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DragonTileTest {

    @Test
    fun `test dora indicator`() {
        assertTrue(Tiles.GreenDragon.isDora(Tiles.WhiteDragon))
        assertTrue(Tiles.RedDragon.isDora(Tiles.GreenDragon))
        assertTrue(Tiles.WhiteDragon.isDora(Tiles.RedDragon))
        // ~
        assertFalse(Tiles.WhiteDragon.isDora(Tiles.Pin(1)))
    }
}
