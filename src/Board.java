import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    public static Board board = new Board();

    private Tile[][] tiles;

    private Board() {
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

        initializeBoard();
    }

    public static Board getInstance()
    {
        return board;
    }

    public void initializeBoard()
    {
        //Pawns
        for (int i = 0; i < 8; i++)
        {
        	tiles[1][i].setPeice(new Pawn(Team.BLACK));
        	tiles[6][i].setPeice(new Pawn(Team.WHITE));
        }

        // rooks
        tiles[7][0].setPeice(new Rook(Team.WHITE));
        tiles[7][7].setPeice(new Rook(Team.WHITE));
        tiles[0][0].setPeice(new Rook(Team.BLACK));
        tiles[0][7].setPeice(new Rook(Team.BLACK));

        // knights
        tiles[7][1].setPeice(new Knight(Team.WHITE));
        tiles[7][6].setPeice(new Knight(Team.WHITE));
        tiles[0][1].setPeice(new Knight(Team.BLACK));
        tiles[0][6].setPeice(new Knight(Team.BLACK));

        // bishops
        tiles[7][2].setPeice(new Bishop(Team.WHITE));
        tiles[7][5].setPeice(new Bishop(Team.WHITE));
        tiles[0][2].setPeice(new Bishop(Team.BLACK));
        tiles[0][5].setPeice(new Bishop(Team.BLACK));

        // Queen
        tiles[7][3].setPeice(new Queen(Team.WHITE));
        tiles[0][3].setPeice(new Queen(Team.BLACK));

        //King
        tiles[0][4].setPeice(new King(Team.BLACK));
        tiles[7][4].setPeice(new King(Team.WHITE));
    }


    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public Tile getTile(Position pos)
    {
        return tiles[pos.getRow()][pos.getCol()];
    }

    public void hightLightPotentialMovment(ArrayList<Position> potentialMovment)
    {
        for(Position pos : potentialMovment)
        {
            int row = pos.getRow();
            int col = pos.getCol();
        }
    }

    public void clearLastSelected()
    {

    }
}