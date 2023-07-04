import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameBoard {

	static int height = 10;
	static int width = 10;

	static String coordinates = "";

	//Two dimensional array of board squares that

	static BoardSquare[][] board = new BoardSquare[height + 1][width + 1];


	// Creating the boats
	static Battleship tBoat;
	static Battleship destroyer;
	static Battleship corvette;
	static Battleship frigate;
	static Battleship dreadnought;

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
	public static void checkPos() {

	}
	//	public static void createXY() {
	//		int tboatX = ((int) (Math.random() * 9) + 1);
	//		int tboatY = ((int) (Math.random() * 8) + 1);
	//		int destroyerX = ((int) (Math.random() * 7) + 1);
	//		int destroyerY = ((int) (Math.random() * 9) + 1);
	//		int corvetteX = ((int) (Math.random() * 9) + 1);
	//		int corvetteY = ((int) (Math.random() * 6) + 1);
	//		int frigateX = ((int) (Math.random() * 5) + 1);
	//		int frigateY = ((int) (Math.random() * 9) + 1);
	//		int dreadnoughtX = ((int) (Math.random() * 9) + 1);
	//		int dreadnoughtY = ((int) (Math.random() * 4) + 1);
	//		tBoat = new Battleship(Battleship.ShipType.Torpedo_Boat, 1, 2, tboatX, tboatY);
	//		destroyer = new Battleship(Battleship.ShipType.Destroyer, 3, 1, destroyerX, destroyerY);
	//		corvette = new Battleship(Battleship.ShipType.Corvette, 1, 3, corvetteX, corvetteY);
	//		frigate = new Battleship(Battleship.ShipType.Frigate, 4, 1, frigateX, frigateY);
	//		dreadnought = new Battleship(Battleship.ShipType.Dreadnought, 1, 5, dreadnoughtX, dreadnoughtY);
	//	}
	public static void initializeBoard() {
		int tboatX = ((int) (Math.random() * 9) + 1);
		int tboatY = ((int) (Math.random() * 8) + 1);

		int destroyerX = ((int) (Math.random() * 7) + 1);
		int destroyerY = ((int) (Math.random() * 9) + 1);

		int corvetteX = ((int) (Math.random() * 9) + 1);
		int corvetteY = ((int) (Math.random() * 6) + 1);

		int frigateX = ((int) (Math.random() * 5) + 1);
		int frigateY = ((int) (Math.random() * 9) + 1);


		int dreadnoughtX = ((int) (Math.random() * 9) + 1);
		int dreadnoughtY = ((int) (Math.random() * 4) + 1);

		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				board[x][y] = new BoardSquare(BoardSquare.SquareState.Water, x, y);
			}
		}
		tBoat = new Battleship(Battleship.ShipType.Torpedo_Boat, 1, 2);
		if(tBoat.setPosition(tboatX, tboatY) == false) {
			//Regenerate the position
			//	while (tBoat.setPosition(tboatX, tboatY) == false) {
			tboatX = ((int) (Math.random() * 9) + 1);
			tboatY = ((int) (Math.random() * 8) + 1);
			//		}
			//try to set the position again;
		}
		//		destroyer = new Battleship(Battleship.ShipType.Destroyer, 3, 1, destroyerX, destroyerY);
		destroyer = new Battleship(Battleship.ShipType.Destroyer, 1, 2);
		if(destroyer.setPosition(destroyerX, destroyerY) == false) {
			//Regenerate the position
			//		while (destroyer.setPosition(destroyerX, destroyerY) == false) {
			destroyerX = ((int) (Math.random() * 9) + 1);
			destroyerY = ((int) (Math.random() * 8) + 1);
			//		}
			//try to set the position again;
		}
		//		corvette = new Battleship(Battleship.ShipType.Corvette, 1, 3, corvetteX, corvetteY);
		corvette = new Battleship(Battleship.ShipType.Corvette, 1, 2);
		if(corvette.setPosition(corvetteX, corvetteY) == false) {
			//Regenerate the position
			//		while (corvette.setPosition(corvetteX, corvetteY) == false) {
			corvetteX = ((int) (Math.random() * 9) + 1);
			corvetteY = ((int) (Math.random() * 8) + 1);
			//		}
			//try to set the position again;
		} 
		//		frigate = new Battleship(Battleship.ShipType.Frigate, 4, 1, frigateX, frigateY);
		frigate = new Battleship(Battleship.ShipType.Frigate, 1, 2);
		if(frigate.setPosition(frigateX, frigateY) == false) {
			//Regenerate the position
			//		while (corvette.setPosition(corvetteX, corvetteY) == false) {
			frigateX = ((int) (Math.random() * 9) + 1);
			frigateY = ((int) (Math.random() * 8) + 1);
			//		}
			//try to set the position again;
		} 
		//		dreadnought = new Battleship(Battleship.ShipType.Dreadnought, 1, 5, dreadnoughtX, dreadnoughtY);
		dreadnought = new Battleship(Battleship.ShipType.Dreadnought, 1, 2);
		if(dreadnought.setPosition(dreadnoughtX, dreadnoughtY) == false) {
			//Regenerate the position
			//		while (corvette.setPosition(corvetteX, corvetteY) == false) {
			dreadnoughtX = ((int) (Math.random() * 9) + 1);
			dreadnoughtY = ((int) (Math.random() * 8) + 1);
			//		}
			//try to set the position again;
		}
		System.out.println("tBoat: " + tboatX + " " + tboatY);
		System.out.println("Destroyer: " + destroyerX + " " + destroyerY);
		System.out.println("Corvette: " + corvetteX + " " + corvetteY);
		System.out.println("Frigate: " + frigateX + " " + frigateY);
		System.out.println("Dreadnought: " + dreadnoughtX + " " + dreadnoughtY);
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

	public static void addRectsToGrid(GridPane map, Rectangle[][] rectsToAdd) {
		initializeBoard();
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
					System.out.println("Your hit landed in " + board[row][column].state);

					if (board[row][column].state == BoardSquare.SquareState.Water) {
						System.out.println("You missed!");
						rectsToAdd[row - 1][column - 1].setFill(Color.DARKBLUE);
					} else if (board[row][column].state == BoardSquare.SquareState.Hidden_Boat_Piece) {
						System.out.println("It's a HIT!!!");
						board[row][column].setState(BoardSquare.SquareState.Exposed_Boat_Piece);
						rectsToAdd[row - 1][column - 1].setFill(Color.RED);
						//		System.out.println("You hit a " + Battleship.ShipType);
					}
				});
			}
		}
	}

	public static boolean checkForBoat(int row, int column) {
		if(board[row][column].state == BoardSquare.SquareState.Hidden_Boat_Piece) {
			return true;
		}
		else return false;
	}
} 
