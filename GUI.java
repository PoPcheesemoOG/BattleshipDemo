/* Name: Paul Helske
 * Date: 06/15/2023
 */
package exercise;

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
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("BATTLESHIP DEMO");
		Pane pane = new Pane();

		Battleship tBoat = new Battleship("Torpedo Boat", 2, 'A', 0);
		Battleship destroyer = new Battleship("Destroyer", 4, 'A', 0);
		Battleship corvette = new Battleship("Corvette", 3, 'A', 0);
		Battleship frigate = new Battleship("Frigate", 4, 'A', 0);
		Battleship dreadnought = new Battleship("Dreadnought", 5, 'A', 0);

		GridPane map = new GridPane();

		Circle BS = new Circle(0, 0, 10);
		BS.setFill(Color.RED);

		map.add(BS, 0, 0);

		Text[] maprows = new Text[10];
		for (int i = 0; i < 10; i++) {
			maprows[i] = new Text("  " + (i+1) + "  ");
			map.add(maprows[i], 0, i + 1);
		}
		Text[] mapcols = new Text[10];
		for (int i = 0; i < 10; i++) {
			char q = (char) (65 + i);
			mapcols[i] = new Text("  " + q + "  ");
			map.add(mapcols[i], i + 1, 0);
		}


		Rectangle[][] rects = new Rectangle[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				rects[i][j] = Square();
			}

		}
		for(int i = 1; i < 11; i ++) {
			for(int j = 1; j < 11; j++) {
				map.add(rects[i-1][j-1], i, j);
			}
		}
		for(int i = 1; i < 11; i ++) {
			for(int j = 1; j < 11; j++) {
				rects[i - 1][j - 1].setOnMousePressed(e -> {
					// Fire at this coordinate
					System.out.println("BINGO at " + maprows.toString() + mapcols.toString());
				});
			}
		}


		map.setHgap(3);
		map.setVgap(3);

		pane.getChildren().addAll(map);
		Scene scene = new Scene(pane, 400, 420);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static Text mapindex() {
		Text txt = new Text();

		return txt;
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

	public static void main(String[] args) {
		launch (args);

	}

}
