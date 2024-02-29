package myfirstjavaprogram;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConsoleInterface
{
    private final TicTacToeGame Game;
    private final char[] Alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public ConsoleInterface(TicTacToeGame game)
    {
        Game = game;
    }

    public void RenderGame()
    {
        // TODO setup game char matrix rendering crap
        char[][] gameMatrix = Game.GetGameMatrix();

        System.out.println();
        char[][] printMatrix = new char[Game.GAME_EDGE_LENGTH * 2 + 1][Game.GAME_EDGE_LENGTH + 2];
        // First column render letters
        for (int y = 0; y < Game.GAME_EDGE_LENGTH + 2; y++)
            printMatrix[0][y] = y <= 1 ? Game.NO_CHAR : Alphabet[y - 2];

        // Render rest of columns
        for (int x = 0; x < printMatrix.length; x++)
        {
            for (int y = 0; y < printMatrix[y].length; y++)
            {
                switch (y)
                {
                case 0:
                    if (x % 2 == 1) // TODO fix this -----\/
                        printMatrix[x][y] = ((Integer) ((x + 2) / 2)).toString().charAt(0);
                    break;

                case 1:
                    printMatrix[x][y] = '-';
                    break;

                default:
                    printMatrix[x][y] = gameMatrix[(x + 2) / 2][y - 2];
                    break;
                }
            }
        }

        String finalOutput = "";
        System.out.println(finalOutput);
    }

    public String AskToFromConsoleGame(String msg)
    {
        RenderGame();

        System.out.println(msg);
        try
        {
            return new String(System.in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e)
        {
            // Do nothing bruh
            return null;
        }
    }

}
