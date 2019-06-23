import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Peice
{
    public Bishop(Team team)
    {
        this.team = team;

        String name  = (team == Team.WHITE) ? "img/BishopW.png" : "img/BishopB.png";

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
