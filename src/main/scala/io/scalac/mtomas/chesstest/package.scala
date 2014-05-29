package io.scalac.mtomas

/**
 *
 * User: mtomas
 * Date: 28/05/14
 * Time: 01:55
 *
 */
package object chesstest {

  type Position = (Int, Int)
  type BoardConfiguration = Set[Piece]
  type ChessItem = Char

  val King:   ChessItem = 'K'
  val Bishop: ChessItem = 'B'
  val Rook:   ChessItem = 'R'
  val Knight: ChessItem = 'N'
  val Queen:  ChessItem = 'Q'

}
