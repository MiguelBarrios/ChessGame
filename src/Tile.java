import java.util.HashMap;

public class Tile
{
    private final Position position;

    private static HashMap<String, Tile> board;

    private Peice peice;

    public Tile(boolean occupied, Position position, Peice peice)
    {
        this.position = position;
        this.peice = peice;
    }

    public Tile(Position position)
    {
        this.position = position;
        this.peice = null;
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
