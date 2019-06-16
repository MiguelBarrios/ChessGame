public class Move
{
    private Position potentialPosition;

    public Move(Position position)
    {
        this.potentialPosition = position;
    }

    public static void movePeice(Peice peice, Position newPosition)
    {
        //Moves peice to new Location
        Board.getTile(newPosition.getRow(), newPosition.getCol()).setPeice(peice);

        //Clears pevious position
        Board.getTile(peice.getPosition().getRow(), peice.getPosition().getCol()).setPeice(null);
    }
}
