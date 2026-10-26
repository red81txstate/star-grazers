package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        // Up, down, left, right.
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
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
                    // Capture an opponent, but not a friendly piece.
                    if (occupant.getColor() != getColor()) {
                        moves.add(destination);
                    }

                    // Either color blocks further movement.
                    break;
                }

                newRow += direction[0];
                newCol += direction[1];
            }
        }

        return moves;
    }
}