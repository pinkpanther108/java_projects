import java.util.Arrays;
import java.util.Scanner;

public class MatrixGame
{
	Scanner in = new Scanner (System.in);
	
	int sum = 0;
	int sum2 = 0;
	
	public static void main (String [] args)
	{
		MatrixGame mg = new MatrixGame();
		mg.runner();
	}
	
	public void runner()
	{
		int [][] game = new int [9][9];
		int randnum;
		
		for (int i = 0; i < 8; i ++)
		{
			for (int j = 0; j < 8; j ++)
			{
				randnum = (int) (Math.random()*9 + 1);
				game[i][j] = randnum;
			}
		}
		

		int o = 0;
		
		while (o != 3) 
		{
			o ++;
		
		for (int i = 0; i < 9; i ++)
		{
			System.out.println();
			for (int j = 0; j < 9; j ++)
			{
				if (i == 0)
					game[i][j] = j;
					
				if (j == 0)
					game [i][j] = i;
				
				if (i == 8 && j == 8)
					System.out.print(0);
					
				if (i != 8 || j != 8)
					System.out.print(game[i][j] + "   ");
			}
		}
		
		System.out.print("\nWhat do you want to switch");
		int c1x = in.nextInt();
		int c1y = in.nextInt();
		int c2x = in.nextInt();
		int c2y = in.nextInt();
		
		int keep = game[c1x][c1y];
		game[c1x][c1y] = game[c2x][c2y];
		game[c2x][c2y] = keep;
		max(game);
		
		}
		
		if (sum > sum2)
			System.out.print("Player 1 won");
		else 
			System.out.print("Player 2 won");
		
		

	}
	
	public void max(int[][] game)
	{
		int [] horizsum = new int [7];
		int [] vertsum = new int [7];
		int hv = 0;
		int player1score = 0;
		int player2score = 0;
		
		while (hv != 7)
		{
			hv += 1;
			sum = 0;
			for (int j = 1; j < 8; j ++)
			{
				sum += game[hv][j];
				horizsum[hv-1] = sum;
			}
			sum = 0;
			for (int j = 1; j < 8; j ++)
			{
				sum += game[j][hv];
				vertsum[hv-1] = sum;
			}
		}
		
		for (int i = 0; i < 7; i ++)
		{
		
			for (int j = 1; j < 8; j ++)
			{
				sum += game[i][j];
				player1score += sum;
			}

			for (int j = 1; j < 8; j ++)
			{
				sum2 += game[j][i];
				player2score += sum2;
			}
		}
		
		System.out.println("Player 1: " + sum);
		System.out.println("Player 2: " + sum2);

		int[] sortedv = sort(vertsum);
		int[] sortedh = sort(horizsum);
		
		for (int i = 0; i < 7; i ++)
		{
			if (sortedv[4] == vertsum[i])
				game[8][i+1] = 1;
			
			if (sortedv[5] == vertsum[i])
				game[8][i+1] = 1;
			
			if (sortedv[6] == vertsum[i])
				game[8][i+1] = 1;
			
			if (sortedh[4] == horizsum[i])
				game[i+1][8] = 1;
			
			if (sortedh[5] == horizsum[i])
				game[i+1][8] = 1;
			
			if (sortedh[6] == horizsum[i])
				game[i+1][8] = 1;
		}
		
		
	}
	
	public int[] sort(int [] array)
	{
		int [] array2 = new int[array.length];
		
		for (int i = 0; i < array2.length; i ++)
		{
			array2[i] = array[i];
		}
		
		Arrays.sort(array2);

		
		return array2;
	}
}