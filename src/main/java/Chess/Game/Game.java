package Chess.Game;

import Chess.Board.Board;
import Chess.Board.Tile;
import Chess.Piece.Pawn;
import Chess.Piece.Piece;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashSet;


public class Game extends Application {

    private boolean turn;   //True = p1
                            //False = p2
    private Board board;

    private boolean onMove;
    private Tile holder;

    @Override
    public void init() {
        try {
            board = new Board();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        onMove = false;
        turn = true;

    }

    @Override
    public void start(Stage stage) throws Exception {
        AudioClip chessMove = new AudioClip(Paths.get("local/sound/chessSound.mp3").toUri().toString());
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setVgap(2);
        gridPane.setHgap(1);

        gridPane.getColumnConstraints().add(new ColumnConstraints(8));

        for(Tile tile : board.tiles) {

            gridPane.add(tile, tile.x, 9 - tile.y, 1, 1);

            if(!tile.isEmpty()) {
                tile.setGraphic(tile.getImage());
            } else {
                tile.setGraphic(null);
            }

            tile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(!onMove) {
                        Tile thisTile = (Tile) mouseEvent.getSource();
                        holder = thisTile;
                        for(Tile t : board.tiles) {
                            if(thisTile.legalMove(t, turn, board.tiles)) {
                                t.activate();
                            }
                        }
                        onMove = true;
                    } else {


                        for(Tile t : board.tiles) {
                            t.deactivate();
                        }

                        Tile thisTile = (Tile) mouseEvent.getSource();
                        if(holder.legalMove(thisTile, turn, board.tiles)) {
                            chessMove.play();
                            Piece piece = holder.getPiece();
                            holder.removePiece();
                            thisTile.setPiece(piece);
                            holder.setGraphic(null);
                            thisTile.setGraphic(thisTile.getImage());

                            turn = !turn;

                            if(board.lose(turn)) {

                                for(Tile tile : board.tiles) {
                                    tile.setDisable(true);
                                }

                            } else {
                                if (board.check(turn) != null) {
                                    board.check(turn).checker();
                                }
                            }

                        }
                        onMove = false;
                    }
                }
            });

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
