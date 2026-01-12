/*
Katherine Li
12/07/2021
RomanNumeral.java
returns the roman numeral of numbers less than 100
*/

import java.util.Scanner; 

public class RomanNumeral
{
	Scanner input = new Scanner(System.in); 
	
	public static void main(String[]args)
	{
		RomanNumeral rn = new RomanNumeral();
		rn.runner(); 
	}
	
	public void runner() 
	{
		System.out.print("\n\n\n"); 
		System.out.print("Please enter an integer less than or equal to 100: "); 
		int n2 = input.nextInt(); 
		String one = convertIt(n2%10, "I", "V", "X");
		if (n2 < 10) {
			System.out.print("\n\nThis is " + n2 + " in roman numeral: " + one); 
		}
		if (n2 >= 10) {
			String ten = convertIt(n2/10, "X", "L", "C");
			System.out.print("\n\nThis is " + n2 + " in roman numeral: " + ten + one); 
		}
		System.out.print("\n\n\n"); 
	}
	
	public String convertIt(int n2, String str1, String str2, String str3) 
	{
		String result = ""; 
		if (n2 == 10) {
			return str3; 
		}
		else if (n2 == 9) {
			return str1 + "" + str3; 
		}
		else if (n2 == 5) {
			return str2;
		} 
		else if (n2 == 4) {
			return str1 + "" + str2; 
		} 
		else {
			result = ""; 
			if (n2 > 4) {
				result = str2; 
				n2 -= 5; 
			}
			for (int i = 1; i <= n2; i++) {
				result += str1;
			} 
		} return result; 
	}
}