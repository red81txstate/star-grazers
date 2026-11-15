
package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

public class ChessBoardPanel extends JPanel {

    public ChessBoardPanel() {
        setLayout(new GridLayout(8, 8));

        Color light = new Color(240, 217, 181);
        Color dark = new Color(181, 136, 99);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                JPanel square = new JPanel();

                if ((row + col) % 2 == 0) {
                    square.setBackground(light);
                } else {
                    square.setBackground(dark);
                }

                add(square);
            }
        }
    }
}
