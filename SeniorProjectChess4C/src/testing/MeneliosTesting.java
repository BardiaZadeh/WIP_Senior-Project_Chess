package testing;

import pieces.*;
import board.Board;
import board.Move;
import board.Board.Builder;
import board.GeneralUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class MeneliosTesting {

	public static void main(String[] args) {
		//array of test pieces 
		Piece[] ar = new Piece[1] ;
		
		//test Piece
		ar[0] = new Knight(35, Team.BLACK);
		
		//adding test pieces to array
	
		
		//Board for testing
		Board b = Board.createTestBoard(ar);
		
		//testing
		System.out.println("Knight is at "+b.getTile(35).getPiece().getPiecePosition());
		
		char[][] cb = GeneralUtils.get2dCharBoard(b);
		
		for(int i=0; i < cb.length;i++) {
			for(int j=0; j < cb.length;j++) {
				System.out.print(cb[i][j]+" ");
			}
			System.out.println();
		}
		
		
		Move[] moves = 	ar[0].calculateLegalMoves(b).toArray(new Move[0]);
		
		System.out.println("Number of legal moves is "+moves.length);
		
		System.out.println("Those moves are");
		
		
		
		boolean bl= false;
		for(int i=0; i < 63 ;i++ ) {
			for(int j=0; j < moves.length; j++) {
				if(moves[j].getDestinationCoordinate() == i) {
					bl =true;
				}
				
			}
			if(!bl) {
				System.out.println("move list does not contain "+i);
			}
			bl =false;
		}
		
		
		//move list does contain
		for( int i=0; i < moves.length; i++) {
			System.out.println("index "+i+"= "+moves[i].getDestinationCoordinate());
		}
		
		
		System.out.println("--------------------------"+b.getTile(35).getPiece().getPieceType());


	}

}
