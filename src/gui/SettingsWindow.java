
package gui;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private ChessBoardPanel boardPanel;
    private JFrame mainFrame;

    private JComboBox<String> boardStyle;
    private JComboBox<String> pieceStyle;
    private JComboBox<String> boardSize;

    /**
     * Constructs a SettingsWindow for adjusting chess board and piece settings.
     * @param mainFrame the main JFrame of the application.
     * @param boardPanel the ChessBoardPanel to apply settings to.
     */
    public SettingsWindow(JFrame mainFrame, ChessBoardPanel boardPanel) {

        this.mainFrame = mainFrame;
        this.boardPanel = boardPanel;

        setTitle("Chess Settings");
        setSize(350, 250);
        setLocationRelativeTo(mainFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(4, 2, 10, 10));

        // Board style
        add(new JLabel("Board Style:"));

        boardStyle = new JComboBox<>(new String[]{
            "Classic Brown",
            "Modern Gray",
            "Green"
        });
        boardStyle.setSelectedItem(boardPanel.getBoardStyle());
        add(boardStyle);

        // Piece style
        add(new JLabel("Piece Style:"));

        pieceStyle = new JComboBox<>(new String[]{
            "Default",
            "Red and Blue",
            "Black and White"
        });
        pieceStyle.setSelectedItem(boardPanel.getPieceStyle());
        add(pieceStyle);

        // Board size
        add(new JLabel("Board Size:"));

        boardSize = new JComboBox<>(new String[]{
            "Small",
            "Medium",
            "Large"
        });
        boardSize.setSelectedItem(boardPanel.getBoardSize());
        add(boardSize);

        // Apply button
        JButton applyButton = new JButton("Apply");

        applyButton.addActionListener(e -> applySettings());

        add(applyButton);

        setVisible(true);
    }

    private void applySettings() {

        boardPanel.setBoardStyle(
            (String) boardStyle.getSelectedItem()
        );

        boardPanel.setPieceStyle(
            (String) pieceStyle.getSelectedItem()
        );

        String size = (String) boardSize.getSelectedItem();
        boardPanel.setBoardSize(size);

        switch (size) {
            case "Small":
                mainFrame.setSize(600, 600);
                break;

            case "Medium":
                mainFrame.setSize(800, 800);
                break;

            case "Large":
                mainFrame.setSize(1000, 1000);
                break;
        }

        mainFrame.setLocationRelativeTo(null);
    }
}
