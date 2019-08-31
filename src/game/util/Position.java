package game.util;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Position pos) {
        this.row = pos.row;
        this.col = pos.col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return row + " " + col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!Position.class.isAssignableFrom(obj.getClass())) return false;

        final Position pos = (Position) obj;
        
        return (this.row == pos.row && this.col == pos.col);
    }

    public int hashCode() {
        return this.toString().hashCode();
    }



}
