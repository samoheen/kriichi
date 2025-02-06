package org.samoheen.kriichi.tile

sealed class NumberedTile(
    open val number: Int,
    val suit: Suit,
    val red: Boolean = false
): Tile {
    fun validate() {
        require(number in MIN_NUMBER..MAX_NUMBER)
    }

    override fun isDora(indicator: Tile): Boolean {
        if (indicator !is NumberedTile) {
            return false
        }
        val isSameSuit = indicator.suit == suit
        val isShiftedNumber = indicator.number % MAX_NUMBER + 1 == number
        return isSameSuit && isShiftedNumber
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NumberedTile) return false

        if (number != other.number) return false
        if (suit != other.suit) return false
        if (red != other.red) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number
        result = 31 * result + suit.hashCode()
        result = 31 * result + red.hashCode()
        return result
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 9
    }
}
