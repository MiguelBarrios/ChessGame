package game;

import game.util.Position;

public class Move {

    private final Position start;
    private final Position end;

    public Move (Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return new Position(start);
    }

    public Position getEnd() {
        return new Position(end);
    }

    public String toString()
    {
        return start.toString() + " " + end.toString();
    }
}
