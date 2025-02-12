package org.badpost.tile

sealed interface Tile {
    fun isDora(indicator: Tile): Boolean
}
