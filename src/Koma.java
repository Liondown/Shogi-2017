import javax.swing.*;
public class Koma {
	
	private String name;
	private PlayingUser side;
	private boolean canPromote;
	private boolean isPromoted;
	private boolean onTheBoard;
	private char ref;
	private LegalMove[] legalMovesTable;
	private ImageIcon ic;
	private int startingX;
	private int startingY;
	private ImageIcon ic2;
	
	
	public Koma(PlayingUser s, String n, boolean prom, boolean isProm, 
			boolean on, char c, int index, ImageIcon i){

		this.side = s;
		this.name = n;
		this.canPromote = prom;
		this.isPromoted = isProm;
		this.onTheBoard = on;
		this.ref = c;
		this.legalMovesTable = new LegalMove[index];
		this.ic = i;
		this.startingX = startingX;
		this.startingY = startingY;
		if(prom){
			this.ic2 = ic2;
		}
	}

	public char getRef(){
		return ref;
	}
	
	public void setRef(char c){
		ref = c;
	}
	
	public PlayingUser getPlayingUser(){
		return side;
	}
	
	public void setSide(PlayingUser s){
		side = s;
	}
	
	public boolean getCanPromote(){
		return canPromote;
	}
	
	public void setCanPromote(boolean prom){
		canPromote = prom;
	}
	
	public boolean getIsPromoted(){
		return isPromoted;
	}
	
	public void setIsPromoted(boolean isProm){
		isPromoted = isProm;
	}
	
	public LegalMove[] getLegalMovesTable(){
		return legalMovesTable;
	}
	
	public void setLegalMoveTable(LegalMove[] array){
		legalMovesTable = array;
	}
	
	public void printLegalMoves() {
		LegalMove[] table = getLegalMovesTable();
		for(int i = 0; i < table.length; i++) {
			int x = table[i].getXCoord();
			int y = table[i].getYCoord();
			System.out.println("x: "+ x + " y: " + y);
		}
	}
	
	public ImageIcon getImageIcon(){
		return ic;
	}
	
	public void setImageIcon(ImageIcon i){
		ic = i;
	}
	
	public ImageIcon getImageIcon2(){
		return ic2;
	}
	
	public void setImageIcon2(ImageIcon i2){
		ic2 = i2;
	}
	
	public void addToTable(int index, int r, int d){
			legalMovesTable[index] = new LegalMove(r, d);
	}
	
	public void promoteToGold(){
		if(getCanPromote() == true){
			setIsPromoted(true);
		}
		
	}
	
	public void setStartingX(int x){
		startingX = x;
	}
	
	public int getStartingX(){
		return startingX;
	}
	
	public void setStartingY(int y){
		startingY = y;
	}
	
	public int getStartingY(){
		return startingY;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
}
