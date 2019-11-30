package Chess.Piece;

import Chess.Board.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Knight implements Piece {

    private ImageView imageView;
    private boolean white;

    public Knight(boolean white) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("local/images/knight.png");
        Image image = new Image(input, 30, 30, false, false);
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
        if(!dest.isEnemy(!white) && (
                (origin.x + 2 == dest.x && origin.y + 1 == dest.y)
                || (origin.x + 2 == dest.x && origin.y - 1 == dest.y)
                || (origin.x - 2 == dest.x && origin.y + 1 == dest.y)
                || (origin.x - 2 == dest.x && origin.y - 1 == dest.y)
                || (origin.x + 1 == dest.x && origin.y + 2 == dest.y)
                || (origin.x - 1 == dest.x && origin.y + 2 == dest.y)
                || (origin.x + 1 == dest.x && origin.y - 2 == dest.y)
                || (origin.x - 1 == dest.x && origin.y - 2 == dest.y)
        )) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getWhite() {
        return white;
    }
}
