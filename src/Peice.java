import java.util.List;

public abstract class Peice
{
    private Position position;

    private Team team;

    public abstract List<Move> validMoves(Board board);
}
