import javax.swing.ImageIcon;

public class Lance extends Koma {

	public Lance(PlayingUser s){
		super(s, "Lance", true, false, true, 'l', 8, new ImageIcon("source/img/lance2.png"));
		
		if(s.equals(PlayingUser.UPPER)){
			addToTable(0, 1, 0);
			addToTable(1, 2, 0);
			addToTable(2, 3, 0);
			addToTable(3, 4, 0);
			addToTable(4, 5, 0);
			addToTable(5, 6, 0);
			addToTable(6, 7, 0);
			addToTable(7, 8, 0);
		}
		else if(s.equals(PlayingUser.LOWER)){
			addToTable(0, -1, 0);
			addToTable(1, -2, 0);
			addToTable(2, -3, 0);
			addToTable(3, -4, 0);
			addToTable(4, -5, 0);
			addToTable(5, -6, 0);
			addToTable(6, -7, 0);
			addToTable(7, -8, 0);
			setImageIcon(new ImageIcon("source/img/lance.png"));
		}
		
		ImageIcon i = new ImageIcon("source/img/templateKoma.png");

		if(s.equals("one")){
			i = new ImageIcon("source/img/lancePromotedFinal.png");
		}
		else if(s.equals("two")){
			i = new ImageIcon("source/img/lancePromotedFinal2.png");
		}
		setImageIcon2(i);
	}
	
	public void promoteToGold(){
		if(getCanPromote()){
			setIsPromoted(true);
		}
	}


}
