/* Name: Paul Helske
 * Date: 06/20/23
 */



public class Battleship {
	public enum ShipType {Torpedo_Boat, Destroyer, Corvette, Frigate, Dreadnought};
	
	public String name = "";
	public static int rowsize = 0;
	public static int colsize = 0;
	public int row = 0;
	public int column = 0;
	
	public Battleship (ShipType shipType, int rowsize, int colsize, int row, int col) {
		this.row = row;
		this.column = col;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void setRowSize(int newSize) {
		rowsize = newSize;
	}
	public static int getRowSize() {
		return rowsize;
	}
	public static void setColSize(int newSize) {
		colsize = newSize;
	}
	public static int getColSize() {
		return colsize;
	}
	
	public int getRow() {
		return this.row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return this.column;
	}
	public void setCol(int col) {
		this.column = col;
	}

}
