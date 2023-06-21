/* Name: Paul Helske
 * Date: 06/15/2023
 */
package exercise;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.GridPane;


public class GUI extends Application {
	
	public static void main(String[] args) {
		launch (args);

	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Pane pane = new Pane();
		
		Battleship tBoat = new Battleship("Torpedo Boat", 2, 'A', 0);
		Battleship destroyer = new Battleship("Destroyer", 4, 'A', 0);
		Battleship corvette = new Battleship("Corvette", 3, 'A', 0);
		Battleship frigate = new Battleship("Frigate", 4, 'A', 0);
		Battleship dreadnought = new Battleship("Dreadnought", 5, 'A', 0);
		
		Grid map = new Grid(10, 10, 800, 800);
	}
	private class Grid extends Pane {
		int rows;
		int columns;
		
		double width;
		double height;
		
		Cell[][] cells;
		
		public Grid(int rows, int columns, double width, double height) {
			this.rows = rows;
			this.columns = columns;
			this.width = width;
			this.height = height;
			
			cells = new Cell[rows][columns];
		}
		
	}
}
