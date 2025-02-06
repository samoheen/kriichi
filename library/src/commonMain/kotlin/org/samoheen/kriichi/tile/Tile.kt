package org.samoheen.kriichi.tile

sealed interface Tile {
    fun isDora(indicator: Tile): Boolean
}
