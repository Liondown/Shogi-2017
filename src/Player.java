import java.util.ArrayList;

public class Player {
	
	private PlayingUser name;
	private boolean turn;
	private ArrayList<Koma> capturedPieces;
	
	public Player(PlayingUser n) {
		capturedPieces = new ArrayList<Koma>();
		name = n;
		if(n == PlayingUser.LOWER) {
			turn = true;
		}
		else
			turn = false;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setTurn(boolean t) {
		turn = t;
	}
	
	public ArrayList<Koma> getCapturedPieces(){
		return capturedPieces;
	}
	
	public void setCapturedPieces(ArrayList<Koma> c) {
		capturedPieces = c;
	}
	
	public PlayingUser getName() {
		return name;
	}
	
	public void setName(PlayingUser n) {
		name = n;
	}
}
