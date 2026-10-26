package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color, Position position) {
        super(color, position);
    }

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

    @Override
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wp" : "bp";
    }
}