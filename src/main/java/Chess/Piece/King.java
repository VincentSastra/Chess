package Chess.Piece;

import Chess.Board.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class King implements Piece {

    private ImageView imageView;
    private boolean white;

    public King(boolean white) throws FileNotFoundException {

        FileInputStream input;
        if(white) {
            input = new FileInputStream("local/images/kingWhite1.png");
        } else {
            input = new FileInputStream("local/images/kingBlack.png");
        }

        Image image = new Image(input, 40, 40, true, true);
        this.imageView = new ImageView(image);
        this.imageView.setStyle("-fx-background-color:transparent;");
        this.white = white;
    }

    @Override
    public ImageView getImage() {
        return imageView;
    }

    @Override
    public boolean legalMove(Tile origin, Tile dest, ArrayList<Tile> tilesSet) {
        if(dest.isEnemy(!white) || origin.x == dest.x && origin.y == dest.y) {
            return false;
        }

        if(Math.abs(dest.x - origin.x) < 2 && Math.abs(dest.y - origin.y) < 2)
            return true;

        return false;
    }

    @Override
    public boolean getWhite() {
        return white;
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
