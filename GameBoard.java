
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameBoard {
	
	static int height = 10;
	static int width = 10;
	
	// Creating the boats
	Battleship tBoat = new Battleship(Battleship.ShipType.Torpedo_Boat, 2, 'A', 0);
	Battleship destroyer = new Battleship(Battleship.ShipType.Destroyer, 4, 'A', 0);
	Battleship corvette = new Battleship(Battleship.ShipType.Corvette, 3, 'A', 0);
	Battleship frigate = new Battleship(Battleship.ShipType.Frigate, 4, 'A', 0);
	Battleship dreadnought = new Battleship(Battleship.ShipType.Dreadnought, 5, 'A', 0);
	
	// Creating gameboard 
	public static void addRectsToGrid(GridPane map, Rectangle[][] rectsToAdd) {
		for(int i = 1; i < (height + 1); i ++) {
			for(int j = 1; j < (width + 1); j++) {
				map.add(rectsToAdd[i-1][j-1], i, j);
			}
		}
		for(int i = 1; i < (height + 1); i ++) {
			for(int j = 1; j < (width + 1); j++) {
				rectsToAdd[i - 1][j - 1].setOnMousePressed(e -> {
					// Fire at this coordinate
					System.out.println("BINGO at " + 10 + " " + 10);
				});
			}
		}
	}
	public static void instantiateGrid(GridPane map) {
		Text[] maprows = new Text[width];
		for (int i = 0; i < GameBoard.width; i++) {
			maprows[i] = new Text("  " + (i+1) + "  ");
			map.add(maprows[i], 0, i + 1);
		}
		Text[] mapcols = new Text[height];
		for (int i = 0; i < GameBoard.height; i++) {
			char rowName = (char) (65 + i);
			mapcols[i] = new Text("  " + rowName + "  ");
			map.add(mapcols[i], i + 1, 0);
		}
	}
	public static Rectangle Square() {
		Rectangle sq = new Rectangle();
		sq.setX(15);
		sq.setY(15);
		sq.setWidth(30);
		sq.setHeight(30);
		sq.setStroke(Color.DARKGRAY);
		sq.setFill(Color.AQUA);

		return sq;
	}
	public static Rectangle[][] instantiateGridRects() {
		Rectangle[][] rects = new Rectangle[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height; j++) {
				rects[i][j] = Square();
			}
		}
		return rects;
	}
	public static Text mapindex() {
		Text txt = new Text();

		return txt;
	}
}


