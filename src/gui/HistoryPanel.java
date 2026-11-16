
package gui;

import game.Game;
import game.Move;
import pieces.Piece;
import utils.Position;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel {

    private Game game;
    private JTextArea historyText;
    private ChessBoardPanel boardPanel;

    /**
     * Constructs a HistoryPanel to display the history of moves in the game.
     * @param game the Game instance to track.
     * @param boardPanel the ChessBoardPanel associated with this history panel.
     */
    public HistoryPanel(Game game, ChessBoardPanel boardPanel) {

        this.game = game;
        this.boardPanel = boardPanel;

        setLayout(new BorderLayout());

        historyText = new JTextArea();
        historyText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historyText);

        JButton undoButton = new JButton("Undo");

        undoButton.addActionListener(e -> {
            boardPanel.undoMove();
        });

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(new JLabel("Game History"), BorderLayout.CENTER);
        topPanel.add(undoButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        refreshHistory();
    }

    /**
     * Refreshes the history display to show the latest moves and captured pieces.
     */
    public void refreshHistory() {

        StringBuilder text = new StringBuilder();

        text.append("Moves:\n");

        int moveNumber = 1;

        for (Move move : game.getMoveHistory()) {

            Piece piece = move.getMovedPiece();

            text.append(moveNumber++)
                    .append(". ")
                    .append(piece.getSymbol())
                    .append(" ")
                    .append(toChessNotation(move.getFrom()))
                    .append(" -> ")
                    .append(toChessNotation(move.getTo()));

            if (move.getCapturedPiece() != null) {
                text.append(" x ")
                        .append(move.getCapturedPiece().getSymbol());
            }

            text.append("\n");
        }

        text.append("\nCaptured Pieces:\n");

        for (Move move : game.getMoveHistory()) {

            Piece captured = move.getCapturedPiece();

            if (captured != null) {
                text.append(captured.getSymbol()).append(" ");
            }
        }

        historyText.setText(text.toString());
    }

    private String toChessNotation(Position position) {

        char column = (char) ('a' + position.getCol());
        int row = position.getRow() + 1;

        return "" + column + row;
    }
}
