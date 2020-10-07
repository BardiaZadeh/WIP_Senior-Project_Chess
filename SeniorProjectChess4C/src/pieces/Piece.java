/*Contributing team members
 * Richard OlgalTree
 * Menelio Alvarez
*/
package pieces;

import java.util.Collection;
import java.util.List;

import board.Board;
import board.Move;
import board.GeneralUtils;

// class to store each piece object. will be extended by each piece class (Knight, Bishop, etc.)
public abstract class Piece /*extends BoardUtils*/ {
	
	final PieceType pieceType;
	
	// position on the board of where the piece is
	final int piecePosition;

	// piece's team (yellow or black)
	final Team pieceTeam;
	
	// constructor
	Piece(final PieceType pieceType, final int piecePosition, final Team pieceTeam) {
		this.pieceType = pieceType;
		this.piecePosition = piecePosition;
		this.pieceTeam = pieceTeam;
	}
	
	public int getPiecePosition() {
		return this.piecePosition;
	}
	
	// gets the piece's team
	public Team getPieceTeam() {
		return this.pieceTeam;
	}
	
	public PieceType getPieceType() {
		return this.pieceType;
	}
	
	// list of legal moves. will be initialized in the subclasses
	public abstract Collection<Move> calculateLegalMoves(final Board board);
	
	public enum PieceType {
		
		PAWN("P") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		KNIGHT("N") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		BISHOP("B") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		ROOK("R") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		QUEEN("Q") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		KING("K") {
			@Override
			public boolean isKing() {
				// TODO Auto-generated method stub
				return true;
			}
		};
		
		private String pieceName;
		
		PieceType (final String pieceName) {
			this.pieceName = pieceName;
		}
		
		@Override
		public String toString() {
			return this.pieceName;
		}
		
		public abstract boolean isKing();
		
	}


	
}