package game.pieces;

import game.Team;

public class Bishop extends Piece {
    public Bishop(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/BishopW.png" : "img/BishopB.png");
    }

    @Override
    protected void findValidPositions() {
        validPositions.clear();
        // up and to the Right
        validMovesHelper(-1, 1);
        // up and to the Left
        validMovesHelper(-1, -1);
        //down Left
        validMovesHelper(1, -1);
        //down Right
        validMovesHelper(1, 1);
    }
}
