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
        moveToTile = tile;
        if(lastSelectedPeice != null && moveToTile != null)
        {
            Board board = Board.getInstance();

            Piece one = lastSelectedPeice.getPiece();

            int row = lastSelectedPeice.getPosition().getRow();
            int col = lastSelectedPeice.getPosition().getCol();

            board.getTile(row,col).setPiece(null);


            row = moveToTile.getPosition().getRow();
            col = moveToTile.getPosition().getCol();

            board.getTile(row, col).setPiece(one);

                        //End of board promotion for pawns
            if(tile.getPiece().name != null)
            {
                if(tile.getPiece().name.equals("Pawn") && tile.getPosition().getCol() == 0 || tile.getPosition().getCol() == 7)
                {
                    System.out.println("End of board Promotion activated");
                }
            }

            reset();
            Board.getInstance().resetSelectedTiles();
            Main.swichPlayer();
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
