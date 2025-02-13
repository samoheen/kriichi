package org.badpost.kriichi.hand

import org.badpost.kriichi.tile.TileChunk
import org.badpost.kriichi.tile.WinningTile

class Hand(
    val concealedTiles: TileChunk,
    val exposedTiles: TileChunk,
    val winningTile: WinningTile
) {

}
