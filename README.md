Chess Game – Phase 2 (GUI)

CS 3354.004 Group Project
Repository: [star-grazers](https://github.com/red81txstate/star-grazers)  
Branch: `phase2-gui`

Overview
Phase 2 adds a Swing GUI on top of the Phase 1 console chess model.  
Players can click pieces to move them, capture opponent pieces, and win by capturing the King.  
Movement validation is intentionally not required (per assignment).

Features Implemented
- 8×8 chessboard with alternating light/dark squares (White at bottom)
- Starting position pieces displayed with distinct symbols
- Click-to-move (select piece → click destination)
- Capture logic (moving onto an opponent’s piece removes it)
- King-capture endgame: popup declares the winner and exits
- Extra features:
  - Menu bar with New Game
  - Move history panel

How to Compile and Run
From the project root:

```bash
javac -d out -sourcepath src src/gui/ChessGUI.java
java -cp out gui.ChessGUI
