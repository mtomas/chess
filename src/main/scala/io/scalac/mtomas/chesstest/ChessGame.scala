package io.scalac.mtomas.chesstest

object ChessGame extends App {

  override def main(args: Array[String]) = {



    //    val m = 3
    //    val n = 3
    //    val solutions = board.getConfigurations(List(Rook, Rook, King))
    //
    //    val m = 4
    //    val n = 4
    //    val solutions = board2.getConfigurations(List(Rook, Rook, Knight, Knight, Knight, Knight))

    val m = 7
    val n = 7

    val start = System.currentTimeMillis()
    val board = new Board(m, n)
    val solutions = board.getConfigurations(List(King, King, Queen, Queen, Bishop, Bishop, Knight))
    val end = System.currentTimeMillis()

    //print some board configurations
    solutions.take(10).foreach((pieces) => {
      Board.printBoard(board, pieces)
    })

    println("Total count of possible combinations: " + solutions.size)
    println("Total time counting solutions: " + (end - start) / 1000 + " seconds")

    // result is 3063828 for 7x7 with KKQQBBN configuration
  }
}