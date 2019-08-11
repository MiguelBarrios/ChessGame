package game.pieces;

import game.Board;
import game.Team;
import game.util.Position;

public class Knight extends Piece {
    public Knight(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/KnightW.png" : "img/KnightB.png");
    }

    @Override
    public void findValidPositions() {
        validPositions.clear();
        // getting possible positions going clock-wise starting from the top        
        // Up 2, Right 1
        knightMoveHelper(-2, 1);
        // Up 1, Right 2
        knightMoveHelper(-1, 2);
        // Down 1, Right 2
        knightMoveHelper(1, 2);
        // Down 2, Right 1
        knightMoveHelper(2, 1);
        // Down 2, Left 1
        knightMoveHelper(2, -1);
        // Down 1, Left 2
        knightMoveHelper(1, -2);
        // Up 1, Left 2
        knightMoveHelper(-1, -2);
        // Up: 2, Left: 1
        knightMoveHelper(-2, -1);
    }

    private void knightMoveHelper(int rowd, int cold) {
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
