package game;

import game.pieces.*;

import java.util.Stack;

public class PastMove
{
    public static Stack<String> pastMoves = new Stack<>();

    public PastMove(Move move, Piece defender)
    {
        String archive = "";
        archive += move.toString();

        if(defender != null)
        {
            if(defender instanceof Pawn)
                archive += " " + "Pawn";
            else if(defender instanceof Knight)
                archive += " " + "Knight";
            else if(defender instanceof Bishop)
                archive += " " + "Bishop";
            else if(defender instanceof Rook)
                archive += " " + "Rook";
            else if(defender instanceof Queen)
                archive += " " + "Queen";
            else if(defender instanceof King)
                archive += " " + "King";

            if(defender.getTeam() == Team.WHITE)
            {
                archive += " White";
            }
            else
            {
                archive += " Black";
            }
        }

        pastMoves.push(archive);
    }

    public PastMove(Move move)
    {
        this(move, null);
    }

    public static String getLastMove()
    {
        if(pastMoves.size() == 0)
            return null;

        return pastMoves.pop();
    }


    public static boolean isEmpty()
    {
        return pastMoves.isEmpty();
    }

    public static int numberOfMoves()
    {
        return pastMoves.size();
    }
}