package game.pieces;

import game.Team;

public class Queen extends Piece {
    public Queen(Team team) {
        super(team);
        setIcon((team == Team.WHITE) ? "img/QueenW.png" : "img/QueenB.png");
    }


    @Override
    public void findValidPositions() {
        validPositions.clear();

        // Diaganol check/ same as bishop
        // up and to the Right
        validMovesHelper(-1, 1);
        // up and to the Left
        validMovesHelper(-1, -1);
        //down Left
        validMovesHelper(1, -1);
        //down Right
        validMovesHelper(1, 1);
        // up and to the Right

        // Up, Down & Left, Right check/ same as Rook
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
