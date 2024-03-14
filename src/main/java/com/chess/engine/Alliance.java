package com.chess.engine;
import com.chess.engine.Alliance;


public enum Alliance {
    WHITE(){
        public boolean isWhite(){
            return true;
        }
        public boolean isBlack(){
            return false;
        }
        public int getDirection(){
            return -1;
        }
        public int getOppositeDirection(){
            return 1;
        }
        public boolean isPawnPromotionSquare(int position){
            return BoardUtils.Instance.FIRST_ROW.get[position];
        }
        public Player choosePlayerByAlliance(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer){
            return whitePlayer;
        }
        public String toString(){
            return "White";
        }
        public int pawnBonus(final int position){
            return WHITE_PAWN_PREFERED_COORDINATES[position];
        }
        public int knightBonus(final int position){
            return WHITE_KNIGHT_PREFERED_COORDINATES[position];
        }
        public int bishopBonus(final int position){
            return WHITE_BISHOP_PREFERED_COORDINATES[position];
        }
        public int rookBonus(final int position){
            return WHITE_ROOK_PREFERED_COORDINATES[position];
        }
        public int queenBonus(final int position){
            return WHITE_QUEEN_PREFERED_COORDINATES[position];
        }
        public int kingBonus(final int position){
            return WHITE_KING_PREFERED_COORDINATES[position];
        }

    },BLACK(){
        public boolean isWhite(){
            return false;
        }
        public boolean isBlack(){
            return true;
        }
        public int getDirection(){
            return 1;
        }
        public int getOppositeDirection(){
            return -1;
        }
        public boolean isPawnPromotionSquare(int position){
            return BoardUtils.Instance.EIGHTH_ROW.get[position];
        }
        public Player choosePlayerByAlliance(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer){
            return blackPlayer;
        }
        public String toString(){
            return "Black";
        }
        public int pawnBonus(final int position){
            return BLACK_PAWN_PREFERED_COORDINATES[position];
        }
        public int knightBonus(final int position){
            return BLACK_KNIGHT_PREFERED_COORDINATES[position];
        }
        public int bishopBonus(final int position){
            return BLACK_BISHOP_PREFERED_COORDINATES[position];
        }
        public int rookBonus(final int position){
            return BLACK_ROOK_PREFERED_COORDINATES[position];
        }
        public int queenBonus(final int position){
            return BLACK_QUEEN_PREFERED_COORDINATES[position];
        }
        public int kingBonus(final int position){
            return BLACK_KING_PREFERED_COORDINATES[position];
        }
    };
    public abstract int getDirection();
    public abstract int getOppositeDirection();
    public abstract int pawnBonus(final int position);
    public abstract int knightBonus(final int position);
    public abstract int bishopBonus(final int position);
    public abstract int rookBonus(final int position);
    public abstract int queenBonus(final int position);
    public abstract int kingBonus(final int position);
    public abstract boolean isWhite();
    public abstract boolean isBlack();
    public abstract boolean isPawnPromotionSquare(int position);
    public abstract Player choosePlayerByAlliance(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer);
    }


}
