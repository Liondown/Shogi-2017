import javax.swing.*;
public class GoldGeneral extends Koma {
	
	public GoldGeneral(PlayingUser s){
		super(s, "Gold General", false, true, true, 'g', 6, new ImageIcon("source/img/ggeneral2.png"));
		if(s.equals(PlayingUser.UPPER)){
			addToTable(0, 1, 0);	
			addToTable(1, 1, -1);
			addToTable(2, 1, 1);
			addToTable(3, -1, 0);
			addToTable(4, -1, -1);
			addToTable(5, -1, 1);
		}
		else if(s.equals(PlayingUser.LOWER)){
			addToTable(0, -1, -1);	
			addToTable(1, -1, 0);	
			addToTable(2, -1, 1);	
			addToTable(3, 0, -1);	
			addToTable(4, 1, -1);	
			addToTable(5, 0, 1);	
			setImageIcon(new ImageIcon("source/img/ggeneral.png"));
		}
	}

}
