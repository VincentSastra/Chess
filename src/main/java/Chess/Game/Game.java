package Chess.Game;

import Chess.Board.Board;
import Chess.Board.Tile;
import Chess.Piece.Pawn;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Game extends Application {

    private boolean turn;   //True = p1
                            //False = p2
    private Board board;

    @Override
    public void init() {
        try {
            board = new Board();
        } catch (FileNotFoundException e) {

        }
    }

    @Override
    public void start(Stage stage) throws Exception {


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setVgap(1);
        gridPane.setHgap(1);

        gridPane.getColumnConstraints().add(new ColumnConstraints(8));

        for(Tile tile : board.tiles) {
            gridPane.add(tile, 9 - tile.y, 9 - tile.x, 1, 1);

            if(!tile.isEmpty()) {
                tile.setGraphic(tile.getImage());
            } else {
                tile.setGraphic(null);
            }

        }

        Scene scene = new Scene(gridPane, 800, 800);
        stage.setTitle("Chess Game");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String args[]){
        launch(args);
    }

}
