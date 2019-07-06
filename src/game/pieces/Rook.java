package game.pieces;

import game.Team;

public class Rook extends Piece {
    public Rook(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/RookW.png" : "img/RookB.png");
    }

    @Override
    public void findValidPositions() {
        validPositions.clear();
        // Up
        validMovesHelper(-1, 0);
        // Down
        validMovesHelper(1, 0);
        // Right
        validMovesHelper(0, 1);
        // Left
        validMovesHelper(0, -1);
    }
}
