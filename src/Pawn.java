import java.util.ArrayList;
import java.util.List;

public class Pawn extends Peice
{

    @Override
    public List<Position> validMoves(Board board)
    {
        int currentRow = this.getPosition().getRow();
        int currentCol = this.getPosition().getCol();
        Team alliance = this.getTeam();

        List<Position> potentialPositions = new ArrayList<>();

        int direction;

        if(this.getTeam() == Team.WHITE)
            direction = -1;
        else
            direction = 1;

        if(board.getTile(currentRow + direction, currentCol) == null)
            potentialPositions.add(new Position(currentRow + direction, currentCol));


        if(currentCol != 0 && currentRow != 0 && currentRow != 7)
        {
            //Attack upLeft and downLeft
            if(board.getTile(currentRow + direction, currentCol - 1).getPeice() != null && board.getTile(currentRow + direction, currentCol - 1).getPeice().getTeam() != alliance)
                potentialPositions.add(new Position(currentRow + direction, currentCol - 1));

            //Attack upRight and downRight
            if(board.getTile(currentRow + direction, currentCol + 1).getPeice() != null && board.getTile(currentRow + direction, currentCol + 1).getPeice().getTeam() != alliance)
                potentialPositions.add(new Position(currentRow + direction, currentCol + 1));
        }


        //TODO:  ADD END OF BOARD PROMOTION


        return potentialPositions;
    }
}
