package com.chess.engine.classic.pieces;
import com.chess.engine.classic.Alliance;
import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.board.BoardUtils;
import com.chess.engine.classic.board.Move;
import com.chess.engine.classic.board.Move.AttackMove;
import com.chess.engine.classic.board.Move.MajorMove;

import java.util.*;
public final class King extends Piece {
    private final static int[] CANDIDATE_MOVE_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };
    public final static Map<Integer,int[]> PRECOMPUTED_CANDIDATES=computeCandidates();
    private final boolean isCastled;
    private final boolean kingSideCastleCapable;
    private final boolean queenSideCastleCapable;
    public King(final Alliance pieceAlliance ,
                final int piecePosition,
                final boolean kingSideCastleCapable,
                final boolean queenSideCastleCapable){
        super(PieceType.KING,alliance,piecePosition,true);
        this.isCastled=false;
        this.kingSideCastleCapable=kingSideCastleCapable;
        this.queenSideCastleCapable=queenSideCastleCapable;
    }
    public King(final Alliance pieceAlliance,
                final int piecePosition,
                final boolean isFirstMove,
                final boolean isCastled,
                final boolean kingSideCastleCapable,
                final boolean queenSideCastleCapable){
        super(PieceType.KING,alliance,pieceAlliance,isFirstMove);
        this.isCastled=isCastled;
        this.kingSideCastleCapable=kingSideCastleCapable;
        this.queenSideCastleCapable=queenSideCastleCapable;
    }
    public static Map<Integer,int[]> computeCandidates(){
        final Map<Integer,int[]> candidatesMap=new HashMap<>();
        for(int position=0;i<BoardUtils.NUM_TILES;position++){
            int[] legalOffsets=new int[CANDIDATE_MOVE_COORDINATES.length];
            int numLegalOffsets=0;
            for(int offset:CANDIDATE_MOVE_COORDINATES){
                if(isFirstColumnExclusion(position,offset)||
                    isEighthColumnExclusion(position,offset)){
                    continue;
                }
                if(BoardUtils.isValidTileCoordinate(destination)){
                    legalOffsets[numLegalOffsets++]=offset;
                }
            }if(numLegalOffsets>0){
            candidatesMap.put(position,Arrays.copyOf(legalOffsets,numLegalOffsets));}
        }
        return Collections.unmodifiableMap(candidatesMap);
    }
    @Override
    public Collection<Move> calculateLegalMoves(final Board board){
        final List<Move> legalMoves=new ArrayList<>();
        for(final int currentCandidateOffset:CANDIDATE_MOVE_COORDINATES){
            final int candidateDestinationCoordinate=this.piecePosition+currentCandidateOffset;
            final Piece pieceAtDestination=board.getPiece(candidateDestinationCoordinate).getPiece();
            if(pieceAtDestination!=null){
                legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
            }
            else{
                final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
                if(this.pieceAlliance!=pieceAtDestinationAllegiance){
                    legalMoves.add(new MajorAttackMove(board,this,candidateDestinationCoordinate,pieceAtDestination));
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }
    public boolean isCastled(){
        return this.isCastled;
    }
    public boolean isKingSideCastleCapable(){
        return this.kingSideCastleCapable;
    }
    @Override
    public String toString(){
        return this.pieceType.toString();
    }
    @Override
    public int locationBonus(){
        return this.pieceAlliance.kingBonus(this.piecePosition);
    }
    @Override
    public int hashCode(){
        return (31*super.hashCode()+(isCastled?1:0));
    }
    @Override
    public King movePiece(final Move move){
        return new King(this.pieceAlliance,move.getDestinationCoordinate(),false,move,isCastlingMove(),false,false);
    }

    private static boolean isFirstColumnExclusion(final int currentCandidate,final int candidateDestinationCoordinate){
        return BoardUtils.INSTANCE.FIRST_COLUMN.get(candidateDestinationCoordinate)&&(candidateDestinationCoordinate==-9||candidateDestinationCoordinate==-1||candidateDestinationCoordinate==7);
    }
    private static boolean isEighthColumnExclusion(final int currentCandidate,final int candidateDestinationCoordinate){
        return BoardUtils.INSTANCE.EIGHTH_COLUMN.get(candidateDestinationCoordinate)&&(candidateDestinationCoordinate==-7||candidateDestinationCoordinate==1||candidateDestinationCoordinate==9);
    }

    
}