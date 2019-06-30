package game.pieces;

import game.Board;
import game.Team;
import game.util.Position;

public class King extends Piece {
    public King(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/KingW.png" : "img/KingB.png");
    }

    @Override
    public void findValidPositions() {
        validPositions.clear();

        // up
        kingMoveHelper(-1, 0);
        // top right
        kingMoveHelper(-1, 1);
        // right
        kingMoveHelper(0, 1);
        // bottom right
        kingMoveHelper(1, 1);
        // bottom
        kingMoveHelper(1, 0);
        // bottom left
        kingMoveHelper(1, -1);
        // left
        kingMoveHelper(0, -1);
        // top left
        kingMoveHelper(-1, -1);
    }

    private void kingMoveHelper(int rowd, int cold) {
        Board board = Board.getInstance();
        int nextRow = pos.getRow() + rowd;
        int nextCol = pos.getCol() + cold;

        if (Board.withinBounds(nextRow, nextCol)) {
            if(board.getTile(nextRow, nextCol).isEmpty()) {
                validPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                validPositions.add(new Position(nextRow, nextCol));
            }
        }
    }
}
