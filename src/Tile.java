import java.awt.Color;
import javax.swing.JButton;

public class Tile extends JButton {
    private static final long serialVersionUID = 1L;
    private final Position position;
    private Piece piece;

    public Tile(Position position, Piece piece) {
        super();
        this.position = position;
        this.piece = piece;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setOpaque(true);
    }

    public Tile(int row, int col) {
        this(new Position(row, col), null);
    }

    public Tile(Position position) {
        this(position, null);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void update(boolean selected) {
        if (selected) {
            this.setBackground(Color.CYAN);
        } else {
            this.setBackground(((position.getRow() + position.getCol()) % 2 == 0) ? Color.WHITE : Color.GRAY);
        }
    }
}
