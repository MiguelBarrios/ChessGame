import game.Game;

public class Main {

    public static void main(String[] arg)
    {
        Game game = new Game();
        game.startNewGame();
    }

    public static void modify(int[] arr)
    {
        arr[0] = 999;
    }

    public class Test
    {
        int[] arr;

        public Test(int[] arr)
        {
            this.arr = arr;
        }

    }
}