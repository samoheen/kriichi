package org.badpost.kriichi.scoring

import org.badpost.kriichi.scoring.doraHanCounter
import org.badpost.kriichi.tile.Tiles
import kotlin.test.Test
import kotlin.test.assertEquals

class DoraHanCounterTest {

    @Test
    fun `test akadora`() {
        assertEquals(1, doraHanCounter(Tiles.RedFive.Pin).count())
    }

    @Test
    fun `test single dora`() {
        assertEquals(
            0,
            doraHanCounter(Tiles.Pin(3)) {
                indicators = listOf(Tiles.Pin(3))
            }.count()
        )
        assertEquals(
            1,
            doraHanCounter(Tiles.Pin(3)) {
                indicators = listOf(Tiles.Pin(2))
            }.count()
        )
    }

    @Test
    fun `test multiple doras`() {
        assertEquals(
            3,
            doraHanCounter(Tiles.RedFive.Sou) {
                indicators = listOf(Tiles.Sou(4), Tiles.Sou(4))
            }.count()
        )
    }
}
