import java.util.ArrayList;
import java.util.List;

public class Pawn extends Peice
{

    @Override
    public List<Move> validMoves(Board board)
    {
        if(this.getTeam() == Team.WHITE)
        {
            List<Position> potentialMoves = new ArrayList<Position>();

            Position currentPostion = this.getPosition();

            if(board.getTile(currentPostion.getRow() - 1, currentPostion.getCol()).getPeice() == null)
            {

            }


        }

        return null;
    }
}
