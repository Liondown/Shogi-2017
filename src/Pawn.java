import javax.swing.ImageIcon;

public class Pawn extends Koma{
	
	public Pawn(PlayingUser s){
		super(s, "Pawn", false, true, true, 'p', 1, new ImageIcon("source/img/pawn2.png"));
		
		if(s.equals(PlayingUser.UPPER)){
			addToTable(0, 1, 0);
		}
		else if(s.equals(PlayingUser.LOWER)){
			addToTable(0, -1, 0);
			setImageIcon(new ImageIcon("source/img/pawn.png"));
		}
		
		ImageIcon i = new ImageIcon("source/img/templateKoma.png");
			
		if(s.equals("one")){
			i = new ImageIcon("source/img/promotedPawnFinal2.png");
		}
		else if(s.equals("two")){
			i = new ImageIcon("source/img/promotedPawnFinal.png");
		}
		setImageIcon2(i);
	}
	
	public void promoteToGold(){
		if(getCanPromote() == true){
			setIsPromoted(true);
		}
	}


}
