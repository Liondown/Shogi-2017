import javax.swing.ImageIcon;

public class King extends Koma {
	
	public King(PlayingUser s){
		super(s, "King", false, false, true, 'k', 8, new ImageIcon("source/img/firstking.png"));
		addToTable(0, -1, -1);	
		addToTable(1, -1, 0);
		addToTable(2, -1, 1);
		addToTable(3, 0, -1);
		addToTable(4, 0, 1);
		addToTable(5, 1, -1);
		addToTable(6, 1, 0);
		addToTable(7, 1, 1);		
		
	}

}
