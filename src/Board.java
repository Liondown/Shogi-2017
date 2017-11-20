import java.util.*;

enum PlayingUser{
	UPPER, LOWER
}

public class Board {

	private Square[][] grid;
	private int turnCount;
	private ArrayList<Move> moveLog;
	private Player one;
	private Player two;
	private boolean isPlayerOnesTurn;
	
	public Board(int coordX, int coordY){
		PlayingUser one = PlayingUser.LOWER;
		PlayingUser two = PlayingUser.UPPER;
		this.one = new Player(one);
		this.two = new Player(two);
		grid = new Square[coordX][coordY];
		boolean isPlayerOneTurn = true;
		this.turnCount = 0;
		this.moveLog = moveLog;

		
		for(int i = 0; i < coordX; i++){
			for(int j = 0; j < coordY; j++){
				grid[i][j] = new Square(i,j, null);
			}
		}
	}
	
	public Player getPlayerOne() {
		return one;
	}
	
	public Player getPlayerTwo() {
		return two;
	}
	
	public void setPlayerOne(Player p) {
		one = p;
	}
	
	public void setPlayerTwo(Player p) {
		two = p;
	}
	
	public void incrementTurnCount(){
		turnCount++;
	}
	
	public Square[][] getGrid(){
		return grid;
	}
	
	public void setGrid(Square[][] g){
		grid = g;
	}
	
