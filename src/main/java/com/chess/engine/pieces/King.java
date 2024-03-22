package com.chess.engine.pieces;
import com.chess.engine.classic.board.Move.MajorAttackMove;
import com.chess.engine.classic.board.Move.MajorMove;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.*;
public final class King extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };

    private final static Map<Integer, int[]> PRECOMPUTED_CANDIDATES = computeCandidates();

    private final boolean isCastled;
    private final boolean kingSideCastleCapable;
    private final boolean queenSideCastleCapable;
@@ -41,6 +41,29 @@ public King(final Alliance alliance,
        this.queenSideCastleCapable = queenSideCastleCapable;
    }

    private static Map<Integer, int[]> computeCandidates() {
        final Map<Integer, int[]> candidates = new HashMap<>();
        for (int position = 0; position < BoardUtils.NUM_TILES; position++) {
            int[] legalOffsets = new int[CANDIDATE_MOVE_COORDINATES.length];
            int numLegalOffsets = 0;
            for (int offset : CANDIDATE_MOVE_COORDINATES) {
                if (isFirstColumnExclusion(position, offset) ||
                        isEighthColumnExclusion(position, offset)) {
                    continue;
                }
                int destination = position + offset;
                if (BoardUtils.isValidTileCoordinate(destination)) {
                    legalOffsets[numLegalOffsets++] = offset;
                }
            }
            if (numLegalOffsets > 0) {
                candidates.put(position, Arrays.copyOf(legalOffsets, numLegalOffsets));
            }
        }
        return Collections.unmodifiableMap(candidates);
    }


    public boolean isCastled() {
        return this.isCastled;
    }
@@ -56,22 +79,16 @@ public boolean isQueenSideCastleCapable() {
    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)) {
                continue;
            }
        for (final int currentCandidateOffset : PRECOMPUTED_CANDIDATES.get(this.piecePosition)) {
            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                final Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);
                if (pieceAtDestination == null) {
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Alliance pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
                    if (this.pieceAlliance != pieceAtDestinationAllegiance) {
                        legalMoves.add(new MajorAttackMove(board, this, candidateDestinationCoordinate,
                                pieceAtDestination));
                    }
            final Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);
            if (pieceAtDestination == null) {
                legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
            } else {
                final Alliance pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
                if (this.pieceAlliance != pieceAtDestinationAllegiance) {
                    legalMoves.add(new MajorAttackMove(board, this, candidateDestinationCoordinate,
                            pieceAtDestination));
                }
            }
        }