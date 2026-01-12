/*Sudipti Dantuluri
 * 10.12.2021
 * FactorialAndSum.java
 * The program uses scanner and loops to calculate factorial, combination, or sum*/
 
 import java.util.Scanner;
 public class FactorialAndSum {
	
	public static void main(String [] args) {
		FactorialAndSum msp = new FactorialAndSum();
		msp.FandAMethod(); }
		
	public void FandAMethod() {
		Scanner types = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.print("Would you like to use factorial(1), combination(2), or sum(3)? ");
		int choice = types.nextInt(); 
		
		if (choice==1){
			System.out.print("Enter an integer: ");
			int intInput = types.nextInt();
			long output = factorial(intInput); }
		if (choice==2) {
			System.out.print("Enter upper then lower number: ");
			int totalItems = types.nextInt();
			int choose = types.nextInt();
			long output2 = combination(totalItems, choose);
			//System.out.printf("%dC%d = %ld\n", totalItems, choose, output2); 
		}
		if (choice==3){
			System.out.print("Enter 1st number: ");
			int firstNum = types.nextInt();
			System.out.print("Enter last number: ");
			int lastNum = types.nextInt();
			int output3 = sum(firstNum,lastNum);
		}
	}
	
	public long factorial(int num){
		long output = 1;
		
		//System.out.printf("%d! = ",num);
		
		for (int i = 1; i <= num; i++)
		{
			output *= i;
		}
		//System.out.println(output);
		//System.out.println("\n\n\n");
		return output; }
	
	public long combination(int num1, int num2) {
                long n = factorial(num1);
                long r = factorial(num2);
                long n_r = factorial(num1-num2);
			
				long result = n/(r*n_r);
                System.out.printf("%dC%d = %d\n\n\n",num1,num2,result);
                return result;
        }
    public int sum(int num1, int num2){
    	int output3 = 0;
    	for (int i = num1; i<=num2; i++){
    		output3 += i;
    		
    	}
    	System.out.printf("The sum of the numbers between %d and %d is %d",num1,num2,output3);
    	System.out.println("\n\n\n");
    	return output3;
    }
}
