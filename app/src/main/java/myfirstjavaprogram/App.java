/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myfirstjavaprogram;

import java.util.Random;

public class App
{
    public static App Instance;

    // It will be a console based game of Tic Tac Toe
    public static void main(String[] args)
    {
        if (Instance == null)
            Instance = new App();

        // Start game, do turn loop until win condition met
        TicTacToeGame currGame = new TicTacToeGame();
        TicTacToePlayerType[] players = TicTacToePlayerType.values();
        boolean currSelPlayer = new Random().nextBoolean();

        // System.out.println(String.format("Player %s gets to start first!",
        // players[currSelPlayer ? 0 : 1]));
        try
        {
            Thread.sleep(2);
        } catch (Exception e)
        {
        } // Literally a Java moment

        do
        {
            // Determine current player, render gamwe
            TicTacToePlayerType currPlayer = players[currSelPlayer ? 0 : 1];
            currGame._consoleInterface.RenderGame();

            String turnResponse = currGame._consoleInterface
                    .AskToFromConsoleGame(String.format("Player %s coord?: ", currPlayer));

            // Check validity, then parse input coordinates
            // TODO implement coord parsing
            Vector2 inputCoord = currGame.ParseCoord(turnResponse);
            if (inputCoord == null)
            {
                // Ask again
            }

            currSelPlayer = !currSelPlayer;
        } while (!currGame.CheckForWinCondition());
    }
}