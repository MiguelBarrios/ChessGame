import javax.swing.JFrame;

public class Main
{
    public static void main(String[] arg)
    {
        JFrame frame = new JFrame("Best Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        Board board = new Board();
        frame.add(board);
        frame.setVisible(true);
    }
}
