import java.util.ArrayList;
import java.util.List;

public class Queen extends Peice
{
    public Queen(Position position, Team team)
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

        //forward
        for(int i = currentCol + 1; i < 8; ++i)
        {
            if(board.getTile(currentRow, i).getPeice() == null)
            {
                potentialPositions.add(new Position(currentRow, i));
            }
            else
            {
                if(board.getTile(currentRow, i).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(currentRow, i));
                break;
            }
        }

        //Backwards
        for(int i = currentCol - 1; i >= 0; --i)
        {
            if(board.getTile(currentRow, i).getPeice() == null)
            {
                potentialPositions.add(new Position(currentRow, i));
            }
            else
            {
                if(board.getTile(currentRow, i).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(currentRow, i));
                break;
            }
        }

        //Right
        for(int i = currentRow + 1; i < 8; ++i)
        {
            if(board.getTile(i, currentCol).getPeice() == null)
            {
                potentialPositions.add(new Position(i, currentRow));
            }
            else
            {
                if(board.getTile(i, currentCol).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(i, currentCol));
                break;
            }
        }

        //Left
        for(int i = currentRow - 1; i >= 0; ++i)
        {
            if(board.getTile(i, currentCol).getPeice() == null)
            {
                potentialPositions.add(new Position(i, currentRow));
            }
            else
            {
                if(board.getTile(i, currentCol).getPeice().getTeam() != alliance)
                    potentialPositions.add(new Position(i, currentCol));
                break;
            }
        }

        return potentialPositions;
    }

}
