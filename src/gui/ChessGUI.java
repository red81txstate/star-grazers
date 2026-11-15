

package gui;

import javax.swing.JFrame;

public class ChessGUI extends JFrame {

    public ChessGUI() {
        setTitle("Chess Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ChessBoardPanel());

        setVisible(true);
    }
}
