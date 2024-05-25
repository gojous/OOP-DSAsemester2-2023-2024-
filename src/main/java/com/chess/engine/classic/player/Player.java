package com.chess.engine.classic.player;
import com.chess.engine.classic.Alliance;
import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.board.Move;
import com.chess.engine.classic.pieces.King;
import com.chess.engine.classic.pieces.Piece;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import static com.chess.engine.classic.board.MoveUtils.NULL_MOVE;
import static com.chess.engine.classic.pieces.Piece.PieceType.KING;
import static java.util.stream.Collectors.collectingAndThen;
public abstract class Player {
    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    protected final boolean isInCheck;
    Player(final Board board,
            final Collection<Move> legalMoves,
            final Collection<Move> opponentMoves,final boolean isInCheck){
        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = Collections.unmodifaibleCollection(playerLegals);
        this.isInCheck =!calculatedAttacksOnTile(this.playerKing.getPiecePosition(),opponentLegals).isEmpty();
        playerLegals.addAll(calculateKingCastles(playerLegals,opponentLegals));
        
    }
    public boolean isMoveLegal(final Move move){
        return this.legalMoves.contains(move);
    }
    public boolean isInCheck(){
        return this.isInCheck();
    }
    public boolean isInCheckMate(){
        return this.isInCheck()&&!hasEscapeMoves();
    }
    public boolean isInStalemate(){
        return !this.isInCheck()&&!hasEscapeMoves();
    }
    public boolean isCastled(){
        return this.playerKing.isCastled();
    }
    public King getPlayerKing(){
        return this.playerKing;
    }
    public boolean isKingSideCastleCapable(){
        return this.playerKing.isKingSideCastleCapable();
    }
    public boolean isQueenSideCastleCapable(){
        return this.playerKing.isQueenSideCastleCapable();
    }
    
    private static Collection <Move> calculatedAttacksOnTile(final int tile, Collection<Move> moves){
        return move.stream()
        .filter(move->move.getDestinationCoordinate()==tile)
        .collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
    }
    
    private King establishKing(){
        return (King) getActivePieces().stream()
        .filter(piece->piece.getPieceType().equals(KING))
        .findAny()
        .orElseThrow(RuntimeException::new);
    }
    private boolean hasEscapeMoves(){
        return this.legalMoves.stream()
        .anyMatch(move->makeMove(move).getMoveStatus().isDone());
    }
    public Collection<Move> getLegalMoves(){
        return this.legalMoves;
    }
    public MoveTransition makeMove(final Move move){
        if(!isMoveLegal(move)){
            return new MoveTransition(this.board,move,MoveStatus.ILLEGAL_MOVE);
        }
        final Board transitionBoard = move.execute();
        return transitionBoard.currentPlayer().getOpponent().isInCheck()?
                new MoveTransition(transitionBoard,move,MoveStatus.LEAVES_PLAYER_IN_CHECK):
                new MoveTransition(transitionBoard,move,MoveStatus.DONE);
        
    }
    public MoveTransition unMakeMove(final Move move){
        return new MoveTransition(this.board,move.undo(),move,moveStatus,MoveStatus.DONE);
    }
    protected boolean hasCastleOpportunities(){
        return !this.isInCheck()&&!this.playerKing.isCastled()
                && (this.playerKing.isKingSideCastleCapable()||this.playerKing.isQueenSideCastleCapable());
    }
    protected abstract Collection<Move> calculateKingCastles(Collection<Move> playerLegals,Collection<Move> opponentsLegals);
    public abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();

}
