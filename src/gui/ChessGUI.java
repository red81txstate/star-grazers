

package gui;

import javax.swing.JFrame;

import board.Board;

public class ChessGUI extends JFrame {

    
public ChessGUI() {
    setTitle("Chess Game");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    Board board = new Board();
    board.initialize();

    add(new ChessBoardPanel(board));

    setVisible(true);
}

}
