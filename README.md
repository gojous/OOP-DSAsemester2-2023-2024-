#This is a OOP-DSA game called ChessBoard we will be doing for this semester 2 (2023-2024).

Rules:
1. The player with the white pieces makes the first move

2. Each player takes turns making one move at a time

3. Every Chess piece moves in a unique way

4. Rules of Checkmate and Draw



Board: Generate/Detect the pieces. 

Pawn: Pawns are the weakest pieces on the board, but they can be very useful in controlling space and blocking the opponent's pieces. Pawns move forward one or two squares on their first move, and one square at a time after that. The chess rule for pawns is that they can only capture other pieces diagonally one square ahead of them.

Rook: Rooks are powerful pieces that can move horizontally or vertically any number of squares. They are often used to control open files or to attack the opponent's pieces from a distance.

Knight: Knights move in an "L" shape, with two squares in one direction and then one square in a perpendicular direction. They are the only pieces that can jump over other pieces, which makes them useful for surprise attacks.

Bishop: Bishops move diagonally any number of squares. They are often used to control diagonals and to attack the opponent's pieces from a distance.

Queen: The queen is the most powerful piece on the board, and can move horizontally, vertically, or diagonally any number of squares. It is often used to control the center of the board and to attack the opponent's pieces from multiple angles.

King: The king is the most important piece on the board, but also the weakest. It can move one square in any direction and is used to protect the other pieces and control the center of the board.
GameManager:
Turns: White always go first

It's worth noting that the rule only applies in certain situations, and not all endgame positions are subject to the 50-move rule. Additionally, some chess variants have different rules regarding the 50-move rule.
If a player wishes to end the game because they believe that they cannot win, they can resign at any time.

GameState:
If a player's king is under attack (in "check"), the player must make a move to get out of check. This can be done by moving the king, capturing the attacking piece, or blocking the attack with another piece.
If a player's king is under attack and there is no legal move to get out of check, the game is over, and the player who brings the opponent's king into check wins.
If a player is not in check but has no legal moves left, the game is a draw by "stalemate." Stalemate often occurs when a player is trying to force a win and overreaches, putting their opponent's king in a position where it cannot move without being placed in check.

In this situation, the player with the inferior position can sometimes escape with a draw by intentionally allowing their pieces to be captured until the game reaches a stalemate.
If the same position on the board occurs three times during the game, with the same player to move, the game is a draw by "threefold repetition."

To claim a threefold repetition, the player must announce it to the arbiter or their opponent, and the players should be able to identify the position that has been repeated. It's worth noting that the repetition doesn't need to occur in consecutive moves, as long as the position on the board is identical and the same player is to move.

The threefold repetition rule is in place to prevent players from endlessly repeating moves to run out the clock or frustrate their opponent. It also helps to prevent a player from exploiting a small advantage to win in an endgame position where no further progress is possible.
If both players have made 50 moves without a capture or a pawn move, the game is a draw by the "50-move rule." The rule applies only to the player whose turn it is to move, and they must claim the draw before making the 50th move. If the player fails to claim the draw and makes a move, the 50-move count starts again.


