package com.chess.engine.pieces;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.BoardUtils;
import java.util.Collection;
import java.util.List;
public class Knight extends Piece{
    private final static int[] CANDIDATE_MOVE_COORDINATES={-17,-15,-10,-6,6,10,15,17};
    Knight(final int piecePosition,final Alliance pieceAlliance){
        super(piecePosition,pieceAlliance);
    }       
    @Override
    public List<Move> calculatedLegalMoves(Board board){
        int candidateDestinationCoordinate;
        final List<Move> legalMoves=new ArrayList<>();

        for(final int currentCandidate :CANDIDATE_MOVE_COORDINATES){

            final int candidateDestinationCoordinate=this.piecePosition+currentCandidate;
            if(isValidTileCoordinate(candidateDestinationCoordinate)){
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
    private static boolean isFirstColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition]&&(candidateOffset==-17||candidateOffset==-10||candidateOffset==6||candidateOffset==15);

    }
    
}
