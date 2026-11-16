
package gui;

import board.Board;
import pieces.Piece;
import utils.Position;

import javax.swing.*;
import java.awt.*;

public class ChessBoardPanel extends JPanel {

    private Board board;
    private JLabel[][] squares = new JLabel[8][8];
    private int selectedRow = -1;
    private int selectedCol = -1;
    private Color light = new Color(240, 217, 181);
    private Color dark = new Color(181, 136, 99);
    private Color highlight = new Color(255, 255, 100);
    private boolean gameOver = false;
    private Color whitePieceColor = Color.WHITE;
    private Color blackPieceColor = Color.BLACK;
    private String boardStyle = "Classic Brown";
    private String pieceStyle = "Default";
    private String boardSize = "Medium";

    public ChessBoardPanel(Board board) {
        this.board = board;

        setLayout(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                JLabel square = new JLabel("", SwingConstants.CENTER);

                square.setOpaque(true);
                square.setBackground((row + col) % 2 == 0 ? dark : light);

                square.setFont(new Font("SansSerif", Font.PLAIN, 65));

                squares[row][col] = square;

                final int r = row;
                final int c = col;

                square.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        System.out.println("Mouse button: " + e.getButton());
                        selectSquare(r, c);
                    }
                });

                add(square);
            }
        }

        refreshBoard();
    }

    public void refreshBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                // Set square color
                if (row == selectedRow && col == selectedCol) {
                    squares[row][col].setBackground(highlight);
                } else {
                    squares[row][col].setBackground(
                            (row + col) % 2 == 0 ? dark : light);
                }

                // Get piece
                Piece piece = board.getPiece(
                        new Position(7 - row, col));

                if (piece == null) {
                    squares[row][col].setText("");
                } else {
                    squares[row][col].setText(
                            getUnicodePiece(piece.getSymbol()));

                    // Set piece color
                    if (piece.getSymbol().startsWith("w")) {
                        squares[row][col].setForeground(whitePieceColor);
                    } else {
                        squares[row][col].setForeground(blackPieceColor);
                    }
                }
            }
        }
    }

    private void selectSquare(int row, int col) {
        if (gameOver) {
            return;
        }

        // First click: select a piece
        if (selectedRow == -1) {

            Position position = new Position(7 - row, col);

            if (board.getPiece(position) != null) {
                selectedRow = row;
                selectedCol = col;
            }

        } else {

            Position from = new Position(7 - selectedRow, selectedCol);
            Position to = new Position(7 - row, col);

            Piece capturedPiece = board.getPiece(to);

            // Check whether a King is being captured
            if (capturedPiece != null &&
                    capturedPiece.getSymbol().endsWith("K")) {

                Piece movingPiece = board.getPiece(from);
                String winner = movingPiece.getColor().toString();
                JOptionPane.showMessageDialog(
                        this,
                        winner + " wins!",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);

                board.movePiece(from, to);

                selectedRow = -1;
                selectedCol = -1;
                gameOver = true;
                refreshBoard();

                return;
            }

            board.movePiece(from, to);

            selectedRow = -1;
            selectedCol = -1;
        }

        refreshBoard();
    }

    public void setBoardStyle(String style) {
        boardStyle = style;

        switch (style) {
            case "Classic Brown":
                light = new Color(240, 217, 181);
                dark = new Color(181, 136, 99);
                break;

            case "Modern Gray":
                light = new Color(220, 220, 220);
                dark = new Color(100, 100, 100);
                break;

            case "Green":
                light = new Color(235, 235, 208);
                dark = new Color(119, 149, 86);
                break;
        }

        refreshBoard();
    }

    public void setPieceStyle(String style) {
        pieceStyle = style;

        switch (style) {
            case "Default":
                whitePieceColor = Color.WHITE;
                blackPieceColor = Color.BLACK;
                break;

            case "Red and Blue":
                whitePieceColor = Color.RED;
                blackPieceColor = Color.BLUE;
                break;

            case "Black and White":
                whitePieceColor = Color.BLACK;
                blackPieceColor = Color.GRAY;
                break;
        }

        refreshBoard();
    }

    private String getUnicodePiece(String symbol) {
        switch (symbol) {
            case "wK":
                return "♔";
            case "wQ":
                return "♕";
            case "wR":
                return "♖";
            case "wB":
                return "♗";
            case "wN":
                return "♘";
            case "wp":
                return "♙";

            case "bK":
                return "♚";
            case "bQ":
                return "♛";
            case "bR":
                return "♜";
            case "bB":
                return "♝";
            case "bN":
                return "♞";
            case "bp":
                return "♟";

            default:
                return "";
        }
    }

    public String getBoardStyle() {
        return boardStyle;
    }

    public String getPieceStyle() {
        return pieceStyle;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(String size) {
        boardSize = size;
    }

}
