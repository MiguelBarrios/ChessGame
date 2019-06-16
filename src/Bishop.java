import java.util.ArrayList;
import java.util.List;

public class Bishop extends Peice
{
    public Bishop(Position position, Team team)
    {
        this.position = position;

        this.team = team;
    }


    @Override
    public List<Position> validMoves(Board board)
    {
        int currentRow = this.position.getRow();
        int currentCol = this.position.getCol();
        Team alliance = this.getTeam();

        List<Position> potentialPositions = new ArrayList<>();

        // up and to the Right
        for(int row = currentRow - 1, col = currentCol + 1; row >= 0 && col < 8; --row, ++col)
        {
            if(board.getTile(row, col).getPeice() == null)
                potentialPositions.add(new Position(row, col));
            else
            {
                if(board.getTile(row, col).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(row, col));
                break;
            }
        }

        // up and to the Left
        for(int row = currentRow - 1, col = currentCol - 1; row >= 0 && col >= 0; --row, --col)
        {
            if(board.getTile(row, col).getPeice() == null)
                potentialPositions.add(new Position(row, col));
            else
            {
                if(board.getTile(row, col).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(row, col));
                break;
            }
        }

        //down Left
        for(int row = currentRow + 1, col = currentCol - 1; row < 8 && col >= 0; ++row, --col)
        {
            if(board.getTile(row, col).getPeice() == null)
                potentialPositions.add(new Position(row, col));
            else
            {
                if(board.getTile(row, col).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(row, col));
                break;
            }
        }

        //down Right
        for(int row = currentRow + 1, col = currentCol + 1; row < 8 && col < 8; ++row, ++col)
        {
            if(board.getTile(row, col).getPeice() == null)
                potentialPositions.add(new Position(row, col));
            else
            {
                if(board.getTile(row, col).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(row, col));
                break;
            }
        }
        return potentialPositions;
    }

}
