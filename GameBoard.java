
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameBoard {
	
	static int height = 10;
	static int width = 10;
	
	static String coordinates = "";
	
	//Two dimensional array of baord squares that
	
	static BoardSquare[][] board = new BoardSquare[height][width];
	
	
	// Creating the boats
	static Battleship tBoat = new Battleship(Battleship.ShipType.Torpedo_Boat, 1, 2, 1, 1);
	static Battleship destroyer = new Battleship(Battleship.ShipType.Destroyer, 3, 1, 3, 3);
	static Battleship corvette = new Battleship(Battleship.ShipType.Corvette, 1, 3, 5, 7);
	static Battleship frigate = new Battleship(Battleship.ShipType.Frigate, 4, 1, 4, 0);
	static Battleship dreadnought = new Battleship(Battleship.ShipType.Dreadnought, 1, 5, 7, 4);
	
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
		
		createBoard();
	}
	
	static void createBoard() {
		//int startX column
		//startY = row;
		//for loop that will go for the length of a piece;
		//board[newX][startY].state = filledHidden;
		
		//board[startX][newY] = filledHidden;
	}
	
	// Creating gameboard 
	public static void addRectsToGrid(GridPane map, Rectangle[][] rectsToAdd) {
		for(int i = 1; i < (height + 1); i ++) {
			for(int j = 1; j < (width + 1); j++) {
				map.add(rectsToAdd[i-1][j-1], i, j);
			}
		}
		for(int i = 1; i < (height + 1); i ++) {
			for(int j = 1; j < (width + 1); j++) {
				int row = i;
				int column = j;
				char rowName = (char) (64 + i);
				int colName = j;
				rectsToAdd[i - 1][j - 1].setOnMousePressed(e -> {
					// Fire at this coordinate
					coordinates = ("" + rowName + colName);
					System.out.println("Firing at " + coordinates + "...");
					
					//System.out.println("BINGO " + row + " " + column);
					
					if (checkForBoat(row, column) == true) {
						System.out.println("HIT!");
					} else
						System.out.println("MISS!");
				});
			}
		}
	}
	
	public static boolean checkForBoat(int row, int column) {
		if(board[row][column].state == BoardSquare.SquareState.HiddenBoatPiece) {
			return true;
		}
		else return false;
		
//		for (int i = 0; i < tBoat.size; i++) {
//			if (row == (tBoat.row + i) && column == tBoat.column) {
//				return true;
//			} else
//			return false;
//		}
//		return false;
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
			for(int j = 0; j < width; j++) {
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
