import javax.swing.ImageIcon;

public class Bishop extends Koma {
	
	public Bishop(PlayingUser s){
		super(s, "Bishop", true, false, true, 'b', 36, new ImageIcon("source/img/bishop.png"));
		
		int counter = 0;
		int minusX = 0;
		int minusY = 0;
		for(int i = 0; i < 9; i++) {
			addToTable(counter, i, i);
			counter++;
			minusY = (i *= -1);
			i *= -1;
			addToTable(counter, i, minusY);
			counter++;
			minusX = (i *= -1);
			i *= -1;
			addToTable(counter, minusX, i);
			counter++;
			minusX = (i *= -1);
			i *= -1;
			minusY = (i *= -1);
			i *= -1;
			addToTable(counter, minusX, minusY);
			counter++;
		}
		if(s.equals(PlayingUser.UPPER)){
			setImageIcon(new ImageIcon("source/img/bishop2.png"));
		}
	}
	
	public void promoteToGold(){
		if(getCanPromote() == true){
			setIsPromoted(true);
		}
	}

}
