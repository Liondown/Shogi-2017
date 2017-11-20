
public class TraversalLegalMove {
	
	private byte diagonal;
	private byte revDiagonal;
	private byte horizontal;
	private byte vertical;
	
	public TraversalLegalMove(byte d, byte rD, byte h, byte v){
		this.diagonal = d;
		this.revDiagonal = rD;
		this.horizontal = h;
		this.vertical = v;
	}
	
	public void setDiagonal(byte d){
		diagonal = d;
	}
	
	public byte getDiagonal(){
		return diagonal;
	}
	
	public void setRevDiagonal(byte rD){
		revDiagonal = rD;
	}
	
	public byte getRevDiagonal(){
		return revDiagonal;
	}
	
	public void setHorizontal(byte h){
		horizontal = h;
	}
	
	public byte getHorizontal(){
		return horizontal;
	}
	
	public void setVertical(byte v){
		vertical = v;
	}
	
	public byte getVertical(){
		return vertical;
	}

}
