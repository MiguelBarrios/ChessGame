import java.util.HashMap;

public class Tile
{
    private boolean occupied;

    private final Position position;

    private static HashMap<Position, Tile> board;

    private Peice peice;

    public Tile(boolean occupied, Position position, Peice peice)
    {
        this.occupied = occupied;
        this.position = position;
        this.peice = peice;
    }

    public Tile(Position position)
    {
        this.occupied = false;
        this.position = position;
        this.peice = null;
    }

    private Tile(){ position = null; }

    private static HashMap<Position, Tile>  createBoard()
    {
        //TODO:
        return null;
    }

    public boolean isOcupied()
    {
        return occupied;
    }

    public boolean isOccupied()
    {
        return occupied;
    }

    public void setOccupied(boolean occupied)
    {
        this.occupied = occupied;
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
