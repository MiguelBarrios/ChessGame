import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Position position, Team team) {
        this.position = position;
        this.team = team;
    }

    @Override
    public List<Position> validMoves(Board board) {
        List<Position> potentialPositions = new ArrayList<>();
        int currentRow = this.position.getRow();
        int currentCol = this.position.getCol();

        int nextRow = currentRow - 2;
        int nextCol = currentCol + 1;
        // Up: 2, Right: 1
        if (nextRow >= 0 && nextCol < 8) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Right: 2, Up: 1
        nextRow = currentRow - 1;
        nextCol = currentCol + 2;
        if (nextRow >= 0 && nextCol < 8) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Right: 2, Down: 1
        nextRow = currentRow + 1;
        nextCol = currentCol + 2;
        if (nextRow < 8 && nextCol < 8) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Down: 2, Right: 1
        nextRow = currentRow + 2;
        nextCol = currentCol + 1;
        if (nextRow < 8 && nextCol < 8) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Down: 2, Left: 1
        nextRow = currentRow + 2;
        nextCol = currentCol - 1;
        if (nextRow < 8 && nextCol >= 0) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Left: 2,  Down: 1
        nextRow = currentRow + 1;
        nextCol = currentCol - 2;
        if (nextRow < 8 && nextCol >= 0) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Left: 2, Up: 1
        nextRow = currentRow - 1;
        nextCol = currentCol - 2;
        if (nextRow >= 0 && nextCol >= 0) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        // Up: 2, Left: 1
        nextRow = currentRow - 2;
        nextCol = currentCol - 1;
        if (nextRow >= 0 && nextCol >= 0) {
            if (board.getTile(nextRow, nextCol).getPiece() == null) {
                potentialPositions.add(new Position(nextRow, nextCol));
            } else if (board.getTile(nextRow, nextCol).getPiece().getTeam() != team) {
                potentialPositions.add(new Position(nextRow, nextCol));
            }
        }
        return potentialPositions;
    }
}