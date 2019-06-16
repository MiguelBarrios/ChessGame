public class Move
{
    private Position potentialPosition;

    public Move(Position position)
    {
        this.potentialPosition = position;
    }

    public static void movePeice(Board board, Peice peice, Position newPosition)
    {
        //Moves peice to new Location
        board.getTile(newPosition.getRow(), newPosition.getCol()).setPeice(peice);

        //Clears pevious position
        board.getTile(peice.getPosition().getRow(), peice.getPosition().getCol()).setPeice(null);
    }
}
