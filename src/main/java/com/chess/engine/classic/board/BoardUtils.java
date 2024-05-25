package com.chess.engine.classic.board;

public class BoardUtils {
    private static final boolean[] FIRST_COLUMN=initColumn(0);
    private static final boolean[] SECOND_COLUMN=initColumn(1);
    private static final boolean[] SEVENTH_COLUMN=initColumn(6);
    private static final boolean[] EIGHTH_COLUMN=initColumn(7);
    private static final boolean[] SECOND_ROW=initRow(8);
    private static final boolean[] SEVENTH_ROW=initRow(48);
    private static final int NUM_TILES=64;
    public static final int NUM_TILES_PER_ROW=8;
    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate me!!!!!"); 
    }
    public static boolean isValidTileCoordinate(int coordinate){
        return coordinate>=0 && coordinate<64;
    }
    private static boolean[] initColumn(int columnNumber){
        final boolean[] column=new boolean[NUM_TILES];
        do{
            column[columnNumber]=true;
            columnNumber+=NUM_TILES_PER_ROW;
        }while(columnNumber<NUM_TILES);
        return column;
    }
    public static boolean[] initRow(int columnNumber){
        final boolean[] row=new boolean[NUM_TILES];
        do{
            row[columnNumber]=true;
            columnNumber++;
        }while(columnNumber%NUM_TILES_PER_ROW!=0);
        return row;
    }
    
}
