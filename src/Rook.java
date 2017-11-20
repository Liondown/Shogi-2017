import javax.swing.ImageIcon;

public class Rook extends Koma {
	
	public Rook(PlayingUser s){
		super(s, "Rook", true, false, true, 'r', 36, new ImageIcon("source/img/rook.png"));
		int counter = 0;
		int minusX = 0;
		int minusY = 0;
			for(int i = 0; i < 9; i++) {
				addToTable(counter, i, 0);
				counter++;
				addToTable(counter, 0, i);
				counter++;
				minusY = (i *= -1);
				i *= -1;
				addToTable(counter, 0, minusY);
				counter++;
				minusX = (i *= -1);
				i *=-1;
				addToTable(counter, minusX, 0);
				counter++;
			}
			if(s == PlayingUser.UPPER) {
				setImageIcon(new ImageIcon("source/img/rook2.png"));
			}
		}
	
	public void promoteToGold(){
		if(getCanPromote() == true){
			setIsPromoted(true);
		}
	}

}
