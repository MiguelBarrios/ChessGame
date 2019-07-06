package game.pieces;

import game.Board;
import game.Team;
import game.util.Position;

public class Pawn extends Piece {
    private final int INITIAL_ROW_BLACK = 1;
    private final int INITIAL_ROW_WHITE = 6;
    private final int direction;

    public Pawn(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/PawnW.png" : "img/PawnB.png");
        direction = (team == Team.WHITE) ? -1 : 1;
    }

    @Override
    public void findValidPositions() {
        validPositions.clear();
        
        Board board = Board.getInstance();
        int currentRow = pos.getRow();
        int currentCol = pos.getCol();


        int nextRow = currentRow + direction;
        int nextCol = currentCol;

        if(Board.withinBounds(nextRow, nextCol) && board.getTile(nextRow, nextCol).isEmpty()) {
            validPositions.add(new Position(nextRow, nextCol));
        }

        if (currentRow == INITIAL_ROW_BLACK || currentRow == INITIAL_ROW_WHITE) {
            nextRow += direction;
            if(Board.withinBounds(nextRow, nextCol) && board.getTile(nextRow, nextCol).isEmpty()) {
                validPositions.add(new Position(nextRow, nextCol));
            }
        }


        if(currentCol != 0 && currentRow != 0 && currentRow != 7) {
            //Attack upLeft and downLeft
            nextRow = currentRow + direction;
            nextCol = currentCol - 1;

            if(Board.withinBounds(nextRow, nextCol) && !board.getTile(nextRow, nextCol).isEmpty() && board.getTile(nextRow, nextCol).getPiece().getTeam() != team)
                validPositions.add(new Position(nextRow, nextCol));

            //Attack upRight and downRight
            nextRow = currentRow + direction;
            nextCol = currentCol + 1;

            if(Board.withinBounds(nextRow, nextCol) && !board.getTile(nextRow, nextCol).isEmpty() && board.getTile(nextRow, nextCol).getPiece().getTeam() != team)
                validPositions.add(new Position(nextRow, nextCol));
        }
    }
}
