package org.badpost.kriichi.tile

sealed class DragonTile(
    val type: DragonType
): Tile {
    override fun isDora(indicator: Tile): Boolean {
        if (indicator !is DragonTile) {
            return false
        }
        return when (indicator.type) {
            DragonType.WHITE -> type == DragonType.GREEN
            DragonType.GREEN -> type == DragonType.RED
            DragonType.RED -> type == DragonType.WHITE
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DragonTile) return false

        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}
