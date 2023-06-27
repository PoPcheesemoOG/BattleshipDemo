/* Name: Paul Helske
 * Date: 06/15/2023
 */
import java.util.ArrayList;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.GridPane;
import javafx.scene.*;
import javafx.scene.shape.*;



public class GUI extends Application {
	class gameBoard{
		public int width = 10;
		public int height = 10;
	}
	static gameBoard activeBoard; 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Creating stage
		primaryStage.setTitle("BATTLESHIP DEMO");
		Pane pane = new Pane();
		GridPane map = new GridPane();
		Circle BS = new Circle(0, 0, 10);
		BS.setFill(Color.RED);

		map.add(BS, 0, 0);
		map.setHgap(3);
		map.setVgap(3);
		
		activeBoard = new gameBoard();
		GameBoard.instantiateGrid(map);
		Rectangle[][] rects = GameBoard.instantiateGridRects();
		GameBoard.addRectsToGrid(map, rects);
		
		int sceneH = activeBoard.height * 40;
		int sceneW = activeBoard.width * 40;
		
		pane.getChildren().addAll(map);
		Scene scene = new Scene(pane, sceneH, sceneW);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch (args);
	}
}
