package game;

import game.pieces.Piece;
import game.util.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Game implements ActionListener {
    private static Team currentPlayer;
    private JLabel banner;
    private JPanel sideBar;
    private Piece selected;
    Board board;

    public Game()
    {
        JFrame frame = new JFrame("Best Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 680);
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
            if (selected != null) {
                Piece piece = tile.getPiece();
                if (selected == piece) return;

                final Set<Position> possibleMoves = selected.getValidPositions();

                // make a move if player selects a valid tile otherwise update selected piece
                if (possibleMoves.contains(tile.getPosition())) {
                    board.movePiece(new Move(selected.getPosition(), tile.getPosition()));
                    selected = null;
                    // change player
                    currentPlayer = (currentPlayer == Team.WHITE) ? Team.BLACK : Team.WHITE;
                    banner.setText((currentPlayer == Team.WHITE) ? "WHITE'S TURN" : "BLACK'S TURN");
                    // TODO check victory conditions
                } else {
                    if (tile.isEmpty()) return;
                    selected = (piece.getTeam() == currentPlayer) ? piece : null;
                    board.addSelectedBackground(tile);
                }
            } else {
                if (tile.isEmpty()) return;
                selected = (tile.getPiece().getTeam() == currentPlayer) ? tile.getPiece() : null;
                board.addSelectedBackground(tile);
            }
        }
    }
}