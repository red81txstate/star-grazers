package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class Pawn extends Piece {

    /**
     * Constructs a Pawn piece with the specified color and position.
     * @param color the color of the Pawn (WHITE or BLACK).
     * @param position the initial position of the Pawn on the board.
     */
    public Pawn(Color color, Position position) {
        super(color, position);
    }

    /**
     * Calculates the possible moves for the Pawn on the given board.
     * @param board the current state of the chess board.
     * @return a list of valid positions the Pawn can move to.
     */
    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        int direction;
        int startingRow;

        if (getColor() == Color.WHITE) {
            direction = -1;
            startingRow = 6;
        } else {
            direction = 1;
            startingRow = 1;
        }

        // Check one square forward.
        int newRow = row + direction;

        if (newRow >= 0 && newRow < 8) {
            Position forward = new Position(newRow, col);

            if (board.getPiece(forward) == null) {
                moves.add(forward);

                // Check two squares forward from starting row.
                if (row == startingRow) {
                    int twoRows = row + 2 * direction;
                    Position twoForward = new Position(twoRows, col);

                    if (board.getPiece(twoForward) == null) {
                        moves.add(twoForward);
                    }
                }
            }

            // Check diagonal captures.
            for (int colOffset : new int[]{-1, 1}) {
                int newCol = col + colOffset;

                if (newCol < 0 || newCol >= 8) {
                    continue;
                }

                Position diagonal = new Position(newRow, newCol);
                Piece occupant = board.getPiece(diagonal);

                if (occupant != null &&
                    occupant.getColor() != getColor()) {
                    moves.add(diagonal);
                }
            }
        }

        return moves;
    }

    /**
     * Returns the symbol representing the Pawn piece.
     * @return "wp" for white Pawn, "bp" for black Pawn.
     */
    @Override
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wp" : "bp";
    }
}