package game;

import board.Board;
import pieces.Piece;
import utils.Color;
import utils.Position;
import java.util.Scanner;

public class Game {
    private Board board;
    private Color currentTurn;
    private Scanner scanner;

    public Game() {
        board = new Board();
        board.initialize();
        currentTurn = Color.WHITE;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Console Chess - Phase 1");
        System.out.println("Enter moves like: E2 E4");
        System.out.println("Type 'quit' to exit.\n");

        while (true) {
            board.display();
            System.out.println(currentTurn + "'s turn.");
            System.out.print("Move: ");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Game ended.");
                break;
            }

            if (!processMove(input)) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean processMove(String input) {
        String[] parts = input.toUpperCase().split("\\s+");
        if (parts.length != 2) return false;

        Position from = parsePosition(parts[0]);
        Position to = parsePosition(parts[1]);
        if (from == null || to == null) return false;

        Piece piece = board.getPiece(from);
        if (piece == null) {
            System.out.println("No piece at " + parts[0]);
            return false;
        }
        if (piece.getColor() != currentTurn) {
            System.out.println("That's not your piece.");
            return false;
        }

        // Basic move (no full legality yet — Adrian's possibleMoves can plug in later)
        board.movePiece(from, to);
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
        return true;
    }

    private Position parsePosition(String alg) {
        if (alg.length() != 2) return null;
        int col = alg.charAt(0) - 'A';
        int row = alg.charAt(1) - '1';
        if (col < 0 || col > 7 || row < 0 || row > 7) return null;
        return new Position(row, col);
    }
}