package io.scalac.mtomas.chesstest

import scala.collection.mutable

/**
 *
 * User: mtomas
 * Date: 28/05/14
 * Time: 02:01
 *
 *
 * Class representing chess board
 *
 */
class Board(val columns: Int, val rows: Int) {

  require(columns > 0 && rows > 0, "Board must have positive dimensions");

  def getConfigurations(pieces: List[ChessItem]): Set[BoardConfiguration] =  {

    if(pieces.isEmpty) {
      Set(Set())
    }
    else {
      for {
        configuration <- getConfigurations(pieces.tail)
        x <- 0 until columns
        y <- 0 until rows
        pivot = PieceFactory(pieces.head, (x, y))
        if isValidConfiguration(pivot, configuration)
      } yield (configuration + pivot)
    }
  }

  def isValidConfiguration(pivot: Piece, configuration: BoardConfiguration) =
    configuration forall {
      piece => !(piece takesPosition pivot.currentPosition) && !(pivot takesPosition piece.currentPosition)
  }
}

/**
 *
 * Companion object for printing of board configurations
 *
 */
object Board {

  def printBoard(board: Board, pieces: BoardConfiguration): Unit = {

    val hashMap = new mutable.HashMap[Position, Piece]

    pieces.foreach((piece) => {
      hashMap += (piece.currentPosition -> piece)
    })

    for(x <- 0 until board.columns) {
      for(y <- 0 until board.rows) {
        print (" " + hashMap.getOrElse((x,y), "x") + " ")
      }
      println("\n")
    }
    println("\n")
  }
}
