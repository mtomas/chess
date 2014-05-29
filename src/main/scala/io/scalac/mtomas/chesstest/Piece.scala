package io.scalac.mtomas.chesstest

/**
 *
 * User: mtomas
 * Date: 29/05/14
 * Time: 00:53
 *
 * Classes representing set of pieces used in this chess problem.
 *
 */

abstract case class Piece(name: ChessItem, currentPosition: Position) {

  override def toString = name.toString

  def takesPosition(testedPosition: Position) = {

    val deltaX = (testedPosition._1 - currentPosition._1).abs
    val deltaY = (testedPosition._2 - currentPosition._2).abs

    testedPosition == currentPosition || checksPosition(deltaX, deltaY)
  }

  def checksPosition (position: Position): Boolean
}

final class King(currentPosition: Position) extends Piece('K', currentPosition) {

  override def checksPosition(step: Position) =
    step._1 <= 1 &&
    step._2 <= 1           // max 1 step every direction

}

final class Queen(currentPosition: Position) extends Piece('Q', currentPosition) {

  override def checksPosition(step: Position) =
    step._1 == 0 ||        // infinite steps on x axis
    step._2 == 0 ||        // infinite steps on y axis
    step._1 == step._2     // infinite steps on diagonal

}

final class Rook(currentPosition: Position) extends Piece('R', currentPosition) {

  override def checksPosition(step: Position) =
    step._1 == 0 ||        // infinite steps on x axis
    step._2 == 0           // infinite steps on y axis

}

final class Bishop(currentPosition: Position) extends Piece('B', currentPosition) {

  override def checksPosition(step: Position) =
    step._1 == step._2 // infinite steps on diagonal

}

final class Knight(currentPosition: Position) extends Piece('N', currentPosition) {

  override def checksPosition(step: Position) =
    (step._1 == 1 && step._2 == 2) || // L Step
    (step._1 == 2 && step._2 == 1)

}

object PieceFactory {

  def apply(name: ChessItem, position: Position) = {

    require(position._1 >= 0 && position._2 >= 0, "Position coordinates must be positive numbers, your input:" + position)

    name match {
      case King    => new King(position)
      case Queen   => new Queen(position)
      case Rook    => new Rook(position)
      case Bishop  => new Bishop(position)
      case Knight  => new Knight(position)
    }
  }

}


