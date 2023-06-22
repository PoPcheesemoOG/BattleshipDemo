/* Name: Paul Helske
 * Date: 06/20/23
 */
package exercise;

public class Battleship {
	
	private String name = "";
	private int size = 0;
	private int row = 0;
	private int col = 0;
	
	public Battleship(String name, int size, int row, int col) {
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
	public int getRow() {
		return this.row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return this.col;
	}
	public void setCol(int col) {
		this.col = col;
	}

}
