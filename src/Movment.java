public class Movment
{
    public static Tile lastSelectedPeice = null;

    public static Tile moveToTile = null;

    public static void setLastSelectedPeice(Tile tile)
    {
        lastSelectedPeice = tile;
    }

    public static void move(Tile tile)
    {
        if(lastSelectedPeice != null)
        {
            Board.getInstance().getTile(tile.getPosition()).setPiece(lastSelectedPeice.getPiece());
            Board.getInstance().getTile(lastSelectedPeice.getPosition()).setPiece(null);
            reset();
        }
    }

    public static void reset()
    {
        lastSelectedPeice = null;
        moveToTile = null;
    }
    public static boolean isReadyToMove()
    {
        return lastSelectedPeice != null;
    }
}
