/*Sudipti Dantuluri
 * 09.01.2021
 * PiWave.java
 * The program uses printf to print the PI number of spaces based on the digit
   I didnt round the last digit of pi */
 
 public class PiWave
 {
	public static void main (String [] args)
	{
		PiWave hello = new PiWave();
		hello.outputMethod();
	}
	public void outputMethod()
	{
	    System.out.println("\n\n");
        String pi = "" + Math.PI;
        // loop through each element in PI
        for(int i = 0; i<13; i++)
        {
            char a = pi.charAt(i);
            if (a == '.') {
                continue;
            }
            int spaces = a - '0';
            String s = "";
            for (int j = 0; j<(a - '0'); j++) {
                s += a;
            }
            System.out.printf("" + a + "%" + spaces + "s%s\n", " ", s);
        }
	   System.out.println("\n\n");
	}
}
