package com.chess.engine.classic.pieces;
import com.chess.engine.classic.Alliance;
import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.board.Move;

import java.util.Collection;
public abstract class Piece {
    final int pieceType;
    final int PiecePosition;
    final Alliance pieceAlliance;
    private final boolean isFirstMove;
    private final int cachedHashCode;

    Piece(final PieceType type,
          final Alliance pieceAlliance,
          final int piecePosition,
          final boolean isFirstMove){
        this.PiecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
        this.pieceType = type;
        this.isFirstMove = isFirstMove;
        this.cachedHashCode = computeHashCode();

    }
    public int getPiecePosition(){
        return this.PiecePosition;
    }
    public Alliance getPieceAlliance(){
        return this.pieceAlliance;
    }
    public boolean isFirstMove(){
        return this.isFirstMove;
    }
    public PieceType getPieceType(){
        return this.pieceType;
    }
    public int getPieceValue(){
        return this.pieceType.getPieceValue();
    }
    public abstract int locationBonus();
    public abstract Piece movePiece(Move move);
    public abstract Collection<Move> calculateLegalMoves(final Board board);
    @Override
    public boolean equals(final Object other){
        if(this==other){
            return true;
        }
        if(!(other instanceof Piece)){
            return false;
        }
        final Piece otherPiece = (Piece) other;
        return this.piecePosition==otherPiece.getPiecePosition() && this.pieceType==otherPiece.getPieceType() &&
               this.pieceAlliance==otherPiece.getPieceAlliance() && this.isFirstMove==otherPiece.isFirstMove();
    }
    @Override
    public int hashCode(){
        return this.cachedHashCode;
    }
    private int computeHashCode(){
        int result = pieceType.hashCode();
        result = 31 * result + pieceAlliance.hashCode();
        result = 31 * result + piecePosition;
        result = 31 * result + (isFirstMove ? 1 : 0);
        return result;
    }
public enum PieceType{
    PAWN(100,"P"),
    KNIGHT(300,"N"),
    BISHOP(330,"B"),
    ROOK(500,"R"),
    QUEEN(900,"Q"),
    KING(100000,"K");
    private final String pieceName;
    private final int value;
    public int getPieceValue(){
        return this.value;
    }
    PieceType(final int val,final String pieceName){
        this.value = val;
        this.pieceName = pieceName;
    }
    @Override
    public String toString(){
        return this.pieceName;
    }
}
}
