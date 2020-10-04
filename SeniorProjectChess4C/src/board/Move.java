/*Contributing team members
 * Richard OlgalTree
*/
package board;

import pieces.Piece;

// class to hold a general move, whether that is a move without capturing, or a move that captures an opponent's piece
public abstract class Move {
	
	// variables to hold board, piece that is being moved, and destination tile
	final Board board;
	final Piece movedPiece;
	final int destinationCoordinate;
	
	// constructor for Move
	private Move (final Board board, final Piece movedPiece, final int destinationCoordinate) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destinationCoordinate = destinationCoordinate;
	}
	
	public int getDestinationCoordinate() {
		return destinationCoordinate;
	}
	
	// subclass for a move that does not capture a piece
	public static final class MajorMove extends Move {
		// constructor
		public MajorMove (final Board board, final Piece movedPiece, final int destinationCoordinate) {
			super(board, movedPiece, destinationCoordinate);
		}
	}
	
	// subclass for a move that does capture an opponent's piece
	public static final class AttackMove extends Move {
		
		// variable to hold piece that is being captured
		final Piece attackedPiece;
		
		// constructor
		public AttackMove (final Board board, final Piece movedPiece, final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movedPiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}
		
	}

}