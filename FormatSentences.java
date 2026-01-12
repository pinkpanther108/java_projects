/*Sudipti Dantuluri
 * 9.16.2021
 * FormatSentences.java
 * The program uses scanner to print three sentences in either printf or format*/
 
 import java.util.Scanner; //Import library
 public class FormatSentences
 {
	public static void main (String [] args)
	{
		FormatSentences msp = new FormatSentences();
		msp.types();
	}
	public void types()
	{
		Scanner types = new Scanner(System.in); //Opens the Scanner
		int orientation = 0; // left(1), center(2), or right(3)? ");
		System.out.print("\n\n\n");
		System.out.print("Printf(1) or Format(2)? ");
		int print_fmt = types.nextInt();
		System.out.print("Would you like left(1), center(2), or right(3)? ");
		int sentence1_justify = types.nextInt();
		System.out.print("How many spaces? ");
		int sentence1_spaces = types.nextInt();	
		types.nextLine();
		System.out.print("Enter your sentence: ");
		String sentence1 = types.nextLine();
		types.nextLine();

		System.out.print("Would you like left(1), center(2), or right(3)? ");
		int sentence2_justify = types.nextInt();
		System.out.print("How many spaces? ");
		int sentence2_spaces = types.nextInt();	
		types.nextLine();
		System.out.print("Enter your sentence: ");
		String sentence2 = types.nextLine();
		types.nextLine();

		System.out.print("Would you like left(1), center(2), or right(3)? ");
		int sentence3_justify = types.nextInt();
		System.out.print("How many spaces? ");
		int sentence3_spaces = types.nextInt();	
		types.nextLine();
		System.out.print("Enter your sentence: ");
		String sentence3 = types.nextLine();
		types.nextLine();

		if (print_fmt==1) //Printf
		{
			//use printf
			String format;
			System.out.println("0123456789012345678901234567890123456789");
			if (sentence1_justify == 1) {
				format = "%-" + sentence1_spaces + "s\n";
				System.out.printf(format, sentence1);
			}
            
			if (sentence1_justify == 2) {
				int spaces = (sentence1_spaces - sentence1.length())/2;
				format = "%" + spaces + "s" + "%" + sentence1.length() +"s" + "%" + spaces + "s\n";
				System.out.printf(format, " ", sentence1, " ");
			}

			if (sentence1_justify == 3) {
				format = "%" + sentence1_spaces + "s\n";
				System.out.printf(format, sentence1);
			}
            System.out.println("0123456789012345678901234567890123456789");
			if (sentence2_justify == 1) {
				format = "%-" + sentence2_spaces + "s\n";
				System.out.printf(format, sentence2);
			}
			if (sentence2_justify == 2) {
				int spaces = (sentence2_spaces - sentence2.length())/2;
				format = "%" + spaces + "s" + "%" + sentence2.length() +"s" + "%" + spaces + "s\n";
				System.out.printf(format, " ", sentence2, " ");
			}
			if (sentence2_justify == 3) {
				format = "%" + sentence2_spaces + "s\n";
				System.out.printf(format, sentence2);
			}
            System.out.println("0123456789012345678901234567890123456789");
			if (sentence3_justify == 1) {
				format = "%-" + sentence3_spaces + "s\n";
				System.out.printf(format, sentence3);
			}
			if (sentence3_justify == 2) {
				int spaces = (sentence3_spaces - sentence3.length())/2;
				format = "%" + spaces + "s" + "%" + sentence3.length() +"s" + "%" + spaces + "s\n";
				System.out.printf(format, " ", sentence3, " ");
			}
			if (sentence3_justify == 3) {
				format = "%" + sentence3_spaces + "s\n";
				System.out.printf(format, sentence3);
			}
		}	
		if (print_fmt==2) //Format
		{
			System.out.println("Here are your three sentences: ");
			System.out.println("0123456789012345678901234567890123456789");
			if (sentence1_justify == 1) {
				System.out.println(Format.left(sentence1,sentence1_spaces));
			}
			if (sentence1_justify == 2) {
				System.out.println(Format.center(sentence1,sentence1_spaces));
			}
			if (sentence1_justify == 3) {
				System.out.println(Format.right(sentence1,sentence1_spaces));
			}
			System.out.println("0123456789012345678901234567890123456789");
			if (sentence2_justify == 1) {
				System.out.println(Format.left(sentence2,sentence2_spaces));
			}
			if (sentence2_justify == 2) {
				System.out.println(Format.center(sentence2,sentence2_spaces));
			}
			if (sentence2_justify == 3) {
				System.out.println(Format.right(sentence2,sentence3_spaces));
			}
            		System.out.println("0123456789012345678901234567890123456789");
			if (sentence3_justify == 1) {
				System.out.println(Format.left(sentence3,sentence2_spaces));
			}
			if (sentence3_justify == 2) {
				System.out.println(Format.center(sentence3,sentence3_spaces));
			}
			if (sentence3_justify == 3) {
				System.out.println(Format.right(sentence3,sentence3_spaces));
			}







		}
	}
}
class Format
{

