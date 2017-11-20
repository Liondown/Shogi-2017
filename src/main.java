import java.util.*;


public class main {
	

	public static void main(String[] args){
		
		Board b = new Board(10,10);
		Square [][] grid = b.getGrid();
		
		Player one = new Player(PlayingUser.LOWER);
		Player two = new Player(PlayingUser.UPPER);
		Lance lance = new Lance(PlayingUser.UPPER);
		Knight knight =  new Knight(PlayingUser.UPPER);
		SilverGeneral silverGeneral = new SilverGeneral(PlayingUser.UPPER);
		GoldGeneral goldGeneral = new GoldGeneral(PlayingUser.UPPER);
		OpKing opKing = new OpKing(PlayingUser.UPPER);
		Rook rook = new Rook(PlayingUser.UPPER);
		Bishop bishop = new Bishop(PlayingUser.UPPER);
		Pawn pawn = new Pawn(PlayingUser.UPPER);
		
		b.forceSetPiece(pawn, 0, 1);
		b.printGrid();
		b.makeMove(0, 1, 1, 1, one);
//		b.forceSetPiece(new Bishop(PlayingUser.UPPER), 0, 8);
//		b.forceSetPiece(bishop, 8, 0);
//		b.forceSetPiece(new Rook(PlayingUser.UPPER), 0, 4);
//		b.forceSetPiece(new Rook(PlayingUser.LOWER), 8, 4);
//		
	}
}
