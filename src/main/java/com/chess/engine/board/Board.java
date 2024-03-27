package com.chess.engine.board;
import java.util.List;
import java.util.Map;
import com.chess.engine.pieces.Piece;
import com.chess.engine.Alliance;
// rest of your code
public class Board {
    private final list<Tile> gameBoard;
   private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles=new Tile[BoardUtils.NUM_TILES];
        for(int i=0;i<BoardUtils.NUM_TILES;i++){
            tiles[i]=Tile.createTile(i,builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    } 
    private Board(Builder builder){
        this.gameBoard=createGameBoard(builder);
    }
    public Tile getTile(final int tileCoordinate){
        return null;
    }
    public static Board createStandardBoard(){
        final Builder builder=new Builder();
        //Black Layout
        builder.setPiece(new Rook(0,Alliance.BLACK));
        builder.setPiece(new Knight(1,Alliance.BLACK));
        builder.setPiece(new Bishop(2,Alliance.BLACK));
        builder.setPiece(new Queen(3,Alliance.BLACK));
        builder.setPiece(new King(4,Alliance.BLACK));
        builder.setPiece(new Bishop(5,Alliance.BLACK));
        builder.setPiece(new Knight(6,Alliance.BLACK));
        builder.setPiece(new Rook(7,Alliance.BLACK));
        builder.setPiece(new Pawn(8,Alliance.BLACK));
        builder.setPiece(new Pawn(9,Alliance.BLACK));
        builder.setPiece(new Pawn(10,Alliance.BLACK));
        builder.setPiece(new Pawn(11,Alliance.BLACK));
        builder.setPiece(new Pawn(12,Alliance.BLACK));
        builder.setPiece(new Pawn(13,Alliance.BLACK));
        builder.setPiece(new Pawn(14,Alliance.BLACK));
        builder.setPiece(new Pawn(15,Alliance.BLACK));
        //White Layout
        builder.setPiece(new Rook(63,Alliance.WHITE));
        builder.setPiece(new Knight(62,Alliance.WHITE));
        builder.setPiece(new Bishop(61,Alliance.WHITE));
        builder.setPiece(new Queen(60,Alliance.WHITE));
        builder.setPiece(new King(59,Alliance.WHITE));
        builder.setPiece(new Bishop(58,Alliance.WHITE));
        builder.setPiece(new Knight(57,Alliance.WHITE));
        builder.setPiece(new Rook(56,Alliance.WHITE));
        builder.setPiece(new Pawn(55,Alliance.WHITE));
        builder.setPiece(new Pawn(54,Alliance.WHITE));
        builder.setPiece(new Pawn(53,Alliance.WHITE));
        builder.setPiece(new Pawn(52,Alliance.WHITE));
        builder.setPiece(new Pawn(51,Alliance.WHITE));
        builder.setPiece(new Pawn(50,Alliance.WHITE));
        builder.setPiece(new Pawn(49,Alliance.WHITE));
        builder.setPiece(new Pawn(48,Alliance.WHITE));
        //white to move
        builder.setMoveMaker(Alliance.WHITE);
        return builder.build();
    }

    public static class Builder{
        Map<Integer, Piece> boardConfig;
        Alliance nexMoveMaker;
        public Board build(){
            return new Board(this);
        }
        public Builder(){
            public Builder setPiece(final Piece piece){
                this.boardConfig.put(piece.getPiecePosition(),piece);
                return this;
            }
            public Builder setMoveMaker(final Alliance nextMoveMaker){
                this.nextMoveMaker=nextMoveMaker;
                return this;
            }
        }
    }
}
