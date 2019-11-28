package Chess.Piece;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pawn implements Piece {

    public ImageView imageView;
    public boolean white;

    public Pawn(boolean white) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("local/images/pawn.png");
        Image image = new Image(input, 30, 30, false, false);
        this.imageView = new ImageView(image);
        this.imageView.setStyle("-fx-background-color:transparent;");
        this.white = white;
    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public ImageView getImage() {
        return imageView;
    }
}
