package com.chess.engine.board;

public abstract class Tile{
    int tileCoordinate;
    Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }
    public abstract boolean isTileTaken();

    public abstract Piece getPiece();
    public static final class EmptyTile extends Tile{
        EmptyTile(int coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileTaken(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    
    }
    public static final class TakenTile extends Tile{
        Piece pieceOnTile;
        TakenTile(int coordinate,Piece pieceOnTile){
            super(tileoordinate);
            this.pieceOnTile=pieceOnTile;
        }
        @Override
        public boolean isTileTaken(){
            return true;
        }
        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}