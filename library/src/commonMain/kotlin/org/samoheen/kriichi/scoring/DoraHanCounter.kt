package org.samoheen.kriichi.scoring

import org.samoheen.kriichi.tile.Tile
import org.samoheen.kriichi.tile.isAkadora

internal class DoraHanCounter(
    private val subject: Tile,
    private val indicators: List<Tile>
): HanCounter {

    override fun count(): Int {
        var result = 0
        // Added extra han for akadora
        if (subject.isAkadora()) {
            result += HAN_FOR_AKADORA
        }
        // Iteratively adding a han for each dora indicator pointing to the tile
        result += indicators
            .count { indicator -> subject.isDora(indicator) }
        return result
    }

    companion object {
        private const val HAN_FOR_AKADORA = 1
    }
}

class DoraHanCounterBuilder(private val subject: Tile) {

    var indicators: List<Tile> = emptyList()

    internal fun build(): DoraHanCounter =
        DoraHanCounter(subject, indicators)
}

fun doraHanCounter(
    subject: Tile,
    builder: DoraHanCounterBuilder.() -> Unit = {}
): HanCounter {
    return DoraHanCounterBuilder(subject)
        .apply(builder)
        .build()
}
