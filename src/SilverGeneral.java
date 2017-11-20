import javax.swing.ImageIcon;

public class SilverGeneral extends Koma {
	
	private boolean[][] legalMovesTable;
	
	public SilverGeneral(PlayingUser s){
		super(s, "Silver General", true, false, true, 's', 5, new ImageIcon("source/img/sgeneral2.png"));
		
		if(s.equals(PlayingUser.UPPER)){
			addToTable(0, 1, -1);	
			addToTable(1, 1, 0);
			addToTable(2, 1, 1);
			addToTable(3, -1, -1);
			addToTable(4, -1, 1);
		}
		else if(s.equals(PlayingUser.LOWER)){
			addToTable(0, -1, -1);	
			addToTable(1, -1, 0);
			addToTable(2, -1, 1);
			addToTable(3, 1, -1);
			addToTable(4, 1, 1);
			setImageIcon(new ImageIcon("source/img/sgeneral.png"));
		}
		
	}
	
	public void promoteToGold(){
		if(getCanPromote() == true){
			setIsPromoted(true);
		}
		
	}

}
