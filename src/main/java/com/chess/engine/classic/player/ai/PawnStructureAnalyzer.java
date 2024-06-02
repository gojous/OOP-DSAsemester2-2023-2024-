package com.chess.engine.classic.player.ai;
import com.chess.engine.classic.pieces.Piece;
import com.chess.engine.classic.player.Player;
import java.util.Collection;
import java.util.stream.Collectors;
public final class PawnStructureAnalyzer{
    private static final PawnStructureAnalyzer INSTANCE = new PawnStructureAnalyzer();
    public static final int ISOLATED_PAWN_PENALTY = -10;
    public static final int DOUBLED_PAWN_PENALTY = -10;
    private PawnStructureAnalyzer(){}
    public static PawnStructureAnalyzer get(){
        return INSTANCE;
    }
    public int isolatedPawnPenalty(final Player player){
        return calculateIsolatedPawnPenalty(createPawnColumnTable(calculatePlayerPawns(player)));
    }
    public int doubledPawnPenalty(final Player player){
        return calculatePawnColumnStack(createPawnColumnTable(calculatePlayerPawns(player)));
    }
    public int pawnStructureScore(final Player player){
        final int[] pawnOnColumnTable = createPawnColumnTable(calculatePlayerPawns(player));
        return calculatePawnColumnStack(pawnOnColumnTable)+calculateIsolatedPawnPenalty(pawnOnColumnTable);
    }
    private static Collection<Piece> calculatePlayerPawns(final Player player){
        return player.getActivePieces().stream().filter(piece->piece.getPieceType()==Piece.PieceType.PAWN).collect(Collectors.toList());
    }
    private static int calculatePawnColumnStack(final int[] pawnOnColumnTable){
        int pawnStackPenalty=0;
        for(final int pawnStack:pawnOnColumnTable){
            if(pawnStack>1){
                pawnStackPenalty+=pawnStack;
            }
        }
        return pawnStackPenalty*DOUBLED_PAWN_PENALTY;
    }
    private static int[] createPawnColumnTable(final Collection<Piece> playerPawns){
        final int[] table=new int[8];
        for(final Piece playerPawn: playerPawns){
            table[playerPawn.getPiecePosition()%8]++;
        }
        return table;
    }
}
