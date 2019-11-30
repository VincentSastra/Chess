package Chess.Board;

import Chess.Piece.King;
import Chess.Piece.Pawn;
import Chess.Piece.Piece;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

public class Tile extends Button {

    public final int x;
    public final int y;

    public boolean fill;
    private Piece piece = null;

    public Tile(int x, int y) {

        this.fill = false;
        this.x = x;
        this.y = y;
        this.deactivate();
        this.setPrefHeight(60);
        this.setPrefWidth(60);
    }



    public String getLoc() {
        return "" + x + y;
    }

    public boolean isEmpty() {
        return !fill;
    }

    public boolean isEnemy(boolean white) {
        if(isEmpty()) {
            return false;
        }
        return piece.getWhite() != white;
    }

    public boolean legalMove(Tile tile, boolean turn, ArrayList<Tile> tileSet) {
        if(this.isEmpty() || turn != piece.getWhite()) {
            return false;
        }

        if(piece.legalMove(this, tile, tileSet)) {
            return true;
        }

        return false;
    }

    public void activate() {
        this.setStyle(
                "-fx-background-radius: 0;" +
                        "-fx-background-color: #EE7600;");
    }

    public void deactivate() {
        if ((x + y) % 2 == 0) {
            this.setStyle(
                    "-fx-background-radius: 0;" +
                            "-fx-background-color: #ebc8b2;");
        } else {
            this.setStyle(
                    "-fx-background-radius: 0;" +
                            "-fx-background-color: #8C92AC ;");
        }
    }

    public void checker() {
        System.out.println("turning red");
        this.setStyle(
                "-fx-background-radius: 0;" +
                        "-fx-background-color: #DC143C ;");
    }

    public void setPiece(Piece piece) {
        this.fill = true;
        this.piece = piece;
    }

    public void removePiece() {
        this.fill = false;
    }

    public ImageView getImage() {
        return this.piece.getImage();
    }

    public Piece getPiece() {
        return this.piece;
    }

}
