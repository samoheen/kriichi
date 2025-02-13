package org.badpost.kriichi.tile

sealed interface TileChunk {

    val tiles: List<Tile>

    operator fun plus(element: TileChunk): TileChunk {
        return Pool(this, element)
    }

    class Single(val tile: Tile) : TileChunk {
        override val tiles: List<Tile> = listOf(tile)
    }

    class Pair(first: Tile, second: Tile) : TileChunk {
        override val tiles: List<Tile> = listOf(first, second)
    }

    class Sequence(
        first: Tile,
        second: Tile,
        third: Tile,
        override val isOpen: Boolean = false
    ) : TileChunk, Openable {
        override val tiles: List<Tile> = listOf(first, second, third)
    }

    class Triplet(
        first: Tile,
        second: Tile,
        third: Tile,
        override val isOpen: Boolean = false
    ) : TileChunk, Openable {
        override val tiles: List<Tile> = listOf(first, second, third)
    }

    class Quad(
        first: Tile,
        second: Tile,
        third: Tile,
        forth: Tile,
        override val isOpen: Boolean = false
    ) : TileChunk, Openable {
        override val tiles: List<Tile> = listOf(first, second, third, forth)
    }

    class Pool(vararg items: TileChunk) : TileChunk {

        override val tiles: List<Tile> = items.flatMap { it.tiles }

        val chunks: List<TileChunk> = items.flatMap {
            if (it is Pool) {
                it.chunks
            } else {
                listOf(it)
            }
        }
    }
}
