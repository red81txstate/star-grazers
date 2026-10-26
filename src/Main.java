import game.Game;
import board.Board;

// Entry point for the console chess application.
public class Main {
    // Starts a new game. @param args command-line arguments (unused)
    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        board.display();
        
        Game game = new Game();
        game.start();
    }
}
