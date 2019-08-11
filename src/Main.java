import game.Game;

public class Main {

    public static Game game;

    public static void main(String[] arg)
    {
        startNewGame();
    }

    public static void startNewGame()
    {
        game = new Game();
        game.startNewGame();
    }

}