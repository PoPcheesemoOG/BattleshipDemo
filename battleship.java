
public class battleship {
	
	private String name = "";
	private int size = 0;
	private char row = 'A';
	private int col = 0;
	
	public battleship(String name, int size, char row, int col) {
		this.name = name;
		this.size = size;
		this.row = row;
		this.col = col;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return this.size;
	}
	public void setName(int size) {
		this.size = size;
	}
	public char getRow() {
		return this.row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	public int geCol() {
		return this.col;
	}
	public void setCol(int col) {
		this.col = col;
	}

}
