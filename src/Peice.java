import java.util.List;

public abstract class Peice
{
    private Position position;

    private Team team;

    public abstract List<Move> validMoves(Board board);

    public Position getPosition()
    {
        return position;
    }

    public Team getTeam()
    {
        return team;
    }
}
