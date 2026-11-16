
package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import board.Board;

public class ChessGUI extends JFrame {

    public ChessGUI() {
        setTitle("Chess Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Board board = new Board();
        board.initialize();

        ChessBoardPanel boardPanel = new ChessBoardPanel(board);
        add(boardPanel);

        JButton settingsButton = new JButton("Settings");

        settingsButton.addActionListener(e -> {
            new SettingsWindow(this, boardPanel);
        });

        add(settingsButton, BorderLayout.SOUTH);

        setVisible(true);
    }

}
