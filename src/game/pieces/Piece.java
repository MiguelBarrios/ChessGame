package game.pieces;

// user imports
import game.Board;
import game.Team;
import game.util.Position;
// image imports
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.util.HashSet;
// other
import java.util.Set;

public abstract class Piece {
    protected Position pos;
    protected Team team;
    protected ImageIcon icon;
    protected Set<Position> validPositions;

    public Piece(Position pos, Team team) {
        this.pos = pos;
        this.team = team;
        this.validPositions = new HashSet<>();
    }

    public Piece(int row, int col, Team team) {
        this(new Position(row, col), team);
    }

    public Piece(Team team) {
        this(new Position(0, 0), team);
    }
    
    protected abstract void findValidPositions();

    protected void setIcon(String filepath) {
        try {
            Image img = ImageIO.read(getClass().getResource(filepath));
            this.icon = new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void validMovesHelper(int rowd, int cold) {
        Board board = Board.getInstance();
        for (int row = pos.getRow() + rowd,  col = pos.getCol() + cold; Board.withinBounds(row, col); row += rowd, col += cold) {
            if (board.getTile(row, col).isEmpty()) {
                validPositions.add(new Position(row, col));
            } else {
                if (board.getTile(row, col).getPiece().getTeam() != team) {
                    validPositions.add(new Position(row, col));
                }
                break;
            }
        }
    }

    public Team getTeam() {
        return team;
    }

    public Position getPosition() {
        return pos;
    }
    public ImageIcon getImageIcon() {
        return icon;
    }

    public void updatePosition(int row, int col) {
        if (pos == null) {
            pos = new Position(row, col);
            return;
        }

        if (pos.getRow() == row && pos.getCol() == col) return;

        this.pos.setRow(row);
        this.pos.setCol(col);
    }

    public Set<Position> getValidPositions() {
        findValidPositions();
        return new HashSet<Position>(validPositions);
    }
}
