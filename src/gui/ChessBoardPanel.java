package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import board.Board;
import pieces.Piece;
import utils.Position;

public class ChessBoardPanel extends JPanel {
    private final JLabel[][] labels = new JLabel[8][8];
    private Board currentBoard;
    private Position selected = null;

    public ChessBoardPanel() {
        setLayout(new GridLayout(8, 8));
        Color light = new Color(240, 217, 181);
        Color dark = new Color(181, 136, 99);

        for (int displayRow = 7; displayRow >= 0; displayRow--) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel(new BorderLayout());
                square.setBackground((displayRow + col) % 2 == 0 ? light : dark);

                JLabel label = new JLabel("", SwingConstants.CENTER);
                label.setFont(new Font("SansSerif", Font.PLAIN, 36));
                square.add(label);
                labels[displayRow][col] = label;

                final int r = displayRow;
                final int c = col;
                square.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleClick(new Position(r, c));
                    }
                });

                add(square);
            }
        }
    }

    public void refresh(Board board) {
        this.currentBoard = board;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece p = board.getPiece(new Position(row, col));
                labels[row][col].setText(p != null ? p.getSymbol() : "");
            }
        }
    }

        private void handleClick(Position clicked) {
        if (selected == null) {
            Piece p = currentBoard.getPiece(clicked);
            if (p != null) {
                selected = clicked;
                System.out.println("Selected: " + clicked.toAlgebraic());
            }
        } else {
            Piece target = currentBoard.getPiece(clicked);
            Piece moving = currentBoard.getPiece(selected);

            // Do the move (overwrites = capture)
            currentBoard.movePiece(selected, clicked);

            // Check if we captured a King
            if (target != null && target.getSymbol().toLowerCase().contains("k")) {
                String winner = moving.getColor().toString();
                javax.swing.JOptionPane.showMessageDialog(this,
                    winner + " wins by capturing the King!",
                    "Game Over",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            selected = null;
            refresh(currentBoard);
            System.out.println("Moved to: " + clicked.toAlgebraic());
        }
    }