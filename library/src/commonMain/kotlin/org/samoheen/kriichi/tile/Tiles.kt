package org.samoheen.kriichi.tile

object Tiles {
    // Numbered
    class Man(override val number: Int): NumberedTile(number, Suit.MAN, false)
    class Pin(override val number: Int): NumberedTile(number, Suit.PIN, false)
    class Sou(override val number: Int): NumberedTile(number, Suit.SOU, false)
    // Red
    object RedFive {
        data object Man: NumberedTile(RED_DEFAULT_NUMBER, Suit.MAN, true)
        data object Pin: NumberedTile(RED_DEFAULT_NUMBER, Suit.PIN, true)
        data object Sou: NumberedTile(RED_DEFAULT_NUMBER, Suit.SOU, true)
    }
    // Dragons
    object Dragon {
        data object White: DragonTile(DragonType.WHITE)
        data object Green: DragonTile(DragonType.GREEN)
        data object Red: DragonTile(DragonType.RED)
    }
    // Winds
    object Wind {
        data object East: WindTile(WindType.EAST)
        data object South: WindTile(WindType.SOUTH)
        data object West: WindTile(WindType.WEST)
        data object North: WindTile(WindType.NORTH)
    }
}

fun Tile.isNumbered(): Boolean = this is NumberedTile

fun Tile.isSimple(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return number != NumberedTile.MIN_NUMBER && number != NumberedTile.MAX_NUMBER
}

fun Tile.isTerminal(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return number == NumberedTile.MIN_NUMBER || number == NumberedTile.MAX_NUMBER
}

fun Tile.isDragon() = this is DragonTile

fun Tile.isWind() = this is WindTile

fun Tile.isHonor() = isDragon() || isWind()

fun Tile.isNonSimple() = !isSimple()

fun Tile.isAkadora(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return red
}
