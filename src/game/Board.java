package game;

import game.pieces.*;
import game.util.Position;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public static Board board = new Board();
    private static final long serialVersionUID = 1L;
    private static final Color LIGHT_GREEN = new Color(208, 240, 192);
    private static final Color DARK_GREEN = new Color(152, 251, 152);
    private static final Color LIGHT_RED = new Color(255, 110, 110);
    private static final Color DARK_RED = new Color(252, 61, 51);
    private static final int SPAN = 8;
    private Tile[][] tiles;

    private Board() {
        super();
        GridLayout grid = new GridLayout(SPAN, SPAN);        
        this.setLayout(grid);

        this.tiles = new Tile[SPAN][SPAN];

        for (int row = 0; row < SPAN; row++) {
            for (int col = 0; col < SPAN; col++) {
                Tile tile = new Tile(row, col);
                tiles[row][col] = tile;
                this.add(tile);
            }
        }
        System.out.println("Board Created");
        resetBackground();
    }

    public void initializeBoard() {
        //Pawns
        for (int i = 0; i < SPAN; i++) {
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

        System.out.println("Board Initialized");
    }

    private void resetBackground() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.update();
            }
        }
    }

    public void addSelectedBackground(Tile tile) { 
        if (tile.isEmpty()) {
            return;
        }

        resetBackground();

        Piece selected = tile.getPiece();
        int row;
        int col;
        Color bg;

        if (selected.getTeam() == Team.WHITE) {
            tile.update(LIGHT_GREEN, DARK_GREEN);
        } else {
            tile.update(LIGHT_RED, DARK_RED);
        }

        for (Position p : selected.getValidPositions()) {
            row = p.getRow();
            col = p.getCol();
            if (selected.getTeam() == Team.WHITE) {
                bg = ((row + col) % 2 == 0) ? LIGHT_GREEN : DARK_GREEN;
            } else {
                bg = ((row + col) % 2 == 0) ? LIGHT_RED : DARK_RED;
            }
            tiles[row][col].setBackground(bg);
        }
    }

    public boolean movePiece(Move move) {
        Piece piece = tiles[move.getStart().getRow()][move.getStart().getCol()].removePiece();
        tiles[move.getEnd().getRow()][move.getEnd().getCol()].setPiece(piece);
        resetBackground();
        return true;
    }

    public static Board getInstance() {
        return board;
    }

    public static boolean withinBounds(int row, int col) {
        return row < SPAN && col < SPAN && row >= 0 && col >= 0;
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public Tile getTile(Position pos) {
        return tiles[pos.getRow()][pos.getCol()];
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
