package gui;

import javax.swing.JFrame;
import board.Board;

public class ChessGUI extends JFrame {
    private final Board board = new Board();
    private final ChessBoardPanel boardPanel = new ChessBoardPanel();

    public ChessGUI() {
        setTitle("Chess Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        board.initialize();
        add(boardPanel);
        boardPanel.refresh(board);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChessGUI();
    }
}