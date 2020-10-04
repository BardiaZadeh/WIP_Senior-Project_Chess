/*Contributing team members
 * Richard OlgalTree
*/
package player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import board.Board;
import board.Move;
import pieces.King;
import pieces.Piece;
import pieces.Team;

public abstract class Player {
	
	protected final Board board;
	protected final King playerKing;
	protected final Collection<Move> legalMoves;
	private final boolean isInCheck;
	
	Player(final Board board, final Collection<Move> legalMoves, final Collection<Move> opponentMoves) {
		this.board = board;
		this.playerKing = establishKing();
		this.legalMoves = legalMoves;
		this.isInCheck = !Player.calculateAttacksOnTile(this.playerKing.getPiecePosition(), opponentMoves).isEmpty();
	}

	private static Collection<Move> calculateAttacksOnTile(int piecePosition, Collection<Move> moves) {
		final List<Move> attackMoves = new ArrayList<>();
		for (final Move move : moves) {
			if (piecePosition == move.getDestinationCoordinate()) {
				attackMoves.add(move);
			}
		}
		return attackMoves;
	}

	private King establishKing() {
		for (final Piece piece : getActivePieces()) {
			if (piece.getPieceType().isKing()) {
				return (King)piece;
			}
		}
		throw new RuntimeException("Invalid Board");
	}
	
	public boolean isMoveLegal(final Move move) {
		return this.legalMoves.contains(move);
	}
	
	public boolean isInCheck() {
		return this.isInCheck;
	}
	
	public boolean isInCheckMake() {
		return this.isInCheck && !hasEscapeMoves();
	}
	
	public boolean isInStaleMate() {
		return !this.isInCheck && !hasEscapeMoves();
	}
	
	protected boolean hasEscapeMoves() {
		for (final Move move : this.legalMoves) {
			final MoveTransition transition = makeMove(move);
			if (transition.getMoveStatus().isDone()) {
				return true;
			}
		}
		return false;
	}
	
	public MoveTransition makeMove(final Move move) {
		return null;
	}
	
	public abstract Collection<Piece> getActivePieces();
	public abstract Team getTeam();
	public abstract Player getOpponent();

}