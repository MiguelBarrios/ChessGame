import java.awt.Color;
import java.util.HashMap;
import javax.swing.JButton;

public class Tile extends JButton {
    private final Position position;
    private static HashMap<Position, Tile> board;
    private Peice peice;

    public Tile(Position position, Peice peice) {
        super();
        Color bg = ((position.getRow() + position.getCol()) % 2 == 0) ? Color.WHITE : Color.GRAY;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBackground(bg);
        this.position = position;
        this.peice = peice;
    }

    public Tile(int row, int col) {
        this(new Position(row, col), null);
    }

    public Tile(Position position)
    {
        this(position, null);
    }

    private Tile(){ position = null; }

    private static HashMap<Position, Tile>  createBoard()
    {
        //TODO:
        return null;
    }

    public Peice getPeice()
    {
        return peice;
    }

    public void setPeice(Peice peice)
    {
        this.peice = peice;
    }
}
