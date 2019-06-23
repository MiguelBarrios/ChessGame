import javax.swing.*;
import java.util.List;


public abstract class Piece {
    protected Position position;
    protected Team team;

    protected ImageIcon icon;
    
    public abstract List<Position> validMoves(Position position);

    public Team getTeam()
    {
        return team;
    }
}
