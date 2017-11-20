import javax.swing.ImageIcon;

public class Knight extends Koma {
	
	public Knight(PlayingUser s){
		super(s, "Knight", true, false, true, 'h', 2, new ImageIcon("source/img/knight2.png"));
		if(s.equals(PlayingUser.UPPER)){
			addToTable(0, 2, -1);
			addToTable(1, 2, 1);
		}
		else if(s.equals(PlayingUser.LOWER)){
			addToTable(0, -2, -1);
			addToTable(1, -2, 1);
			setImageIcon(new ImageIcon("source/img/knight.png"));
		}
		ImageIcon i = new ImageIcon("source/img/templateKoma.png");
		
		if(s.equals("one")){
			i = new ImageIcon("source/img/knightPromotedFinal2.png");
		}
		else if(s.equals("two")){
			i = new ImageIcon("source/img/knightPromotedFinal.png");
		}
		setImageIcon2(i);
		
	}
	
	public void promoteToGold(){
			if(getCanPromote()){
				setIsPromoted(true);
			}
		}
	}
