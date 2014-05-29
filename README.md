Chess assignment
=====



The problem is to find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where
none of the pieces is in a position to take any of the others.
Assume the colour of the piece does not matter, and that there are no pawns among the pieces.

Write a program which takes as input:
•      The dimensions of the board: M, N.
•      The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on the board.
As output, the program should list all the unique configurations to the console for which all of the pieces can be placed on the board without threatening each other.

To get an answer of the total number of unique configurations for a 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight:

Build and run program by running following command in terminal:

    $ sbt run
In order to change size of the board or set of input pieces you need to edit variables in file [ChessGame](https://github.com/mtomas/chess/blob/master/src/main/scala/io/scalac/mtomas/chesstest/ChessGame.scala#L17)

Result for 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight is 3 063 828 valid configurations.


