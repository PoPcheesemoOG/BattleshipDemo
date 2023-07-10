/* Name: Paul Helske
 * Date: 06/20/23
 */
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.*;

public class GameBoard {

	static int height = 10;
	static int width = 10;

	static String coordinates = "";

	static Integer shotsRemaining = 15;
	static Integer shotsHit = 0;

	static Text shotTracker = new Text(10, ((width * 40) - 10), ("Shots remaining: " + shotsRemaining));
	static Text hitTracker = new Text(10, ((width * 40) - 20), ("Boat pieces hit: " + shotsHit));
	static Text infoText = new Text(130, ((width * 40) - 20), ("Targets hidden in water: Torpedo Boat: 2 Across\n"
			+ "Destroyer: 3 Down, Corvette: 3 Across\n"
			+ "Frigate: 4 Down, Dreadnought: 5 Across."));

	//Two dimensional array of board squares that

	static BoardSquare[][] board = new BoardSquare[height + 1][width + 1];

	// Methods for keeping track of shots
	static public int trackShots(int shotsRemaining) {
		shotsRemaining -= 1;
		return shotsRemaining;
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
	static int tboatX = ((int) (Math.random() * 9) + 1);
	static int tboatY = ((int) (Math.random() * 8) + 1);

	static int destroyerX = ((int) (Math.random() * 7) + 1);
	static int destroyerY = ((int) (Math.random() * 9) + 1);

	static int corvetteX = ((int) (Math.random() * 9) + 1);
	static int corvetteY = ((int) (Math.random() * 6) + 1);

	static int frigateX = ((int) (Math.random() * 5) + 1);
	static int frigateY = ((int) (Math.random() * 9) + 1);

	static int dreadnoughtX = ((int) (Math.random() * 9) + 1);
	static int dreadnoughtY = ((int) (Math.random() * 4) + 1);

	static Battleship tBoat = new Battleship(Battleship.ShipType.Torpedo_Boat, "Torpedo Boat", 1, 2, tboatX, tboatY);
	static Battleship destroyer = new Battleship(Battleship.ShipType.Destroyer, "Destroyer", 3, 1, destroyerX, destroyerY);
	static Battleship corvette = new Battleship(Battleship.ShipType.Corvette, "Corvette", 1, 3, corvetteX, corvetteY);
	static Battleship frigate = new Battleship(Battleship.ShipType.Frigate, "Frigate", 4, 1, frigateX, frigateY);
	static Battleship dreadnought = new Battleship(Battleship.ShipType.Dreadnought, "Dreadnought", 1, 5, dreadnoughtX, dreadnoughtY);

	static int sceneH = height * 40;
	static int sceneW = width * 40;

	static Text loseText = new Text((sceneH / 2 - 50), (sceneW / 2), "You have lost\nCare to try again?");
	static Text winText = new Text((sceneH / 2 - 50), (sceneW / 2), "You have won!!\nCongratlations!\nCare to try again?");

	// Creating Pane for losing
	public static VBox losePane = new VBox(32);

	// Creating Pane for winning
	public static VBox winPane = new VBox(32);

	static void addLoseText() {
		losePane.getChildren().addAll(loseText);
	}
	static void addWinText() {
		winPane.getChildren().addAll(winText);
	}
	static void addLoseButton() {
		Button tryAgain = new Button("TRY AGAIN");
		losePane.getChildren().add(tryAgain);
		tryAgain.setOnAction(e -> {
			GUI.getStage().close();
			Platform.runLater( () -> {
				try {
					GUI.group.getChildren().clear();

					shotsRemaining = 15;
					shotsHit = 0;
					shotTracker.setText("Shots remaining: " + shotsRemaining);
					hitTracker.setText("Boat pieces hit: " + shotsHit);
					new GUI().start( new Stage() );

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			losePane.getChildren().clear();

		});
	}
	static void addWinButton() {
		Button tryAgain = new Button("TRY AGAIN");
		winPane.getChildren().addAll(tryAgain);
		tryAgain.setOnAction(e -> {
			GUI.getStage().close();
			Platform.runLater( () -> {
				try {
					GUI.group.getChildren().clear();
					shotsRemaining = 15;
					shotsHit = 0;
					shotTracker.setText("Shots remaining: " + shotsRemaining);
					hitTracker.setText("Boat pieces hit: " + shotsHit);
					new GUI().start( new Stage() );

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			winPane.getChildren().clear();

		});
	}
	static Scene loseScene = new Scene(losePane, sceneH, sceneW);
	static Scene winScene = new Scene(winPane, sceneH, sceneW);
	public static void checkGameEnd(int shotsRemaining, int shotsHit) {

		if (shotsRemaining == 0 && shotsHit < 17) {			
			addLoseText();
			addLoseButton();
			GUI.getStage().setScene(loseScene);
		}
		else if (shotsHit == 17) {			
			addWinText();
			addWinButton();
			GUI.getStage().setScene(winScene);
		}
	}
	public static void initializeBoard() {
		// Debugging for the randomization
		//		System.out.println("1 tBoat: " + tBoat.row + " " + tBoat.column);
		//		System.out.println("1 Destroyer: " + destroyer.row + " " + destroyer.column);
		//		System.out.println("1 Corvette: " + corvette.row + " " + corvette.column);
		//		System.out.println("1 Frigate: " + frigate.row + " " + frigate.column);
		//		System.out.println("1 Dreadnought: " + dreadnought.row + " " + dreadnought.column);

		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				board[x][y] = new BoardSquare(BoardSquare.SquareState.Water, x, y);
			}
		}
		// Setting the boats on the board
		tBoat.setTBoatPos();
		destroyer.setDestroyerPos();
		corvette.setCorvettePos();
		frigate.setFrigatePos();
		dreadnought.setDreadnoughtPos();
		// Debugging to find boats on board
		//		System.out.println("tBoat: " + tBoat.row + " " + tBoat.column);
		//		System.out.println("Destroyer: " + destroyer.row + " " + destroyer.column);
		//		System.out.println("Corvette: " + corvette.row + " " + corvette.column);
		//		System.out.println("Frigate: " + frigate.row + " " + frigate.column);
		//		System.out.println("Dreadnought: " + dreadnought.row + " " + dreadnought.column);
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

					if (board[row][column].state == BoardSquare.SquareState.Water) {
						System.out.println("Your hit landed in water");
						System.out.println("You missed!");
						shotsRemaining--;
						shotTracker.setText("Shots remaining: " + shotsRemaining);

						rectsToAdd[row - 1][column - 1].setFill(Color.DARKBLUE);
						//	board[row][column].setState(BoardSquare.SquareState.Exposed_Boat_Piece);
					} else if (board[row][column].state == BoardSquare.SquareState.Hidden_Boat_Piece) {
						System.out.println("It's a HIT!!!");
						shotsRemaining++;
						shotsHit++;
						shotTracker.setText("Shots remaining: " + shotsRemaining);
						hitTracker.setText("Boat pieces hit: " + shotsHit);
						board[row][column].setState(BoardSquare.SquareState.Exposed_Boat_Piece);
						rectsToAdd[row - 1][column - 1].setFill(Color.RED);
					} else if (board[row][column].state == BoardSquare.SquareState.Exposed_Boat_Piece) {
						System.out.println("This square has already been hit.\nTry again!");
						shotTracker.setText("Shots remaining: " + shotsRemaining);
					}
					checkGameEnd(shotsRemaining, shotsHit);
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