    public Format()
    {
    }

    public static String center(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String centerSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String left(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String leftSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String right(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String rightSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(long l, int i)
    {
        String s = convert(l);
        if(i <= s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String decimalPlaces(double d, int i)
    {
        double d1 = d * Math.pow(10D, i);
        d1 = Math.round(d1);
        d1 /= Math.pow(10D, i);
        return convert(d1, i);
    }

    public static String sigFigFix(double d, int i)
    {
        String s = Double.toString(d);
        String s1;
        String s2;
        if(s.startsWith("-") || s.startsWith("+"))
        {
            s1 = s.substring(0, 1);
            s2 = s.substring(1);
        } else
        {
            s1 = "";
            s2 = s;
        }
        int j = s2.indexOf(101);
        if(j == -1)
            j = s2.indexOf(69);
        String s3;
        String s4;
        if(j == -1)
        {
            s3 = s2;
            s4 = "";
        } else
        {
            s3 = s2.substring(0, j);
            s4 = s2.substring(j);
        }
        int k = s3.indexOf(46);
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        if(k == -1)
        {
            stringbuffer = new StringBuffer(s3);
            stringbuffer1 = new StringBuffer("");
        } else
        {
            stringbuffer = new StringBuffer(s3.substring(0, k));
            stringbuffer1 = new StringBuffer(s3.substring(k + 1));
        }
        int l = stringbuffer.length();
        int i1 = stringbuffer1.length();
        if((l == 0 || stringbuffer.equals("0")) && i1 > 0)
        {
            l = 0;
            for(int j1 = 0; j1 < stringbuffer1.length(); j1++)
            {
                if(stringbuffer1.charAt(j1) != '0')
                    break;
                i1--;
            }

        }
        int k1 = l + i1;
        if(i > k1)
        {
            for(int l1 = k1; l1 < i; l1++)
                stringbuffer1.append('0');

        } else
        if(i < k1 && i >= l)
            stringbuffer1.setLength(
            stringbuffer1.length() - (i1 - (i - l)));
        else
        if(i < l)
        {
            stringbuffer1.setLength(0);
            for(int i2 = i; i2 < l; i2++)
                stringbuffer.setCharAt(i2, '0');

        }
        if(stringbuffer1.length() == 0)
            return s1 + stringbuffer + s4;
        else
            return s1 + stringbuffer + "." + stringbuffer1 + s4;
    }

    private static String convert(double d, int i)
    {
        int j = 0;
        StringBuffer stringbuffer = new StringBuffer("" + d);
        int k;
        for(k = stringbuffer.length(); j < k && 
        stringbuffer.charAt(j) != '.'; j++);
        int l;
        if(j == k)
        {
            stringbuffer.append(".");
            l = i;
        } else
        {
            int i1 = k - j - 1;
            l = i - i1;
        }
        for(int j1 = 0; j1 < l; j1++)
            stringbuffer.append("0");

        return stringbuffer.toString();
    }

    private static String convert(long l)
    {
        return "" + l;
    }

    private static String pad(char c, int i)
    {
        StringBuffer stringbuffer = new StringBuffer("");
        if(i < 1)
            return "";
        for(int j = 0; j < i; j++)
            stringbuffer.append(c);

        return stringbuffer.toString();
    }
}
