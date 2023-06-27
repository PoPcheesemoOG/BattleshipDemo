/* Name: Paul Helske
 * Date: 06/20/23
 */



public class Battleship {
	public enum ShipType {Torpedo_Boat, Destroyer, Corvette, Frigate, Dreadnought};
	
	private String name = "";
	private int size = 0;
	private int row = 0;
	private int column = 0;
	
	public Battleship (ShipType shipType, int size, int row, int col) {
		this.size = size;
		this.row = row;
		this.column = col;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSize(int newSize) {
		this.size = newSize;
	}
	public int getSize() {
		return this.size;
	}
	public void setName(int size) {
		this.size = size;
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
