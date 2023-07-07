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
	public Group group = new Group();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Creating stage
		primaryStage.setTitle("BATTLESHIP DEMO");
		
		GridPane map = new GridPane();
		Circle BS = new Circle(0, 0, 10);
		BS.setFill(Color.RED);
		
		// Creating Pane for losing
		Pane losePane = new Pane();
		// Creating Pane for winning
		Pane winPane = new Pane();

		map.add(BS, 0, 0);
		map.setHgap(3);
		map.setVgap(3);

		activeBoard = new gameBoard();
		GameBoard.instantiateGrid(map);
		Rectangle[][] rects = GameBoard.instantiateGridRects();
		GameBoard.addRectsToGrid(map, rects);
		
		int sceneH = activeBoard.height * 40;
		int sceneW = activeBoard.width * 40;
		Text loseText = new Text((sceneH / 2), (sceneW / 2), "You have lost\nCare to try again?");
		Text winText = new Text((sceneH / 2), (sceneW / 2), "You have won!!\nCongratlations!\nCare to try again?");
		group.getChildren().add(GameBoard.shotTracker);
		group.getChildren().add(GameBoard.hitTracker);
		group.getChildren().addAll(map);
		
		losePane.getChildren().add(loseText);
		winPane.getChildren().add(winText);
		
		Scene gameScene = new Scene(group, sceneH, sceneW);
		Scene loseScene = new Scene(losePane, sceneH, sceneW);
		Scene winScene = new Scene(winPane, sceneH, sceneW);
		primaryStage.setScene(gameScene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch (args);
	}
}
