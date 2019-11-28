package Chess.Board;

import Chess.Piece.Pawn;
import Chess.Piece.Piece;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class Board {

    public HashSet<Tile> tiles = new HashSet<>();

    public Board() throws FileNotFoundException {
        for(int i = 1; i <= 8; i++) {

            for(int j = 1; j <= 8; j++) {

                Tile tile = new Tile(i, j);

                if(i == 2 || i == 7) {
                    tile.setPiece(new Pawn());
                }

                tiles.add(tile);
            }

        }
    }

}
