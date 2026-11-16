Chess Game – Phase 2 (GUI)

CS 3354.004 Group Project
Repository: [star-grazers](https://github.com/red81txstate/star-grazers)  
Branch: phase2-gui

Overview
Phase 2 adds a Swing GUI on top of the Phase 1 console chess model.  
Players can click pieces to move them, capture opponent pieces, and win by capturing the King.  
Movement validation is intentionally not required (per assignment).

Features Implemented
- 8×8 chessboard with alternating light/dark squares (White at bottom)
- Starting position pieces displayed with distinct symbols
- Click to move (select piece → click destination)
- Capture logic (moving onto an opponent’s piece removes it)
- King-capture endgame: popup declares the winner and exits
- Extra features:
  - Settings window
  - Move history panel

Console Chess — Phase 1 (CLI Backend)

A console-based chess game written in Java. Phase 1 provides a complete board setup, piece movement rules, turn-based play, and basic move validation.

Environment & Dependencies

Java: 11 or higher (tested with Java 17)
Build tool: none required — pure javac / java
No external libraries

How to Compile and Run

From the project root (the folder that contains the src directory):

bash
Compile everything
javac -d out $(find src -name "*.java")

Run
java -cp out Main

Or, if you prefer to stay inside src:

bash
cd src
javac *.java pieces/*.java board/*.java game/*.java utils/*.java
java Main

How to Play

1. The program prints the starting board and prompts for a move.
2. Enter moves in algebraic form: FROM TO (example: E2 E4).
3. Case does not matter (e2 e4 works).
4. Type quit or exit to end the game.
5. Invalid input is rejected with a clear message; the game continues.

Example session

   A  B  C  D  E  F  G  H
   
8  bR bN bB bQ bK bB bN bR 

7  bp bp bp bp bp bp bp bp 

6  ## ## ## ## ## ## ## ## 

...
White to move.
Enter move (FROM TO): E2 E4


Feature List

Implemented
- 8×8 board with standard starting position
- Console display with file/rank labels and ## empty squares
- Piece symbols: wp/bp, wR/bR, wN/bN, wB/bB, wQ/bQ, wK/bK
- Abstract Piece + all six subclasses with possibleMoves()
- Turn management (White starts)
- Input parsing tolerant of case and extra whitespace
- Basic legality: correct format, own piece, bounds, cannot capture own pieces, piece-specific movement rules
- Clear error messages; program does not crash on bad input

Not Implemented (Phase 1 limitations)
- Castling
- En passant
- Pawn promotion
- Check / checkmate / stalemate detection
- Undo
- AI opponent

Project Structure

src/
├── Main.java
├── board/Board.java
├── game/Game.java
├── game/Player.java
├── pieces/Piece.java (abstract)
├── pieces/Pawn.java
├── pieces/Rook.java
├── pieces/Knight.java
├── pieces/Bishop.java
├── pieces/Queen.java
├── pieces/King.java
└── utils/Position.java
└── utils/Color.java

Documentation

Javadoc comments are present on all public classes and methods.
Generate HTML docs with: javadoc -d docs/api -sourcepath src $(find src -name "*.java")

Known Issues / Limitations
No check detection, so a player can move into check.
No castling or promotion.
Board display uses spaces for alignment; very narrow terminals may wrap.

How to Compile and Run
From the project root:

bash
javac -d out -sourcepath src src/gui/ChessGUI.java
java -cp out gui.ChessGUI

