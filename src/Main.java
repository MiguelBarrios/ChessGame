import javax.swing.JFrame;

public class Main
{

    public static Team currentPlayer = Team.WHITE;

    public static void main(String[] arg)
    {
        JFrame frame = new JFrame("Best Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        Board board = Board.getInstance();
        frame.add(board);
        frame.setVisible(true);
    }

    public static void startGame()
    {
        Team currentPlayer = Team.WHITE;


        while(true)
        {

        }
    }

    public static Team getCurrentPlayer()
    {
        return currentPlayer;
    }

    public static void swichPlayer()
    {
        if(currentPlayer == Team.WHITE)
            currentPlayer = Team.BLACK;
        else
            currentPlayer = Team.WHITE;
    }






}
