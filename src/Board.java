import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int SPAN = 8;
    private Tile[][] tiles;
    private Tile selected;
    private HashMap<String, ImageIcon> images;

    public Board() {
        super();
        GridLayout grid = new GridLayout(SPAN, SPAN);        
        this.setLayout(grid);

        this.tiles = new Tile[SPAN][SPAN];
        this.selected = null;

        for (int row = 0; row < SPAN; row++) {
            for (int col = 0; col < SPAN; col++) {
                Tile tile = new Tile(row, col);
                tile.addActionListener(e -> {
                    if (e.getSource() instanceof Tile) {
                        selected = (Tile) e.getSource();
                        update();
                        if (selected != null && selected.getPiece() != null) {
                            for (Position move : selected.getPiece().validMoves(this)) {
                                tiles[move.getRow()][move.getCol()].setBackground(Color.GREEN);
                            }
                        }
                    }
                });
                tiles[row][col] = tile;
                this.add(tile);
            }
        }
        loadImages();
        resetBoard();
        update();
    }

    public void loadImages() {
        images = new HashMap<>();
        try {
            Image img = ImageIO.read(getClass().getResource("img/PawnW.png"));
            images.put("PawnW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/PawnB.png"));
            images.put("PawnB", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/BishopW.png"));
            images.put("BishopW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/BishopB.png"));
            images.put("BishopB", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/KnightW.png"));
            images.put("KnightW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/KnightB.png"));
            images.put("KnightB", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/RookW.png"));
            images.put("RookW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/RookB.png"));
            images.put("RookB", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/QueenW.png"));
            images.put("QueenW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/QueenB.png"));
            images.put("QueenB", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/KingW.png"));
            images.put("KingW", new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("img/KingB.png"));
            images.put("KingB", new ImageIcon(img));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetBoard() {
        // pawns
        for (int i = 0; i < 8; i++) {
            tiles[6][i].setIcon(images.get("PawnW"));
            tiles[1][i].setIcon(images.get("PawnB"));
        }
        // rooks
        tiles[7][0].setIcon(images.get("RookW"));
        tiles[7][7].setIcon(images.get("RookW"));
        tiles[0][0].setIcon(images.get("RookB"));
        tiles[0][7].setIcon(images.get("RookB"));
        // knights
        tiles[7][1].setIcon(images.get("KnightW"));
        tiles[7][1].setPiece(new Knight(new Position(7, 1), Team.WHITE));
        tiles[7][6].setIcon(images.get("KnightW"));
        tiles[0][1].setIcon(images.get("KnightB"));
        tiles[0][6].setIcon(images.get("KnightB"));
        // bishops
        tiles[7][2].setIcon(images.get("BishopW"));
        tiles[7][5].setIcon(images.get("BishopW"));
        tiles[0][2].setIcon(images.get("BishopB"));
        tiles[0][5].setIcon(images.get("BishopB"));
        // Queen
        tiles[7][3].setIcon(images.get("QueenW"));
        tiles[0][3].setIcon(images.get("QueenB"));
        // King
        tiles[7][4].setIcon(images.get("KingW"));
        tiles[0][4].setIcon(images.get("KingB"));
    }

    private void update() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.update(tile == selected);
            }
        }
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public ImageIcon getImage(String key) {
        return images.get(key);
    }
}