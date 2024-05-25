package com.chess.engine.classic.board;
import com.chess.engine.classic.board.Board.Builder;
import com.chess.engine.classic.pieces.Pawn;
import com.chess.engine.classic.pieces.Piece;
import com.chess.engine.classic.pieces.Rook;
public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    private Move(final Board board,
                 final Piece movedPiece,
                 final int destinationCoordinate){
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
    public int getDestinationCoordinate(){
        return this.destinationCoordinate;
    }
    public abstract Board excute();
        
    public static final class MajorMove extends Move{
        public MajorMove(final Board board,
                         final Piece movedPiece,
                         final int destinationCoordinate){
            super(board, movedPiece, destinationCoordinate);
        }
    }
    @Override
    public Board execute(){
        return null;
    }
    public static final class AttackMove extends Move{
        final Piece attackedPiece;
        public AttackMove(final Board board,
                          final Piece movedPiece,
                          final int destinationCoordinate,
                          final Piece attackedPiece){
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }
    }


    
}
