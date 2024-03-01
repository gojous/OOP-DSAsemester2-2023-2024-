package com.chess.engine.pieces;
public class Piece {
    public enum PieceType{
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }
    public enum PieceColor{
        WHITE,
        BLACK
    }
    private final PieceType pieceType;
    private final PieceColor pieceColor;
    Piece(PieceType pieceType,PieceColor pieceColor){
        this.pieceType=pieceType;
        this.pieceColor=pieceColor;
    }
    public PieceType getPieceType(){
        return this.pieceType;
    }
    public PieceColor getPieceColor(){
        return this.pieceColor;
    }
}
