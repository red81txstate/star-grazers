package pieces;

import utils.Color;
import utils.Position;
import java.util.List;

import board.Board;

import java.util.ArrayList;

public class King extends Piece {

    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = getPosition().getRow();
        int col = getPosition().getCol();

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {

                // The King cannot move to its current square.
                if (rowOffset == 0 && colOffset == 0) {
                    continue;
                }

                int newRow = row + rowOffset;
                int newCol = col + colOffset;

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
        }

        return moves;
    }

    @Override 
    public String getSymbol() {
        return getColor() == Color.WHITE ? "wK" : "bK";
    }
}