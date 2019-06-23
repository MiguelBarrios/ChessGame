import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Peice
{

    public Pawn(Team team)
    {
        this.team = team;

        String name  = (team == Team.WHITE) ? "img/PawnW.png" : "img/PawnB.png";

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

    public void isSelected()
    {
        System.out.println("Pawn was selected");
    }

    @Override
    public List<Position> validMoves(Position position)
    {
        Board board = Board.getInstance();
        int currentRow = position.getRow();
        int currentCol = position.getCol();
        Team alliance = this.getTeam();

        List<Position> potentialPositions = new ArrayList<>();

        int direction;

        if(this.getTeam() == Team.WHITE)
            direction = -1;
        else
            direction = 1;

        if(board.getTile(currentRow + direction, currentCol).getPeice() == null)
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
