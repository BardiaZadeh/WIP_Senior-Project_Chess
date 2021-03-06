/*Contributing team members
	Stephen May
 * */
package sp.pieces;

import sp.application.Square;
import sp.pieces.Piece.PieceType;

public class Rook extends Piece {
	/**<h2>Constructor</h2>
	 * <p>
	 * This Constructor takes only the team argument and 
	 * two integer for the column and row
	 * </p>
	 * @param team Team enum
	 * @param row int row
	 * @param column int column
	 * @author Menelio Alvarez
	 * */
	public Rook(Team team, int row, int column ) {
		
		//if statement to set image based on team
		if(team == Team.GOLD) {
			super.setImg("file:Assets/gold_rook.png");
		}else {
			super.setImg("file:Assets/black_rook.png");
		}
		
		super.setRow(row);
		super.setColumn(column);
		super.setTeam(team);
		super.setPieceType(PieceType.ROOK);
	}

	@Override
	public boolean isLegalMove(int startRow, int startColumn, int endRow, int endColumn, Square[][] boardArray) {
		if (startRow == endRow || Math.abs(startRow - endRow) == 1) {
			if (startColumn == endColumn || Math.abs(startColumn - endColumn) == 1) {
				return true;
			}
		}
		else if (boardArray[endRow][endColumn].getPiece() != null && boardArray[endRow][endColumn].getPiece().getTeam() != this.getTeam() && 
				(Math.abs(startRow - endRow) < 4 && Math.abs(startColumn - endColumn) < 4)
				) {
			return true;
		}
		return false;
	
	}

	public String toString() {
		return "Rook";
	}
}
