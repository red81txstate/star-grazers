package board;

import pieces.*;
import utils.Color;
import utils.Position;

// Represents the 8x8 board, provides initialization, movement, and console display.

public class Board {
    private final Piece[][] squares;

    // Creates an empty board.
    public Board() {
        squares = new Piece[8][8];
    }

    // Places all pieces in their standard starting positions.
    public void initialize() {
        // Clear board
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                squares[r][c] = null;
            }
        }

        // White pieces (rank 1 and 2)
        squares[0][0] = new Rook(Color.WHITE, new Position(0, 0));
        squares[0][1] = new Knight(Color.WHITE, new Position(0, 1));
        squares[0][2] = new Bishop(Color.WHITE, new Position(0, 2));
        squares[0][3] = new Queen(Color.WHITE, new Position(0, 3));
        squares[0][4] = new King(Color.WHITE, new Position(0, 4));
        squares[0][5] = new Bishop(Color.WHITE, new Position(0, 5));
        squares[0][6] = new Knight(Color.WHITE, new Position(0, 6));
        squares[0][7] = new Rook(Color.WHITE, new Position(0, 7));
        for (int c = 0; c < 8; c++) {
            squares[1][c] = new Pawn(Color.WHITE, new Position(1, c));
        }

        // Black pieces (rank 7 and 8)
        squares[7][0] = new Rook(Color.BLACK, new Position(7, 0));
        squares[7][1] = new Knight(Color.BLACK, new Position(7, 1));
        squares[7][2] = new Bishop(Color.BLACK, new Position(7, 2));
        squares[7][3] = new Queen(Color.BLACK, new Position(7, 3));
        squares[7][4] = new King(Color.BLACK, new Position(7, 4));
        squares[7][5] = new Bishop(Color.BLACK, new Position(7, 5));
        squares[7][6] = new Knight(Color.BLACK, new Position(7, 6));
        squares[7][7] = new Rook(Color.BLACK, new Position(7, 7));
        for (int c = 0; c < 8; c++) {
            squares[6][c] = new Pawn(Color.BLACK, new Position(6, c));
        }
    }

    /** Returns the piece at the given position, or null if empty.
     *  @param pos the position to query. @return the piece, or null. */
    public Piece getPiece(Position pos) {
        if (!pos.isValid()) return null;
        return squares[pos.getRow()][pos.getCol()];
    }

    /** Moves a piece from one square to another. Does not validate legality
     *  beyond bounds; callers should check rules first.
     *  @param from source position. @param to   destination position. 
     *  @return true if the move was applied. */
    public boolean movePiece(Position from, Position to) {
        if (!from.isValid() || !to.isValid()) return false;
        Piece piece = squares[from.getRow()][from.getCol()];
        if (piece == null) return false;

        squares[to.getRow()][to.getCol()] = piece;
        squares[from.getRow()][from.getCol()] = null;
        piece.setPosition(to);
        return true;
    }

    /** Prints the board to the console in the required format with file labels
     *  on top and rank labels on the left. Empty squares are shown as "##". */
    public void display() {
        System.out.println();
        System.out.print("   ");
        for (char file = 'A'; file <= 'H'; file++) {
            System.out.print(file + "  ");
        }
        System.out.println();

        for (int rank = 7; rank >= 0; rank--) {
            System.out.print((rank + 1) + "  ");
            for (int file = 0; file < 8; file++) {
                Piece p = squares[rank][file];
                if (p == null) {
                    System.out.print("## ");
                } else {
                    System.out.print(p.getSymbol() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Placeholder for check detection. Returns false in Phase 1.
     *  @param color the color to test. @return false (not yet implemented). */
    public boolean isCheck(Color color) {
        return false;
    }

    /** Placeholder for checkmate detection. Returns false in Phase 1.
     *  @param color the color to test. @return false (not yet implemented). */
    public boolean isCheckmate(Color color) {
        return false;
    }
}