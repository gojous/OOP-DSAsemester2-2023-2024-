package com.chess.engine.classic.pieces;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.BoardUtils;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.chess.engine.board.Tile;
import com.chess.engine.classic.Alliance;


public class Knight extends Piece{
    private final static int[] CANDIDATE_MOVE_COORDINATES={-17,-15,-10,-6,6,10,15,17};
    public Knight(final Alliance pieceAlliance,final int piecePosition,){
        super(PieceType.KNIGHT,piecePosition,pieceAlliance);
    }       
    @Override
    public Collection<Move> calculatedLegalMoves(Board board){
        int candidateDestinationCoordinate;
        final List<Move> legalMoves=new ArrayList<>();

        for(final int currentCandidate :CANDIDATE_MOVE_COORDINATES){

            final int candidateDestinationCoordinate=this.piecePosition+ currentCandidate;
            if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                if(isFirstColumnExclusion(this.PiecePosition, currentCandidate)||
                isSecondColumnExclusion(this.PiecePosition, currentCandidate)||
                isSeventhColumnExclusion(this.PiecePosition, currentCandidate)||
                isEighthColumnExclusion(this.PiecePosition, currentCandidate)){
                    continue;
                }

                final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
                if(!candidateDestinationTile.isTileTaken()){
                    legalMoves.add(new Move());
                }
                else{
                    final Piece pieceAtDestination=candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
                    if(this.pieceAlliance!=pieceAlliance){
                        legalMoves.add(new Move());//later adding to move class
                    }
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }
    @Override
    public String toString(){
        return PieceType.Knight.toString();
    }
    private static boolean isFirstColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&(candidateOffset==-17||candidateOffset==-10||candidateOffset==6||candidateOffset==15);

    }
    private static boolean isSecondColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition]&&(candidateOffset==-10||candidateOffset==6);
    }
    private static boolean isSeventhColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition]&&(candidateOffset==-6||candidateOffset==10);
    }
    private static boolean isEighthColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition]&&(candidateOffset==-15||candidateOffset==-6||candidateOffset==10||candidateOffset==17);
    }
}
