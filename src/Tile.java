import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Tile extends JButton implements ActionListener
{
    private Position position;
    private static HashMap<Position, Tile> board;
    private Peice peice;
    private boolean isSelected = true;


    public Tile(Position position, Peice peice)
    {
        super();
        Color bg = ((position.getRow() + position.getCol()) % 2 == 0) ? Color.WHITE : Color.GRAY;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBackground(bg);
        this.setOpaque(true);
        this.position = position;
        this.peice = peice;
        //this.isSelected = false;
        this.addActionListener(this);
    }

    public Tile(int row, int col, Peice peice)
    {
        this(new Position(row, col), peice);
    }

    public Tile(int row, int col)
    {
        this(row, col, null);
    }

    private Tile()
    {
        position = null;
    }

    private static HashMap<Position, Tile> createBoard()
    {
        //TODO:
        return null;
    }

    public Peice getPeice()
    {
        return peice;
    }

    public void setPeice(Peice peice)
    {
        this.peice = peice;
        update();
    }

    public Position getPosition()
    {
        return position;
    }

    public void update()
    {
        if(this.peice != null)
            this.setIcon(this.peice.icon);
        else
            this.setIcon(null);
    }

    public Team getTeam()
    {
        return this.peice.team;
    }

    public void actionPerformed(ActionEvent event)
    {
        System.out.println(position + " selected");

        if(this.isSelected && Movment.isReadyToMove())
        {
            System.out.println("reached");
            Movment.move(this);
        }

        if(this.peice != null)
        {
            Movment.setLastSelectedPeice(this);
        }

    }


}















