public class Move
{
    private Position potentialPosition;

    public Move(Position position)
    {
        this.potentialPosition = position;
    }

    public static void movePiece(Board board, Piece piece, Position newPosition)
    {
        //Moves piece to new Location
        board.getTile(newPosition.getRow(), newPosition.getCol()).setPiece(piece);

        //Clears pevious position
        board.getTile(piece.getPosition().getRow(), piece.getPosition().getCol()).setPiece(null);
    }
}
