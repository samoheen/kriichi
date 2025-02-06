package org.samoheen.kriichi.tile

sealed class WindTile(
    val type: WindType
): Tile {

    override fun isDora(indicator: Tile): Boolean {
        if (indicator !is WindTile) {
            return false
        }
        return when (indicator.type) {
            WindType.EAST -> type == WindType.SOUTH
            WindType.SOUTH -> type == WindType.WEST
            WindType.WEST -> type == WindType.NORTH
            WindType.NORTH -> type == WindType.EAST
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WindTile) return false

        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}
