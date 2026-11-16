package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class Queen extends Piece {

    /**
     * Constructs a Queen piece with the specified color and position.
     * @param color the color of the Queen (WHITE or BLACK).
     * @param position the initial position of the Queen on the board.
     */
    public Queen(Color color, Position position) {
        super(color, position);
    }

    /**
     * Calculates the possible moves for the Queen on the given board.
     * @param board the current state of the chess board.
     * @return a list of valid positions the Queen can move to.
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
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
     * Returns the symbol representing the Queen piece.
     * @return "wQ" for white Queen, "bQ" for black Queen.
     */
    @Override
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wQ" : "bQ";
    }
}