	public void printGrid() {
		// prints the grid
		for (int i = 0; i < 9; i++) {
			System.out.print(i);
			for (int j = 0; j < 9; j++) {
				if (grid[i][j].getPiece() == null)
					System.out.print("(  )");
				if(grid[i][j].getPiece() != null && grid[i][j].getPiece().getPlayingUser().equals(PlayingUser.UPPER))
					System.out.print("(V" + grid[i][j].getPiece().getRef()+ ")");
				if(grid[i][j].getPiece() != null && grid[i][j].getPiece().getPlayingUser().equals(PlayingUser.LOWER))
					System.out.print("(^" + grid[i][j].getPiece().getRef()+ ")");
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void enterMove(int x, int y, int pX, int pY, Koma p, int t){
		PlayingUser s = p.getPlayingUser();
		moveLog.add(new Move(s, x, y, pX, pY, p, t));
	}
	
	public String toString(int currentX, int nextX, int currentY, int nextY, Koma piece){	
		return currentX + ", " + currentY + "| " + nextX + ", " + nextY + "| Player "  + piece.getPlayingUser() + " " + Koma.class.getSimpleName();
	}
	public void initGrid(){
		grid[0][0].setPiece(new Lance(PlayingUser.UPPER));
		grid[0][1].setPiece(new Knight(PlayingUser.UPPER));
		grid[0][2].setPiece(new SilverGeneral(PlayingUser.UPPER));
		grid[0][3].setPiece(new GoldGeneral(PlayingUser.UPPER));
		grid[0][4].setPiece(new OpKing(PlayingUser.UPPER));
		grid[0][5].setPiece(new GoldGeneral(PlayingUser.UPPER));
		grid[0][6].setPiece(new SilverGeneral(PlayingUser.UPPER));
		grid[0][7].setPiece(new Knight(PlayingUser.UPPER));
		grid[0][8].setPiece(new Lance(PlayingUser.UPPER));
		grid[1][1].setPiece(new Rook(PlayingUser.UPPER));
		grid[1][7].setPiece(new Bishop(PlayingUser.UPPER));
		
		for(int i = 0; i < 9; i++){
			grid[2][i].setPiece(new Pawn(PlayingUser.UPPER));
		}
		
		grid[8][0].setPiece(new Lance(PlayingUser.LOWER));
		grid[8][1].setPiece(new Knight(PlayingUser.LOWER));
		grid[8][2].setPiece(new SilverGeneral(PlayingUser.LOWER));
		grid[8][3].setPiece(new GoldGeneral(PlayingUser.LOWER));
		grid[8][4].setPiece(new King(PlayingUser.LOWER));
		grid[8][5].setPiece(new GoldGeneral(PlayingUser.LOWER));
		grid[8][6].setPiece(new SilverGeneral(PlayingUser.LOWER));
		grid[8][7].setPiece(new Knight(PlayingUser.LOWER));
		grid[8][8].setPiece(new Lance(PlayingUser.LOWER));
		grid[7][1].setPiece(new Bishop(PlayingUser.LOWER));
		grid[7][7].setPiece(new Rook(PlayingUser.LOWER));
		
		for(int i = 0; i < 9; i++){
			grid[6][i].setPiece(new Pawn(PlayingUser.LOWER));
		}
	}
	public void forceSetPiece(Koma p, int x, int y) {
		grid[x][y].setPiece((p));
		
	}
	
	public void capturePiece(int coordX, int coordY){
		if(grid[coordX][coordY].getPiece() == null)
			return;
		Koma piece = grid[coordX][coordY].getPiece();
		if(piece.getRef() != 'k'){
			if(one.getTurn() && piece.getPlayingUser() == PlayingUser.UPPER){
				if(piece.getIsPromoted() == true)
					piece.setIsPromoted(false);
				piece.setSide(PlayingUser.LOWER);
				one.getCapturedPieces().add(piece);
				one.setTurn(false);
				two.setTurn(true);
			}
			else if(two.getTurn() && piece.getPlayingUser() == PlayingUser.LOWER){
				if(piece.getIsPromoted() == true)
					piece.setIsPromoted(false);
				piece.setSide(PlayingUser.UPPER);
				two.getCapturedPieces().add(piece);
				two.setTurn(false);
				one.setTurn(true);
			}
			grid[coordX][coordY].setPiece(null);
		}
	}
	
	public String placePiece(char c, int coordX, int coordY){
		
		for(int i = 0; i < 18; i++){
			if(grid[coordX][coordY] == null)
				return "Null pointer Error";
			else if(grid[coordX][coordY].getIsOccupied())
				return "Cannot place piece on an occupied square!";
			
			if(!grid[coordX][coordY].getIsOccupied()) {
				Koma element = one.getCapturedPieces().get(i);
				Koma element2 = two.getCapturedPieces().get(i);
			if(one.getTurn() && element.getRef() == c){
				grid[coordX][coordY].setPiece(element);
				one.setTurn(false);
				two.setTurn(true);
				one.getCapturedPieces().remove(i);
				return "Piece placed successfully, turn over";
				}
			else if(two.getTurn() && element2.getRef() == c){
				grid[coordX][coordY].setPiece(element2);
				two.setTurn(false);
				one.setTurn(true);
				two.getCapturedPieces().remove(i);
				return "Piece placed successfully, turn over";
				}
			else {
				return "No such off-the-grid piece owned by player";
			}
			}
		}
		return "ERROR: Could not place piece";
	}
	
	public void makeMove(int row, int col, int x, int y, Player player){
		
		//Checks if there is a piece on the square on the corresponding grid
		
		if(grid[row][col].getPiece() == null)
			return;
		
		// Obtain piece if there is one
		Koma piece = grid[row][col].getPiece();
		
		// Get table of legal moves
		LegalMove table[] = piece.getLegalMovesTable();


		if((player.getTurn()) && piece.getPlayingUser() == player.getName()) {
			
			//This loop iterates through the table of moves and makes sure that the given x and y matches with the moves in the table.
			//It also makes sure that there is no negative integers
			
			for(int i = 0; i < table.length; i++) {
				LegalMove fromTable = table[i];
				
				//fetch X coordinate
				int r = fromTable.getXCoord();
				
				//fetch Y coordinate
				int d = fromTable.getYCoord();
				
				System.out.println("R: " + r + " D: " + d);
				System.out.println("Row + R: " + (row+r) + " Col + D: " + (col+d));
				
				//This if statement makes sure there are no negative integers in play
				if(row+r >= 0 && col+d >= 0 && row+r < 9 && col+d < 9) {
					
				//This if statement checks and see the given x and y are legitimate moves for the Koma
					
				if(row+r == x && col+d == y) {
					System.out.println("R: " + r + " Row + R: " + (row+r) + " D: " + d + " Col + D: " + (col+d));
//					if(grid[x][y].getIsOccupied() && grid[x][y].getPiece().getPlayingUser() != player.getName()) {
//						capturePiece(x, y);
//					}
				//If the square is not occupied it will place the given Koma on the square
					if(!grid[row+r][col+d].getIsOccupied()) {
						grid[x][y].setPiece(piece);
						grid[row][col].removePieceHere();
				
						//Change turns
						if(player.getName() == PlayingUser.LOWER) {
							one.setTurn(false);
							two.setTurn(true);
						}
						else {
							two.setTurn(false);
							one.setTurn(true);
						}
					}
				 
				//If the square is occupied by a Koma belonging to the same player it will cancel the move
				 else if(grid[row+r][col+d].getIsOccupied()) {
					 if(grid[x][y].getPiece().getPlayingUser() == player.getName()) {
						 System.out.println("You cannot capture your own pieces!");
					 }
					 else if(grid[x][y].getPiece().getRef() == 'k' || grid[x][y].getPiece().getRef == '') {
						 
					 }
				//If the square is held by an opponent's koma then this will make the player capture the koma
					 else {
						 capturePiece(x, y);
							grid[x][y].setPiece(piece);
							grid[row][col].removePieceHere();
							
							//Change turns
							if(player.getName() == PlayingUser.LOWER) {
								one.setTurn(false);
								two.setTurn(true);
							}
							else {
								two.setTurn(false);
								one.setTurn(true);
							}
					 }
				 }
				grid[row][col].setIsOccupied(false);
				break;
				}
			}
		}
	}
}
	
	
	public boolean isTsumi(){
		return false;
	}
	
	public boolean isOte(){
		return true;
		
	}
}
