package Chess.Board;

import Chess.Piece.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Board {

    public ArrayList<Tile> tiles = new ArrayList<>();

    public Board(ArrayList<Tile> tiles) {
        this.tiles = new ArrayList<>(tiles);
    }

    public Board() throws FileNotFoundException {

        for(int i = 1; i <= 8; i++) {

            for(int j = 1; j <= 8; j++) {

                Tile tile = new Tile(i, j);

                if(j == 2) {
                    tile.setPiece(new Pawn(true));
                }

                if(j == 7) {
                    tile.setPiece(new Pawn(false));
                }

                if(j == 1) {
                    if(i == 2 || i == 7)
                        tile.setPiece(new Knight(true));

                    if(i == 3 || i == 6)
                        tile.setPiece(new Bishop(true));

                    if(i == 4)
                        tile.setPiece(new Queen(true));

                    if(i == 5)
                        tile.setPiece(new King(true));

                    if(i == 1 || i == 8)
                        tile.setPiece(new Rook(true));
                }

                if(j == 8) {
                    if(i == 2 || i == 7)
                        tile.setPiece(new Knight(false));

                    if(i == 3 || i == 6)
                        tile.setPiece(new Bishop(false));

                    if(i == 4)
                        tile.setPiece(new Queen(false));

                    if(i == 5)
                        tile.setPiece(new King(false));

                    if(i == 1 || i == 8)
                        tile.setPiece(new Rook(false));
                }

                tiles.add(tile);
            }

        }
    }

    public Tile check(boolean white) {
        Tile kingTile = null;
        for(Tile tile : tiles) {
            if(!tile.isEmpty() && tile.getPiece().getWhite() == white && tile.getPiece().getClass() == King.class) {
                kingTile = tile;
            }
        }

        for(Tile tile : tiles) {
            if(!tile.isEmpty() && tile.getPiece().legalMove(tile, kingTile, tiles)) {
                return tile;
            }
        }
        return null;
    }

    public boolean lose(boolean white) {
        for(Tile tile : tiles) {
            if(!tile.isEmpty() && tile.getPiece().getWhite() == white && tile.getPiece().getClass() == King.class) {
                return false;
            }
        }

        return true;

    }

}
