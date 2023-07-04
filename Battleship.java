/* Name: Paul Helske
 * Date: 06/20/23
 */



public class Battleship {
	public enum ShipType {Torpedo_Boat, Destroyer, Corvette, Frigate, Dreadnought};
	
	public String name = "";
	public int rowsize = 0;
	public int colsize = 0;
	public int row = 0;
	public int column = 0;
	
	public Battleship (ShipType shipType, int rowsize, int colsize) {
		this.rowsize = rowsize;
		this.colsize = colsize;	
	}
	
	public boolean setPosition(int row, int column) {
		this.row = row;
		this.column = column;
		return fillGameBoard();
	}
	public boolean positionPiece(int row, int column) {
		//if we were able to place the piece successfully, return true;
		//else return false if we couldn't place the piece in the board;
		return true;
	}
	
	private boolean fillGameBoard(){
		// GameBoard.board[row][column].setState(BoardSquare.SquareState.Hidden_Boat_Piece);
		// System.out.println(rowsize + " " + colsize + " " + row + " " + column);
		for(int i = 0; i < colsize; i++) {
			//if spot is already taken, get out of the loop, remove all of your current pieces you've
			//tried to put down
			//Then, make GameBoard give you a new row and column to work with
			if(GameBoard.board[column + i][row].state != BoardSquare.SquareState.Water) {
				return false;
			}
			GameBoard.board[column + i][row].setState(BoardSquare.SquareState.Hidden_Boat_Piece);
		}
		for(int i = 0; i < rowsize; i++) {
			if(GameBoard.board[column][row + i].state != BoardSquare.SquareState.Water) {
				return false;
			}
			GameBoard.board[column][row + i].setState(BoardSquare.SquareState.Hidden_Boat_Piece);
		}
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
