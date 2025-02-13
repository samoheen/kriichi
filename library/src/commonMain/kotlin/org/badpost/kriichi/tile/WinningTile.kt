package org.badpost.kriichi.tile

import org.badpost.kriichi.hand.WinningCall

class WinningTile(val tile: Tile, val winningCall: WinningCall) : Tile by tile
