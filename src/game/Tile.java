package game;

import game.pieces.Piece;
import game.util.Position;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton {
    private static final long serialVersionUID = 1L;
    private Position pos;
    private Piece piece;

    public Tile(Position pos, Piece piece) {
        super();
        this.pos = pos;
        this.piece = piece;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setOpaque(true);
    }

    public Tile(int row, int col)  {
        this(new Position(row, col), null);
    }

    public Tile(Position pos) {
        this(pos, null);
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        setIcon(piece.getImageIcon());
        piece.updatePosition(pos.getRow(), pos.getCol());
    }

    public Piece removePiece() {
        Piece removed = piece;
        this.piece = null;
        setIcon(null);
        return removed;
    }

    public Position getPosition() {
        return pos;
    }

    public void update() {
        setBackground(((pos.getRow() + pos.getCol()) % 2 == 0) ? Color.WHITE : Color.GRAY);
    }

    public void update(Color light, Color dark) {
        setBackground(((pos.getRow() + pos.getCol()) % 2 == 0) ? light : dark);
    }
}
