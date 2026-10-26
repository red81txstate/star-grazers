Phase 1 Plan — Console Chess (CLI Backend)

Team members
- red81txstate - feature/red81txstate: Board, Display
- adrianmtz-txst - adrian-work: Piece hierachy, CLI

###Milestones

## Milestone 1: Project setup and core model
# Tasks
- Create package structure (pieces, board, game, utils)
- Implement Position and Color
- Create abstract Piece class with Javadoc
- Add compliable skeletons for all piece subclasses
# Manual tests
- Compile the project with javac
- Instantiate a Position and print algebraic notation
- Confirm abstract class compiles and cannot be instantiated directly

## Milestone 2: Piece classes and movement methods
# Tasks
- Implement possibleMoves() for Pawn, Rook, Knight, Bishop, Queen, King
- Add basic occupancy checks (cannot capture own pieces)
- Javadoc every class and method
# Manual tests
- Create a board, place a knight on E4, verify its possible moves 
- include the expected L-shaped squares
- Place a rook and confirm it stops at blocking pieces
- Confirm a white pawn on E2 can move to E3 and E4 and cannot capture 
- own pieces

## Milestone 3: Board setup and display
# Tasks
- Implement Board with 8×8 Piece[][]
- Write initialize() for standard starting position
- Write display() matching the required console format (file labels A–H, 
--rank labels 1–8, ## for empty squares, piece symbols)
# Manual tests
- Call initialize() then display() and verify starting position matches the 
--sample in the instructions
- Confirm empty squares show ## and pieces show correct symbols (wp, bR, etc.)

## Milestone 4: CLI workflow and basic move validation
# Tasks
- Implement main loop in Game that displays the board, shows whose turn, and 
--prompts for input
- Parse "E2 E4" style input (tolerant of case and extra spaces)
- Basic validation: correct format, source has current player's piece, 
--destination in bounds, cannot capture own piece, move is in the piece's
--possibleMoves()
- Apply valid moves and switch turns; print clear error messages for invalid 
--input without crashing
# Manual tests**
- Start the program and confirm the initial board is shown
- Enter E2 E4: pawn should move and turn switches to Black
- Enter invalid formats (E2, Z9 E4, E2E4) 
--program should reject and re-prompt
- Try to move the opponent's piece or capture your own piece
--should be rejected
- Enter several legal moves and confirm the board updates correctly

## Notes
- Castling, en passant, pawn promotion, check, and checkmate are out of scope
--for Phase 1 (placeholders exist).
- Each milestone should correspond to one or more commits (or PRs) on feature
--branches.
- Documentation (Javadoc + README updates) is part of every milestone.