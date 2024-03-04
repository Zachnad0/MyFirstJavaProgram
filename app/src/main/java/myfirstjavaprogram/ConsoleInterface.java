package myfirstjavaprogram;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConsoleInterface
{
    private final TicTacToeGame Game;
    private final char[] Alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    public ConsoleInterface(TicTacToeGame game)
    {
        Game = game;
    }

    public void RenderGame()
    {
        char[][] gameMatrix = Game.GetGameMatrix();

        System.out.println();
        char[][] printMatrix = new char[Game.GAME_EDGE_LENGTH * 2 + 1][Game.GAME_EDGE_LENGTH + 2];
        // First column render letters
        for (int y = 0; y < printMatrix[0].length; y++)
            printMatrix[0][y] = y <= 1 ? Game.NO_CHAR : Alphabet[y - 2];

        // Render rest of columns
        int xIndex = 1;
        for (int x = 1; xIndex <= Game.GAME_EDGE_LENGTH; x++) // For cols
        {
            for (int y = 0; y < printMatrix[y].length; y++) // For rows
            {
                if (x % 2 == 0)
                {
                    switch (y)
                    {
                    case 0:
                        printMatrix[x][y] = ((Integer) xIndex).toString().charAt(0);
                        xIndex++;
                        break;

                    case 1:
                        printMatrix[x][y] = '-';
                        break;

                    default:
                        printMatrix[x][y] = gameMatrix[xIndex - 2][y - 2];
                        break;
                    }
                } else
                    printMatrix[x][y] = y == 1 ? '-' : Game.NO_CHAR;
            }
        }

        String finalOutput = "";
        for (int y = 0; y < printMatrix[0].length; y++)
        {
            for (int x = 0; x < printMatrix.length; x++)
                finalOutput += printMatrix[x][y];
            finalOutput += "\n";
        }
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
