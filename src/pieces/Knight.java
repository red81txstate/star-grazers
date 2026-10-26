package pieces;

import board.Board;
import utils.Color;
import utils.Position;
import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        int[][] offsets = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
        };

        for (int[] offset : offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];

            if (newRow < 0 || newRow >= 8 ||
                newCol < 0 || newCol >= 8) {
                continue;
            }

            Position destination = new Position(newRow, newCol);

            Piece occupant = board.getPiece(destination);

            if (occupant == null ||
                occupant.getColor() != getColor()) {
                moves.add(destination);
            }
        }

        return moves;
    }

    @Override
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wN" : "bN";
    }
}