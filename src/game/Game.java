package game;

import game.pieces.King;
import game.pieces.Piece;
import game.util.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

public class Game implements ActionListener {
    private static Team currentPlayer;
    private static JLabel banner;
    private JPanel sideBar;
    private Piece selected;
    private Board board;

    protected static King whiteKing = new King(Team.WHITE);
    protected static King blackKing = new King(Team.BLACK);
    public static int count = 0;


    public Game()
    {
        JFrame frame = new JFrame("Best Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(860, 750);
        board = Board.getInstance();
        board.setPreferredSize(new Dimension(640,680));
        sideBar = new SideBar();

        JPanel ui = new JPanel();
        ui.setBackground(Color.WHITE);
        ui.setLayout(new GridBagLayout());

        banner = new JLabel("", SwingConstants.CENTER);
        banner.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        banner.setFont(new Font("Arial", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(640, 40));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        ui.add(banner,c);

        c.gridy = 1;
        ui.add(board,c);

        c.gridx = 5;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 5;
        ui.add(sideBar,c);
        
        frame.add(ui);
        frame.setVisible(true);
        frame.setResizable(false);

        selected = null;
        currentPlayer = null;
    }

    public void startNewGame() {
        currentPlayer = Team.WHITE;
        board.initializeBoard();
        addMoveListener();
        banner.setText((currentPlayer == Team.WHITE) ? "WHITE'S TURN" : "BLACK'S TURN");
    }

    public static Team getCurrentPlayer() {
        return currentPlayer;
    }

    public static void reset()
    {
        currentPlayer = Team.WHITE;
        banner.setText("WHITE'S TURN");
    }
    
    private void addMoveListener() {
        for (Tile[] row : board.getTiles()) {
            for (Tile tile : row) {
                tile.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Tile) {
            Tile tile = (Tile) e.getSource();

            // First check if any piece is currently selected otherwise update selected piece
            if (selected != null)
            {
                Piece piece = tile.getPiece();
                if (selected == piece) return;

                final Set<Position> possibleMoves = selected.getValidPositions();

                if(isInCheck(currentPlayer))
                {
                    /*
                    // make a move if player selects a valid tile otherwise update selected piece
                    if (possibleMoves.contains(tile.getPosition())) {
                        board.movePiece(new Move(selected.getPosition(), tile.getPosition()));
                        selected = null;
                        // change player
                        currentPlayer = (currentPlayer == Team.WHITE) ? Team.BLACK : Team.WHITE;
                        banner.setText((currentPlayer == Team.WHITE) ? "WHITE'S TURN" : "BLACK'S TURN");
                        // TODO check victory conditions
                        /////////////////
                        isInCheck(Team.WHITE);
                        isInCheck(Team.BLACK);
                        debugCheck();
                    } else {
                        if (tile.isEmpty()) return;
                        selected = (piece.getTeam() == currentPlayer) ? piece : null;
                        board.addSelectedBackground(tile);
                    }
                    */
                }
                else
                {
                    // make a move if player selects a valid tile otherwise update selected piece
                    if (possibleMoves.contains(tile.getPosition())) {
                        Move nextMove = new Move(selected.getPosition(), tile.getPosition());
                        //PastMove log = new PastMove(nextMove,board.getTile(selected.getPosition()).getPiece());
                        /////////

                        board.movePiece(nextMove);
                        selected = null;
                        // change player
                        currentPlayer = (currentPlayer == Team.WHITE) ? Team.BLACK : Team.WHITE;
                        banner.setText((currentPlayer == Team.WHITE) ? "WHITE'S TURN" : "BLACK'S TURN");
                        // TODO check victory conditions
                        /////////////////
                        isInCheck(Team.WHITE);
                        isInCheck(Team.BLACK);
                        debugCheck();
                    } else {
                        if (tile.isEmpty()) return;
                        selected = (piece.getTeam() == currentPlayer) ? piece : null;
                        board.addSelectedBackground(tile);
                    }
                }
            } else {
                if (tile.isEmpty()) return;
                selected = (tile.getPiece().getTeam() == currentPlayer) ? tile.getPiece() : null;
                board.addSelectedBackground(tile);
            }
        }
    }

    public static void switchPlayer()
    {
        currentPlayer = (currentPlayer == Team.WHITE) ? Team.BLACK : Team.WHITE;
        banner.setText((currentPlayer == Team.WHITE) ? "WHITE'S TURN" : "BLACK'S TURN");
    }

    //brute force
    public boolean isInCheck(Team team)
    {
        King king;
        if(team == Team.WHITE)
            king = whiteKing;
        else
            king = blackKing;

        king.newAttackList();

        Board board = Board.getInstance();

        Tile[][] tiles = board.getTiles();

        for(Tile[] arr : tiles)
        {
            for(Tile tile : arr)
            {
                if(tile.getPiece() != null && tile.getPiece().getTeam() != king.getTeam())
                {
                    Set<Position> attacks = tile.getPiece().getValidPositions();
                    Iterator iter = attacks.iterator();

                    while (iter.hasNext())
                    {
                        Position tileAttacked = (Position) iter.next();
                        if(tileAttacked.equals(king.getPosition()))
                        {
                            king.addAttacker(tile.getPiece());
                        }

                    }
                }

            }
        }
        return king.isInCheck();
    }

    public static String debugCheck()
    {
        /*
        String inCheck = "White: " + whiteKing.isInCheck() + " Black: " + blackKing.isInCheck();
        System.out.println("Check: " + count);
        System.out.println("White: " + whiteKing.isInCheck());
        System.out.println("Black: " + blackKing.isInCheck());
        ++count;

        return inCheck;
        */
        return "";
    }

    public static King getWhiteKing()
    {
        return whiteKing;
    }

    public static King getBlackKing()
    {
        return blackKing;
    }


    private static void checkForCheckMate()
    {
        /*
              Can I move out of mate?
              Can I block mate?
              Can I take the attacker?
         */

    }

}