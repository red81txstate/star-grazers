
package game;
import java.util.ArrayList;
import pieces.Piece;
import utils.Position;

public class Move {

    private Piece movedPiece;
    private Piece capturedPiece;

    private Position from;
    private Position to;

    /**
     * Constructs a Move object representing a chess move.
     * @param movedPiece the piece that was moved.
     * @param capturedPiece the piece that was captured (null if none).
     * @param from the starting position of the move.
     * @param to the ending position of the move.
     */
    public Move(Piece movedPiece, Piece capturedPiece, Position from, Position to) {
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
        this.from = from;
        this.to = to;
    }
    
    public Piece getMovedPiece() {
        return movedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }
}
