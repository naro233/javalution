package pack;
// Final Project by Ryan Winter rw15e for COP3252 Spring 17 5-3-17
import java.awt.*;

public class Block extends Canvas {
	private static final long serialVersionUID = 1L;
	private Checker piece;
	//private int currentPlayer;
    private int row;
    private int col;
	public enum BoardColor { DARKBLOCK, LIGHTBLOCK, NULL }; 
	private BoardColor background; 
    private boolean taken; // if block is already taken
    private boolean available;
    public Block(BoardColor c, int r1, int c1) {
    	this.setSize(50, 50); // set size of the BoardBlock
    	this.row = r1;
    	this.col = c1;
    	background = c;
       
        if(c == BoardColor.DARKBLOCK)
    		this.setBackground(new Color(139,69,19)); // darker brown
    	else if(c == BoardColor.LIGHTBLOCK)
    		this.setBackground(new Color(244,164,96)); // light brown
    }
  
    public boolean isTaken() { 
        return this.taken;
    }

    public boolean isAvailable() { 
        return this.available;
    }
    
    public int getRow() {
    	return this.row;
    }
    
    public int getCol() {
    	return this.col;
    }
   // public int getCurrentPlayer(){
   // 	return currentPlayer;
   // }
    
    public Block.BoardColor getBoardColor() {
    	return this.background;
    }
    
    public Checker getPiece() {
    	return this.piece;	    
    }
    
    public void setChecker(Checker c) {
    	if(c == null) {
    		this.piece = null;
    		this.taken = false;	
    	}
    	else {
    		this.piece = c;
    		this.taken = true;	
    		//currentPlayer++;
    	}
    }
    public void drawAvailable() {

    	Graphics g = this.getGraphics();
		g.setColor(Color.YELLOW); 
   		//g.drawRect(0, 0, 48, 48); // draw green rectangle around selected block
   		g.drawOval(0, 0, 49, 49);
    }
    public void selectBlock() {
    	Graphics g = this.getGraphics();
	   	if(this.isTaken() == true) {	
	   		g.setColor(Color.WHITE); 
	   		//g.drawRect(0, 0, 48, 48); // draw black rectangle around available moves for selected block 
	   		g.drawOval(0, 0, 49, 49);
	   	} else if(this.isTaken() == false){
    		g.setColor(Color.GREEN); 
	   		//g.drawRect(0, 0, 48, 48); // draw green rectangle around selected block
	   		g.drawOval(0, 0, 49, 49);
    	}
    }
    public void clearBlock() { 
    	super.update(this.getGraphics()); // repaints in real time
    }

	public void paint(Graphics g) {
		if(this.getBoardColor() == Block.BoardColor.LIGHTBLOCK)
			this.setBackground(new Color(244,164,96)); // light brown
		else if(this.getBoardColor() == Block.BoardColor.DARKBLOCK)
			this.setBackground(new Color(139,69,19)); // darker brown
		if(this.isTaken() == true){
			g.setColor(piece.getColor()); 
			g.fillOval(5, 5, 41, 41);
		}	
	}   
}