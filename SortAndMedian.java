// Parth Upadhyay
// 1/12/2022
// SortAndMedian
// To do the median 

import java.util.Scanner;

public class SortAndMedian
{
	Scanner in = new Scanner (System.in);
	
	public static void main (String [] args)
	{
		SortAndMedian sm = new SortAndMedian();
		sm.runner();
	}
	
	public void runner() 
	{
		int [] num = new int[5];
		String mode = "";
		String sorted = "";
		
		System.out.print("\n\n\n");
		
		System.out.println("What are your five numbers? ");
		
		for (int i = 0; i < 5; i ++) 
		{
			num [i] = in.nextInt();
		}
		
		for (int i = 0; i < 5; i ++)
		{
			for (int j = 0; j < 4; j ++)
			{
				int max = Math.max(num[j], num[j + 1]);
				int min = Math.min(num[j], num[j + 1]);
				
				num[j] = min;
				num[j+1] = max;
		
			}
		}
		
		for (int i = 0; i < 5; i ++)
		{
			sorted += num[i] + ",";
		}	
		
		for (int i = 0; i < 4; i ++)
		{
			if (num[i] == num[i + 1]) 
			{
				mode += num[i] + ",";
			}
		}
		
		if (mode == "")
			mode = sorted.substring(0,sorted.length());
		
		System.out.print("\nSorted: " + sorted.substring(0,sorted.length()-1));
		System.out.print("\nThe median is: " + num[2]);
		System.out.print("\nThe mode(s) are: " + mode.substring(0,mode.length()-1));
		
		System.out.print("\n\n\n");
	
	}
	
}