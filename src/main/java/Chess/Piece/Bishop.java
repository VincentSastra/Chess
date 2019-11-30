package Chess.Piece;

import Chess.Board.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Bishop implements Piece{

    private ImageView imageView;
    private boolean white;

    public Bishop(boolean white) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("local/images/bishop.png");
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
        if(dest.isEnemy(!white) || origin.x == dest.x && origin.y == dest.y) {
            return false;
        }

        if(origin.x + origin.y == dest.x + dest.y) {
            if(origin.y < dest.y) {
                int x = dest.x + 1;
                int y = dest.y - 1;
                while(origin.x != x) {
                    if(!tilesSet.get((x - 1) * 8 + y - 1).isEmpty())
                        return false;
                    x++;
                    y--;
                }
                return true;
            } else {
                int x = dest.x - 1;
                int y = dest.y + 1;
                while(origin.x != x) {
                    if(!tilesSet.get((x - 1) * 8 + y - 1).isEmpty())
                        return false;
                    x--;
                    y++;
                }
                return true;
            }
        } else if(origin.x - origin.y == dest.x - dest.y){
            if(origin.y < dest.y) {
                int x = dest.x - 1;
                int y = dest.y - 1;
                while(origin.x != x) {
                    if(!tilesSet.get((x - 1) * 8 + y - 1).isEmpty())
                        return false;
                    x--;
                    y--;
                }
                return true;
            } else {
                int x = dest.x + 1;
                int y = dest.y + 1;
                while(origin.x != x) {
                    if(!tilesSet.get((x - 1) * 8 + y - 1).isEmpty())
                        return false;
                    x++;
                    y++;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean getWhite() {
        return white;
    }
}
