package com.chess.engine.pieces;
import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import java.util.List;

public abstract class Piece {
    protected final int PiecePosition;
    protected final Alliance pieceAlliance;
    
    Piece(final int piecePosition, final Alliance pieceAlliance){
        this.PiecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }
    public Alliance getPieceAlliance(){
        return this.pieceAlliance;
    }
public abstract List<Move> calculatedLegalMoves(final Board board);

}


