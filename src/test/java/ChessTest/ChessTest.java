package ChessTest;

import Chess.Board.Tile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessTest {

    @Test
    public void test1() {
        assertEquals(1, 1);
    }
    @Test
    public void TileTest() {
        Tile tile = new Tile(1, 1);
        assertEquals("11", tile.getLoc());
    }


}
