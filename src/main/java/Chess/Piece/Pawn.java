package Chess.Piece;

import Chess.Board.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pawn implements Piece {

    private ImageView imageView;
    private boolean white;

    public final static int NO = 1;

    public Pawn(boolean white) throws FileNotFoundException {
        FileInputStream input;
        if(white) {
            input = new FileInputStream("local/images/pawnWhite1.png");
        } else {
            input = new FileInputStream("local/images/pawnBlack.png");
        }

        Image image = new Image(input, 30, 30, true, true);
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

        if(white) {
            if (dest.isEmpty() && origin.x == dest.x && origin.y + 1 == dest.y) {
                return true;
            }

            if (dest.isEnemy(white) && (origin.x - 1 == dest.x && origin.y + 1 == dest.y
                || origin.x + 1 == dest.x && origin.y + 1 == dest.y)) {
                return true;
            }

            if (dest.isEmpty() && origin.x == dest.x && origin.y == 2 && origin.y + 2 == dest.y
                    && tilesSet.get((origin.x - 1) * 8 + 2).isEmpty()) {
                return true;
            }

        } else {
            if (dest.isEmpty() && origin.x == dest.x && origin.y - 1 == dest.y) {
                return true;
            }

            if (!dest.isEmpty() && (origin.x - 1 == dest.x && origin.y - 1 == dest.y
                    || origin.x + 1 == dest.x && origin.y - 1 == dest.y)) {
                return true;
            }

            if (dest.isEmpty() && origin.x == dest.x && origin.y == 7 && origin.y - 2 == dest.y
                    && tilesSet.get((origin.x - 1) * 8 + 5).isEmpty()) {
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean getWhite() {
        return white;
    }

    @Override
    public int getVal() {
        return NO;
    }

}
