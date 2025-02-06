package org.samoheen.kriichi.tile

object Tiles {
    // Numbered
    class Man(override val number: Int): NumberedTile(number, Suit.MAN, false)
    class Pin(override val number: Int): NumberedTile(number, Suit.PIN, false)
    class Sou(override val number: Int): NumberedTile(number, Suit.SOU, false)
    // Red
    data object RedMan: NumberedTile(RED_DEFAULT_NUMBER, Suit.MAN, true)
    data object RedPin: NumberedTile(RED_DEFAULT_NUMBER, Suit.PIN, true)
    data object RedSou: NumberedTile(RED_DEFAULT_NUMBER, Suit.SOU, true)
    // Dragons
    data object WhiteDragon: DragonTile(DragonType.WHITE)
    data object GreenDragon: DragonTile(DragonType.GREEN)
    data object RedDragon: DragonTile(DragonType.RED)
    // Winds
    data object EastWind: WindTile(WindType.EAST)
    data object SouthWind: WindTile(WindType.SOUTH)
    data object WestWind: WindTile(WindType.WEST)
    data object NorthWind: WindTile(WindType.NORTH)
}

/**
 * There are three numbered suits - Manzu, Pinzu, Souzu. Each suit has tiles numbered from 1-9.
 * The three numbered suits are mostly identical, but each tile group must be formed with one
 * suit (though a hand can have multiple suits). Number tiles can be used in sequences.
 */
fun Tile.isNumbered(): Boolean = this is NumberedTile

/**
 * Tiles numbered from 2-8 are classed as chunchanhai 「中張牌」, or "simples".
 */
fun Tile.isSimple(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return number != NumberedTile.MIN_NUMBER && number != NumberedTile.MAX_NUMBER
}

/**
 * Tiles numbered 1 or 9 are classed as routouhai 「老頭牌」, or "terminals".
 */
fun Tile.isTerminal(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return number == NumberedTile.MIN_NUMBER || number == NumberedTile.MAX_NUMBER
}

/**
 * The sangenpai 「三元牌」 (lit. three foundation tiles) are a group of three, often brightly
 * colored, tiles. In English, they are most often referred to as the dragons, but occasionally they
 * are referred to as the colours.
 */
fun Tile.isDragon() = this is DragonTile

/**
 * Kazehai 「風牌」 (lit. wind tiles) are four tiles representing winds in the four cardinal
 * directions. In English, they are most commonly called winds, but rarely called directions
 * instead.
 */
fun Tile.isWind() = this is WindTile

/**
 * Tiles that are not numbered, i.e. the wind and dragon tiles, are called jihai「字牌」, or honor
 * tiles.
 */
fun Tile.isHonor() = isDragon() || isWind()

/**
 * Yaochuuhai 「幺九牌」, or "non-simples", refers to both terminal and honor tiles. In other words,
 * if a tile is not numbered from 2-8, then it is a non-simple.
 */
fun Tile.isNonSimple() = !isSimple()


/**
 * Akadora 「赤ドラ」, akapai 「赤牌」, or red dora are tiles marked in red. Unlike dora indicators,
 * having the red tile itself in your hand counts as a dora.
 */
fun Tile.isAkadora(): Boolean {
    if (this !is NumberedTile) {
        return false
    }
    return red
}
