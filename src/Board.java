import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private Tile[][] tiles;

    public Board() {
        super();
        GridLayout grid = new GridLayout(8, 8);
        this.setLayout(grid);
        tiles = new Tile[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                tiles[row][col] = new Tile(row, col);
                this.add(tiles[row][col]);
            }
        }
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }
}