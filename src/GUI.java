import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUI extends JFrame {

	private Board board;
	private BackgroundImageJFrame boardFrame;
	
	public GUI(Board b){
		board = b;
		}
	public void initPawns(){
		board.initGrid();

		boardFrame = new BackgroundImageJFrame();
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Square[][] grid = board.getGrid();
		ImageIcon icon = grid[0][0].getPiece().getImageIcon();
		JLabel label = new JLabel(icon);
		boardFrame.add(label, BorderLayout.CENTER);
		boardFrame.setVisible(true);

//			for (int i = 0; i < 9; i++) {
//				for (int j = 0; j < 9; j++) {
//					if (grid[i][j].getPiece() == null)
//						continue;
//					if(grid[i][j].getPiece() != null){
//						ImageIcon icon = grid[i][j].getPiece().getImageIcon();
//						JLabel label = new JLabel(icon);
//						boardFrame.add(label)
//						
//					}
//				}
//				System.out.println();
//			}
		}
	
	public static void main(String[] args){
		Board board = new Board(9,9);
		GUI g = new GUI(board);
		g.initPawns();
	}
	}
