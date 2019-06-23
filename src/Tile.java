import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tile extends JButton implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private Position position;

    private static HashMap<Position, Tile> board;
    private Piece piece;
    private boolean isSelected;


    public Tile(Position position, Piece piece) {
        super();
        this.position = position;
        this.piece = piece;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setOpaque(true);
        this.isSelected = false;
        this.addActionListener(this);
    }


    public Tile(int row, int col)
    {
        this(new Position(row, col), null);
    }

    private Tile()
    {
        position = null;
    }

    public Tile(Position position) {
        this(position, null);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
        update();
    }

    public void update(boolean selected) {
        if (selected) {
            this.setBackground(Color.CYAN);
        } else {
            this.setBackground(((position.getRow() + position.getCol()) % 2 == 0) ? Color.WHITE : Color.GRAY);
        }
    }

    public Position getPosition()
    {
        return position;
    }

    public void update()
    {
        if(this.piece != null)
            this.setIcon(this.piece.icon);
        else
            this.setIcon(null);
    }

    public Team getTeam()
    {
        return this.piece.team;
    }

    @Override
    public void setSelected(boolean selected)
    {
        isSelected = selected;
    }

    public void actionPerformed(ActionEvent event)
    {
        System.out.println(position + " selected");


        if(this.isSelected && Movment.isReadyToMove())
        {
            System.out.println("reached");
            Movment.move(this);
        }

        if(this.piece != null && this.piece.team == Main.getCurrentPlayer())
        {
            Board.getInstance().resetSelectedTiles();
            highlightSelectedTiles(this.getPiece().validMoves(this.position));
            Movment.setLastSelectedPeice(this);

        }

    }

    public void highlightSelectedTiles(List potentialMoves)
    {
        Board board = Board.getInstance();

        ArrayList<Position> list = new ArrayList<>(potentialMoves);

        for(Position pos : list)
        {
            int row = pos.getRow();
            int col = pos.getCol();

            board.getTile(row,col).setSelected(true);
        }
    }





}















