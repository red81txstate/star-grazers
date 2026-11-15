
package gui;

import board.Board;
import pieces.Piece;
import utils.Position;

import javax.swing.*;
import java.awt.*;

public class ChessBoardPanel extends JPanel {

    private Board board;
    private JLabel[][] squares = new JLabel[8][8];

    public ChessBoardPanel(Board board) {
        this.board = board;

        setLayout(new GridLayout(8, 8));

        Color light = new Color(240, 217, 181);
        Color dark = new Color(181, 136, 99);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                JLabel square = new JLabel("", SwingConstants.CENTER);

                square.setOpaque(true);
                square.setBackground((row + col) % 2 == 0 ? dark : light);

                square.setFont(new Font("SansSerif", Font.PLAIN, 65));

                squares[row][col] = square;
                add(square);
            }
        }

        refreshBoard();
    }

    public void refreshBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                // Reverse rows so White appears at the bottom
                Piece piece = board.getPiece(
                    new Position(7 - row, col)
                );

                if (piece == null) {
                    squares[row][col].setText("");
                } else {
                    squares[row][col].setText(
                        getUnicodePiece(piece.getSymbol())
                    );
                }
            }
        }
    }

    private String getUnicodePiece(String symbol) {
        switch (symbol) {
            case "wK": return "♔";
            case "wQ": return "♕";
            case "wR": return "♖";
            case "wB": return "♗";
            case "wN": return "♘";
            case "wp": return "♙";

            case "bK": return "♚";
            case "bQ": return "♛";
            case "bR": return "♜";
            case "bB": return "♝";
            case "bN": return "♞";
            case "bp": return "♟";

            default: return "";
        }
    }
}
