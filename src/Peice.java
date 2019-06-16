import java.util.List;

public abstract class Peice
{
    protected Position position;

    protected Team team;

    public abstract List<Position> validMoves(Board board);

    public Position getPosition()
    {
        return position;
    }

    public Team getTeam()
    {
        return team;
    }
}
