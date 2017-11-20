
public class Move {
	private PlayingUser side;
	private int xCoord;
	private int yCoord;
	private int prevX;
	private int prevY;
	private Koma piece;
	private int turnCount;
	
	public Move(PlayingUser s, int x, int y, int pX, int pY, Koma p, int t){
		this.side = s;
		this.xCoord = x;
		this.yCoord = y;
		this.prevX = pX;
		this.prevY = pY;
		this.piece = p;
		this.turnCount = t;
	}
	
	public PlayingUser getPlayingUser(){
		return side;
		
	}
	
	public void setPlayingUser(PlayingUser s){
		side = s;
	}
	
	public int getXCoord(){
		return xCoord;
	}
	
	public void setXCoord(int xC){
		xCoord = xC;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
	public void setYCoord(int yC){
		yCoord = yC;
	}
	
	public int getPrevX(){
		return prevX;
	}
	
	public void setPrevX(int pX){
		prevX = pX;
	}
	
	public int getPrevY(){
		return prevY;
	}
	
	public void setPrevY(int pY){
		prevY = pY;
	}
	
	public Koma getPiece(){
		return piece;
	}
	
	public void setPiece(Koma p){
		piece = p;
	}
	
	public void setTurnCount(int t){
		turnCount = t;
	}
	
	public int getTurnCount(){
		return turnCount;
	}

}
