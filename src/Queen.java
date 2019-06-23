import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Queen extends Peice
{
    public Queen(Team team)
    {
        this.team = team;

        String name  = (team == Team.WHITE) ? "img/QueenW.png" : "img/QueenB.png";

        Image img = null;
        try
        {
            img = ImageIO.read(getClass().getResource(name));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        this.icon = new ImageIcon(img);
    }


    @Override
    public ArrayList<Position> validMoves(Position position)
    {
        Board board = Board.getInstance();
        int currentRow = position.getRow();
        int currentCol = position.getCol();
        Team alliance = this.getTeam();

        ArrayList<Position> potentialPositions = new ArrayList<>();

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
