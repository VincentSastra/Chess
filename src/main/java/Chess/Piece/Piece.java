package Chess.Piece;

import Chess.Board.Tile;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public interface Piece {

    public ImageView getImage();

    public boolean legalMove(Tile origin, Tile dest, ArrayList<Tile> tilesSet);

    public boolean getWhite();
}
