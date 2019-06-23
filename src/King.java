import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class King extends Piece
{
    public King(Team team)
    {
        this.team = team;

        String name  = (team == Team.WHITE) ? "img/KingW.png" : "img/KingB.png";

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
        System.out.println("King was selected");
    }

    @Override
    public ArrayList<Position> validMoves(Position position)
    {

        return null;
    }

}
