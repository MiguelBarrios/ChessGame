import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece
{
    @Override
    public List<Position> validMoves(Board board)
    {
        int currentRow = this.getPosition().getRow();
        int currentCol = this.getPosition().getCol();
        Team alliance = this.getTeam();

        List<Position> potentialPositions = new ArrayList<>();

        //forward
        for(int i = currentCol + 1; i < 8; ++i)
        {
            if(board.getTile(currentRow, i).getPiece() == null)
            {
                potentialPositions.add(new Position(currentRow, i));
            }
            else
            {
                if(board.getTile(currentRow, i).getPiece().getTeam() != alliance)
                    potentialPositions.add(new Position(currentRow, i));
                    break;
            }
        }

        //Backwards
        for(int i = currentCol - 1; i >= 0; --i)
        {
            if(board.getTile(currentRow, i).getPiece() == null)
            {
                potentialPositions.add(new Position(currentRow, i));
            }
            else
            {
                if(board.getTile(currentRow, i).getPiece().getTeam() != alliance)
                    potentialPositions.add(new Position(currentRow, i));
                break;
            }
        }

        //Right
        for(int i = currentRow + 1; i < 8; ++i)
        {
            if(board.getTile(i, currentCol).getPiece() == null)
            {
                potentialPositions.add(new Position(i, currentRow));
            }
            else
            {
                if(board.getTile(i, currentCol).getPiece().getTeam() != alliance)
                    potentialPositions.add(new Position(i, currentCol));
                break;
            }
        }





        //TODO:  ADD END OF BOARD PROMOTION


        return potentialPositions;
    }
}
