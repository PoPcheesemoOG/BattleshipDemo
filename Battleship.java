/* Name: Paul Helske
 * Date: 06/20/23
 */

import java.util.ArrayList;
public class Battleship {
	public enum ShipType {Torpedo_Boat, Destroyer, Corvette, Frigate, Dreadnought};

	public String name = "";
	public int rowsize = 1;
	public int colsize = 1;
	public int row = 1;
	public int column = 1;

	public Battleship (ShipType shipType, String name, int rowsize, int colsize, int row, int column) {
		this.name = name;
		this.rowsize = rowsize;
		this.colsize = colsize;	
		this.row = row;
		this.column = column;
	}

	public boolean setPosition( int column, int row) {
		//	System.out.println(this.name + " " + this.rowsize + " " + this.colsize + " " + row + " " + column);
		this.row = row;
		this.column = column;
		return fillGameBoard();
	}
	public void setTBoatPos() {
		int tboatX = ((int) (Math.random() * 9) + 1);
		int tboatY = ((int) (Math.random() * 8) + 1);

		while (setPosition(tboatY, tboatX) == false) {
			//	System.out.println(name + " FAILED POSITIONING");
			tboatX = ((int) (Math.random() * 9) + 1);
			tboatY = ((int) (Math.random() * 8) + 1);
		}
	}
	public void setDestroyerPos() {
		int destroyerX = ((int) (Math.random() * 7) + 1);
		int destroyerY = ((int) (Math.random() * 9) + 1);

		while (setPosition(destroyerY, destroyerX) == false) {
			destroyerX = ((int) (Math.random() * 7) + 1);
			destroyerY = ((int) (Math.random() * 9) + 1);
			//	System.out.println(name + " FAILED POSITIONING");
		}
	}
	public void setCorvettePos() {
		int corvetteX = ((int) (Math.random() * 9) + 1);
		int corvetteY = ((int) (Math.random() * 6) + 1);

		while (setPosition(corvetteY, corvetteX) == false) {
			//		System.out.println(name + " FAILED POSITIONING");
			corvetteX = ((int) (Math.random() * 9) + 1);
			corvetteY = ((int) (Math.random() * 6) + 1);
		}
	}
	public void setFrigatePos() {
		int frigateX = ((int) (Math.random() * 5) + 1);
		int frigateY = ((int) (Math.random() * 9) + 1);

		while (setPosition(frigateY, frigateX) == false) {
			//	System.out.println(name + " FAILED POSITIONING");
			frigateX = ((int) (Math.random() * 5) + 1);
			frigateY = ((int) (Math.random() * 9) + 1);
		}
	}
	public void setDreadnoughtPos() {
		int dreadnoughtX = ((int) (Math.random() * 9) + 1);
		int dreadnoughtY = ((int) (Math.random() * 4) + 1);

		while (setPosition(dreadnoughtY, dreadnoughtX) == false) {
			System.out.println(name + " FAILED POSITIONING");
			dreadnoughtX = ((int) (Math.random() * 9) + 1);
			dreadnoughtY = ((int) (Math.random() * 4) + 1);
		}
	}
	public boolean fillGameBoard(){
		//	System.out.println("Filling board");
		ArrayList<BoardSquare> squaresToFill = new ArrayList<BoardSquare>();		
		if(!checkIfSpotIsFilled(row, column, squaresToFill)) return false;	
		//if square is not water, return false and try again.
		//Then, make GameBoard give you a new row and column to work with
		//	System.out.println("Checking columns " + this.colsize);
		for(int i = 1; i < this.colsize; i++) {
			if(!checkIfSpotIsFilled(row, column + i, squaresToFill)) return false;
		}
		//	System.out.println("Checking rows " + this.rowsize);
		for(int i = 1; i < this.rowsize; i++) {
			if(!checkIfSpotIsFilled(row + i, column, squaresToFill)) return false;
		}		
		for(int i = 0; i < squaresToFill.size(); i++) {
			squaresToFill.get(i).setState(BoardSquare.SquareState.Hidden_Boat_Piece);
		}
		return true;
	}	
	private boolean checkIfSpotIsFilled(int row, int column, ArrayList<BoardSquare> squaresToFill) {
		//	System.out.println("Checking " + GameBoard.board[column][row].state);
		if(GameBoard.board[column][row].state != BoardSquare.SquareState.Water) {
			//		System.out.println("FGB FAILED");
			return false;
		}
		squaresToFill.add(GameBoard.board[column][row]);
		return true;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRowSize(int newSize) {
		rowsize = newSize;
	}
	public int getRowSize() {
		return rowsize;
	}
	public void setColSize(int newSize) {
		colsize = newSize;
	}
	public int getColSize() {
		return colsize;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int newrow) {
		row = newrow;
	}
	public int getCol() {
		return column;
	}
	public void setCol(int col) {
		column = col;
	}
}
