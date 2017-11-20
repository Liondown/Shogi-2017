
public class Square {
	private boolean isOccupied;
	private int x;
	private int y;
	private Koma piece;
	
	public Square(int xCoord, int yCoord, Koma p){
		this.isOccupied = false;
		this.x = xCoord;
		this.y = yCoord;
		this.piece = p;
		
	}
	
	public void setPiece(Koma p){
		piece = p;
		isOccupied = true;
	}
	
	public Koma getPiece(){
		return piece;
	}
	
	public void setIsOccupied(boolean isOcc){
		isOccupied = isOcc;
	}
	
	public boolean getIsOccupied(){
		return isOccupied;
	}
	
	public void removePieceHere() {
		piece = null;
		isOccupied = false;
	}
	
	public boolean hasKing() {
		if(piece.getName().equals("King"))
			return true;
		else if(piece.getName().equals("Opponent King"))
			return true;
		else
			return false;
	}

}
