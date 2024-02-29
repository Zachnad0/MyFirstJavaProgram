package myfirstjavaprogram;

import java.util.HashMap;

public class TicTacToeGame
{
    public final int GAME_EDGE_LENGTH = 3, IN_ROW_WIN_COUNT = 3;
    public final char NO_CHAR = ' ', X_CHAR = 'X', O_CHAR = 'O';
    public final ConsoleInterface _consoleInterface = new ConsoleInterface(this);

    private char[][] _gameStateBoard;
    // private boolean _hasFinished = false;
    private HashMap<TicTacToePlayerType, Character> _playerToCharMap = new HashMap<TicTacToePlayerType, Character>()
    {
        {
            put(TicTacToePlayerType.Player_X, X_CHAR);
            put(TicTacToePlayerType.Player_O, O_CHAR);
        }
    };

    public TicTacToeGame()
    {
        // Initialize fresh new tic tac toe game

        // Clear game visual (and scoring) board matrix
        _gameStateBoard = new char[GAME_EDGE_LENGTH][];
        for (int x = 0; x < _gameStateBoard.length; x++)
        {
            _gameStateBoard[x] = new char[GAME_EDGE_LENGTH];
            for (int y = 0; y < _gameStateBoard[x].length; y++)
                _gameStateBoard[x][y] = NO_CHAR;
        }
    }

    public boolean RunTurn(TicTacToePlayerType player, int xPos, int yPos)
    {
        // If invalid pos, or char at pos is already set, turn is invalid
        if (xPos != Math.min(Math.max(xPos, 0), GAME_EDGE_LENGTH)
                || yPos != Math.min(Math.max(yPos, 0), GAME_EDGE_LENGTH) || _gameStateBoard[xPos][yPos] != NO_CHAR)
            return false;

        // Otherwise write char
        _gameStateBoard[xPos][yPos] = _playerToCharMap.get(player);
        return true;
    }

    public boolean CheckForWinCondition()
    {
        // TODO complete CheckForWinCondition
        return false;
    }

    public char[][] GetGameMatrix()
    {
        char[][] copy = new char[GAME_EDGE_LENGTH][];
        for (int x = 0; x < GAME_EDGE_LENGTH; x++)
            copy[x] = _gameStateBoard[x].clone();

        return copy;
    }
}
