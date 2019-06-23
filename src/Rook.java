import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Peice
{

    public Rook(Team team)
    {
        this.team = team;

        String name  = (team == Team.WHITE) ? "img/RookW.png" : "img/RookB.png";

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
    public List<Position> validMoves(Position position)
    {
        Board board = Board.getInstance();
        int currentRow = position.getRow();
        int currentCol = position.getCol();
        Team alliance = this.getTeam();

        List<Position> potentialPositions = new ArrayList<>();

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
