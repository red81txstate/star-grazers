package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class Bishop extends Piece {

    /**
     * Constructs a Bishop piece with the specified color and position.
     * @param color the color of the Bishop (WHITE or BLACK).
     * @param position the initial position of the Bishop on the board.
     */
    public Bishop(Color color, Position position) {
        super(color, position);
    }

    /**
     * Calculates the possible moves for the Bishop on the given board.
     * @param board the current state of the chess board.
     * @return a list of valid positions the Bishop can move to.
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        // Four diagonal directions.
        int[][] directions = {
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            while (newRow >= 0 && newRow < 8 &&
                newCol >= 0 && newCol < 8) {

                Position destination = new Position(newRow, newCol);
                Piece occupant = board.getPiece(destination);

                if (occupant == null) {
                    moves.add(destination);
                } else {
                    if (occupant.getColor() != getColor()) {
                        moves.add(destination);
                    }

                    break;
                }

                newRow += direction[0];
                newCol += direction[1];
            }
        }

        return moves;
    }
    /**
     * Returns the symbol representing the Bishop piece.
     * @return "wB" for white Bishop, "bB" for black Bishop.
     */
    @Override 
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wB" : "bB";
    }
}