import java.awt.*;
import javax.swing.*;

public class BackgroundImageJFrame extends JFrame {
	
	public BackgroundImageJFrame(){
		setTitle("shogiBoard");
		setSize(500, 530);
		setPreferredSize(new Dimension(500, 50));
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon("source/img/shogi-japanese.png"));
	    add(background);
	    background.setLayout(new FlowLayout());
	    setSize(499,529);
	    setSize(500,530);
	    setResizable(false);
	}


public static void main(String[] args){
	
	BackgroundImageJFrame b = new BackgroundImageJFrame();

}
}
