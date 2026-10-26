package pieces;

import board.Board;
import utils.Color;
import utils.Position;
import java.util.List;

/**
 * Represents an abstract chess piece.
 */
public abstract class Piece {

    private Color color;
    private Position position;

    /**
     * Constructs a chess piece.
     *
     * @param color the color of the piece
     * @param position the starting position of the piece
     */
    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Returns the color of the piece.
     *
     * @return the piece's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the current position of the piece.
     *
     * @return the piece's position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Moves the piece to a new position.
     *
     * @param newPosition the destination position
     */
    public void move(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Returns the possible moves for this piece.
     *
     * @return a list of possible positions
     */
    public abstract List<Position> possibleMoves(Board board);

    public abstract String getSymbol();
}