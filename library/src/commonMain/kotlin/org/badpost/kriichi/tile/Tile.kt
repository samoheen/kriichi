package org.badpost.kriichi.tile

sealed interface Tile {
    fun isDora(indicator: Tile): Boolean
}
