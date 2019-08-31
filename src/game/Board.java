package game;

import game.pieces.*;
import game.util.Position;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public static Board board = new Board();
    private static final long serialVersionUID = 1L;
    private static final Color LIGHT_YELLOW = new Color(229, 195, 50);
    private static final Color BURNT_ORANGE = new Color(222, 155, 42);

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

    public void resetBoard()
    {
        Game.reset();
        initializeBoard();
        for(int row = 2; row <= 5; ++row)
        {
            for(int col = 0; col < 8; ++col)
            {
                board.getTile(row,col).removePiece();
            }
        }
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
        tiles[0][4].setPiece(Game.getBlackKing());
        tiles[7][4].setPiece(Game.getWhiteKing());

        System.out.println("Board Initialized");
    }

    private void resetBackground() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.update();
            }
        }
    }

    public void addSelectedBackground(Tile tile)
    {
        if (tile.isEmpty())
        {
            return;
        }

        resetBackground();

        Piece selected = tile.getPiece();
        int row;
        int col;
        Color bg;

        if(selected.getTeam() == Game.getCurrentPlayer())
        {
            tile.update(LIGHT_YELLOW, BURNT_ORANGE);
        }

        for (Position p : selected.getValidPositions())
        {
            row = p.getRow();
            col = p.getCol();

            if(selected.getTeam() == Game.getCurrentPlayer())
            {
                bg = ((row + col) % 2 == 0) ? LIGHT_YELLOW : BURNT_ORANGE;
                tiles[row][col].setBackground(bg);
            }

        }
    }

    public boolean movePiece(Move move)
    {
        saveMove(move);
        int startRow = move.getStart().getRow();
        int startCol = move.getStart().getCol();
        int endRow = move.getEnd().getRow();
        int endCol = move.getEnd().getCol();

        Piece temp = tiles[startRow][startCol].getPiece();
        if(temp instanceof Pawn)
        {
            Piece defender = tiles[startRow][endCol].getPiece();
            if(defender instanceof Pawn && ((Pawn) defender).getEnPassantFlag() && defender.getTeam() != temp.getTeam())
            {
                tiles[startRow][endCol].removePiece();
            }
        }

        Piece piece = tiles[startRow][startCol].removePiece();
        tiles[endRow][endCol].setPiece(piece);

        if(piece instanceof Pawn)
        {
            if(endRow == 0 || endRow == 7)
                endOfBoardPromotion(move);

            Pawn pawn = (Pawn)tiles[endRow][endCol].getPiece();

            //remove en passant capture flag
            if(pawn.getEnPassantFlag())
                pawn.setEnPassantCapture(false);

            //set en passant capture flag
            if(Game.getCurrentPlayer() == Team.WHITE && startRow == 6 && endRow == 4 || Game.getCurrentPlayer() == Team.BLACK && startRow == 1 && endRow == 3)
                pawn.setEnPassantCapture(true);

        }

        resetBackground();
        return true;
    }

    public void undo(String lastMove)
    {
        String[] arr = lastMove.split(" ");
        int startrow = Integer.valueOf(arr[0]);
        int startcol = Integer.valueOf(arr[1]);
        int endrow = Integer.valueOf(arr[2]);
        int endcol = Integer.valueOf(arr[3]);

        Piece piece = tiles[endrow][endcol].getPiece();
        tiles[endrow][endcol].removePiece();
        tiles[startrow][startcol].setPiece(piece);

        if(arr.length == 6)
        {
            Piece defender = Piece.findPiece(arr[4], arr[5]);
            tiles[endrow][endcol].setPiece(defender);
        }

        Game.switchPlayer();
        resetBackground();
    }

    private void saveMove(Move move)
    {
        PastMove one;

        if(getTile(move.getEnd()).getPiece() == null)
        {
            one = new PastMove(move);
        }
        else
        {
            Piece piece = getTile(move.getEnd()).getPiece();
            one = new PastMove(move, piece);
        }

    }

    private void endOfBoardPromotion(Move move)
    {
        Piece newPiece;
        if(Game.getCurrentPlayer() == Team.WHITE)
            newPiece = new Queen(Team.WHITE);
        else
            newPiece = new Queen(Team.BLACK);

        tiles[move.getEnd().getRow()][move.getEnd().getCol()].setPiece(newPiece);
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
