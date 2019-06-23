import javax.swing.*;
import java.awt.*;



public class Board extends JPanel {

    public static Board board = new Board();

    private static final long serialVersionUID = 1L;
    private static final int SPAN = 8;
    private Tile[][] tiles;
    private Tile selected;

    private Board() {
        super();
        GridLayout grid = new GridLayout(SPAN, SPAN);        
        this.setLayout(grid);

        this.tiles = new Tile[SPAN][SPAN];
        this.selected = null;

        for (int row = 0; row < SPAN; row++) {
            for (int col = 0; col < SPAN; col++) {
                Tile tile = new Tile(row, col);
                tile.update(false);
                tiles[row][col] = tile;
                this.add(tile);
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
        	tiles[1][i].setPiece(new Pawn(Team.BLACK));
        	tiles[6][i].setPiece(new Pawn(Team.WHITE));
        }

        // rooks
        tiles[7][0].setPiece(new Rook(Team.WHITE));
        tiles[7][7].setPiece(new Rook(Team.WHITE));
        tiles[0][0].setPiece(new Rook(Team.BLACK));
        tiles[0][7].setPiece(new Rook(Team.BLACK));

        // knights
        tiles[7][1].setPiece(new Knight(Team.WHITE));
        tiles[7][6].setPiece(new Knight(Team.WHITE));
        tiles[0][1].setPiece(new Knight(Team.BLACK));
        tiles[0][6].setPiece(new Knight(Team.BLACK));

        // bishops
        tiles[7][2].setPiece(new Bishop(Team.WHITE));
        tiles[7][5].setPiece(new Bishop(Team.WHITE));
        tiles[0][2].setPiece(new Bishop(Team.BLACK));
        tiles[0][5].setPiece(new Bishop(Team.BLACK));

        // Queen
        tiles[7][3].setPiece(new Queen(Team.WHITE));
        tiles[0][3].setPiece(new Queen(Team.BLACK));

        //King
        tiles[0][4].setPiece(new King(Team.BLACK));
        tiles[7][4].setPiece(new King(Team.WHITE));
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public Tile getTile(Position pos)
    {
        return tiles[pos.getRow()][pos.getCol()];
    }



}