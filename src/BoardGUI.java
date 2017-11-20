import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

public class BoardGUI {
	
	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private JToggleButton[][] shogiSquares = new JToggleButton[9][9];
	private JPanel repBoard;
	private JToggleButton messages;
	private final JLabel message = new JLabel("Ready Player One");
	private static final String columns = "ABCDEFGH";
	private Color squareColor;
	private Board board;
	private JToolBar toolBar;
	
	public BoardGUI(){
		board = new Board(9,9);
		initBoardGUI();
	}
	
	public void initBoardGUI(){
		squareColor = new Color(245, 201, 113);
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		toolBar = new JToolBar();
		gui.add(toolBar, BorderLayout.PAGE_START);
		toolBar.add(new JToggleButton("New Game"));
		toolBar.add(new JToggleButton("Previous Move"));
		toolBar.add(new JToggleButton("Connect To Server"));
		messages = new JToggleButton("Communications");
		toolBar.add(messages);
		toolBar.addSeparator();
		
		gui.add(new JLabel(), BorderLayout.LINE_START);
		
		repBoard = new JPanel(new GridLayout(0, 9));
		repBoard.setBorder(new LineBorder(Color.BLACK));
		gui.add(repBoard);
		
		Insets buttons = new Insets(0,0,0,0);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board.initGrid();
				Square[][] grid = board.getGrid();
				JToggleButton button = new JToggleButton();
				button.setBackground(squareColor);
				button.setMargin(buttons);
				if(grid[i][j].getPiece() == null){
					ImageIcon icon = new ImageIcon("source/img/ShogiSquare.png");
					button.setIcon(icon);
					shogiSquares[i][j] = button;
				}
				if(grid[i][j].getPiece() != null){
					ImageIcon icon = grid[i][j].getPiece().getImageIcon();
					button.setIcon(icon);
					button.addActionListener(new KomaListener(board.getPlayerOne().getTurn()));
					shogiSquares[i][j] = button;
				}
				
				
			}
		}
//		repBoard.add(new JLabel(""));
//		for(int i = 0; i < 9; i++){
//			repBoard.add(new JLabel(columns.substring(i, i + 1), SwingConstants.CENTER));
//		}
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				switch(j){
				case 0:
					repBoard.add(new JLabel("" + (i +1)), SwingConstants.CENTER);
				default:
					repBoard.add(shogiSquares[i][j]);
			}
		}
		
	}
	}
	
	public JToggleButton getMessages(){
		return messages;
	}
	public void setMessages(String m){
		messages.setText(m);;
	}
	
	public JComponent getRepBoard(){
		return repBoard;
	}
	
	public JComponent getGui(){
		return gui;
	}
	
	public JToolBar getToolBar(){
		return toolBar;
	}
	public void setToolBar(JToolBar j){
		toolBar = j;
	}
	
	public JToggleButton[][] getShogiSquares(){
		return shogiSquares;
	}
	public void setShogiSquares(JToggleButton[][] j){
		shogiSquares = j;
	}
	
	public void initNewGame(){
		
		board.initGrid();
		Square grid[][] = board.getGrid();
		
		board.printGrid();
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j].getPiece() == null)
					continue;
				if(grid[i][j].getPiece() != null){
					JToggleButton button = new JToggleButton();
					ImageIcon icon = grid[i][j].getPiece().getImageIcon();
					button.setIcon(icon);
					shogiSquares[i][j] = button;
				}
			}
			
		}
	}
	
	public Board getBoard() {
		return board;
	}
	
	public boolean makeTurn(){
		Square[][] grid = board.getGrid();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board.getPlayerOne().getTurn() == true){
					if(grid[i][j] != null && grid[i][j].getIsOccupied() && grid[i][j].getPiece().getPlayingUser().equals("two") && shogiSquares[i][j].isSelected()){
						System.out.println("This is not your piece");
						JLabel jL = new JLabel("This is not your piece");
						toolBar.add(jL);
						toolBar.addSeparator();
						return true;
					}
				}
			}
		}
		board.setGrid(grid);
		return false;
	}
	
	public void matchGrid() {
		Square [][] grid = board.getGrid();
		JToggleButton[][] shogiGrid = getShogiSquares();
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j].getPiece() == null) {
					ImageIcon empty = new ImageIcon("source/img/ShogiSquare.png");
					shogiGrid[i][j].setIcon(empty);
				}
				if(grid[i][j].getPiece() != null){
					JToggleButton button = shogiSquares[i][j];
					ImageIcon icon = grid[i][j].getPiece().getImageIcon();
					button.setIcon(icon);
					shogiSquares[i][j] = button;
				}
			}
			
		}
		setShogiSquares(shogiGrid);
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid.length; j++) {
//				if (grid[i][j] == null) {
//					ImageIcon icon = new ImageIcon("source/img/ShogiSquare.png");
//					shogiGrid[i][j].setIcon(icon);
//				}
//				else if(grid[i][j] != null){
//					System.out.println(grid[i][j].getPiece().getRef());
//					ImageIcon icon = grid[i][j].getPiece().getImageIcon();
//					shogiGrid[i][j].setIcon(icon);
//				}
//			}
//		}
	}

	public class KomaListener implements ActionListener {

		private boolean turn;
		
		public KomaListener(boolean b) {
			turn = b;
		}
        public void actionPerformed(ActionEvent e) {
        	Square[][] grid = board.getGrid();
        	JToggleButton[][] shogiGrid = getShogiSquares();
            JToggleButton button = (JToggleButton)e.getSource();
            
            for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid.length; c++) {
					if(e.getSource().isSelected()) {
					if (e.getSource() == shogiGrid[r][c]) {
						if (board.getPlayerOne().getTurn() == true && board.getPlayerTwo().getTurn() == false)
							setMessages("Player 1's turn");
						else
							setMessages("Player 2's turn");
						matchGrid();
						}
					}
					}
//            	for(int i = 0; i < grid.length; i++){
//            		for(int j = 0; j < grid.length; j++){
//            			if(shogiSquares[i][j] == button) {
//            				if(button.isSelected()) {
//            				Character piece = grid[i][j].getPiece().getRef();
//            				piece.equals('p');
//            				System.out.println("Pawn selected");
            			}
            		}
            	}
//           } if(!button.isSelected()) {
//              System.out.println("button not selected");
//           }
//}

public static void main(String[] args) {
    Runnable r = new Runnable() {

        @Override
        public void run() {
            BoardGUI bg = new BoardGUI();

            JFrame f = new JFrame("The General's Game");
            f.add(bg.getGui());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            // ensures the frame is the minimum size it needs to be
            // in order display the components within it
            f.pack();
            // ensures the minimum size is enforced.
            f.setMinimumSize(f.getSize());
            f.setVisible(true);
            bg.initNewGame();
            Board b = bg.getBoard();
            b.makeMove(8, 0, 7, 0, b.getPlayerOne());
            b.printGrid();
            bg.matchGrid();
        }
    };
    SwingUtilities.invokeLater(r);
}
}