
package blair_tictactoe;
import java.util.Scanner;

public class TicTacToe {
	public static int gameBoardRow, gameBoardColumn;
	public static  Scanner playerMove = new Scanner(System.in);
	public static char[][] gameBoard = new char [3][3];
	public static char playerID = 'X';
	
	public static void main(String[] args)
	{
		Draw();
		Play();
	}
	
	public static void Draw()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				gameBoard[i][j] = '_';		
			}
		}
	}
	
	public static void Play()
	{
		boolean playing = true;
		while(playing)
		{	
			
			System.out.println("Enter a row and column: ");
			printGameBoard();
		
			while(!playerMove.hasNextInt())
			{
				System.out.println("Your move must be 1, 2, or 3!!!");
				playerMove.next();
			}
			gameBoardRow = playerMove.nextInt() - 1;
			//System.out.println(gameBoardRow);
			
			while(gameBoardRow > 2 || gameBoardRow < 0 )
			{ 
				System.out.println("Your move must be 1, 2, or 3!!!");
				gameBoardRow = playerMove.nextInt() - 1;
			}
			
			while(!playerMove.hasNextInt())
			{
				System.out.println("Your move must be 1, 2, or 3!!!");
				playerMove.next();
			}
			gameBoardColumn = playerMove.nextInt() - 1;
			//System.out.println(gameBoardColumn);
			
			while(gameBoardColumn > 2 || gameBoardColumn < 0)
			{ 
				System.out.println("Your move must be 1, 2, or 3!!!");
				gameBoardColumn = playerMove.nextInt() - 1;
				
			}
			
			gameBoard[gameBoardRow][gameBoardColumn] = playerID;
			
			if(gameOver(gameBoardRow, gameBoardColumn))
			{
				playing = false;
				printGameBoard();
			}
			
			
			if(playerID == 'X')
				playerID = 'O';
			else
				playerID = 'X';
			
			}
		} 
	
	
	public static void printGameBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.println();
			for(int j = 0; j < 3; j++)
			{
				if(j == 0)
					System.out.print("| ");
				System.out.print(gameBoard[i][j] + " | ");
			}
		}
		System.out.println();
	}
	
	public static boolean gameOver(int gameBoardRow, int gameBoardColumn)
	{
		//Check perpendicular victory
		if(gameBoard[0][gameBoardColumn] == gameBoard[1][gameBoardColumn] && gameBoard[0][gameBoardColumn] == gameBoard[2][gameBoardColumn])
		{
			System.out.println("Game over! " + playerID + " wins!");
			return true;
		}
		if(gameBoard[gameBoardRow][0] == gameBoard[gameBoardRow][1] && gameBoard[gameBoardRow][0] == gameBoard[gameBoardRow][2])
			{
				System.out.println("Game over! " + playerID + " wins!");
				return true;
			}
		//Check diagonal victory
		if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard [1][1] != '_')
			{
				System.out.println("Game over! " + playerID + " wins!");
				return true;
			}
		if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard [1][1] != '_')
			{
				System.out.println("Game over! " + playerID + " wins!");
				return true;
			}
		/* TODO ADD STALE-MATE CONDITION*/
		return false;
	}
}
