import javax.swing.ImageIcon;

public class OpKing extends Koma {
	
	public OpKing(PlayingUser s){
		super(s, "Opponent King", false, false, true, 'k', 8, new ImageIcon("source/img/secondking.png"));
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
