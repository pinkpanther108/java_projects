/*Sudipti Dantuluri
 * 11.30.2021
 * FindMe.java
 * The program outputs lower case letters that appear in all the input strings down to one word.*/
 
import java.util.Scanner;
public class FindMe {
  //field variables
  Scanner kb;
  public FindMe() {
    kb = new Scanner(System.in);
  }

  public static void main (String[]args) {
    FindMe fm = new FindMe();
    fm.fmMethod();
  }
  public void fmMethod() {
      String w1, w2,w3,w4,w5;
      w1=w2=w3=w4=w5="";
      int number = 0;
      System.out.println("\n\n\n");
      System.out.print("Would you like to run Three Strings(1) or Choose your own(2)? ");
      int choice = kb.nextInt();
      if (choice==1) {  //if choice = 1,then just runs with number =3
        number = 3;
      } else if(choice==2) {
          System.out.println("Please enter how many strings you would like to enter? ");
          number = kb.nextInt();
      } else {
          System.out.println("Wrong choice. Choose either 1 or 2");
      }
      System.out.printf("Please enter %d strings: ", number);
      //converts entire word to lowercase
      if(number>=1) {w1=kb.next(); w1=lower(w1);}
      if(number>=2) {w2=kb.next(); w2=lower(w2);}
      if(number>=3) {w3=kb.next(); w3=lower(w3);}
      if(number>=4) {w4=kb.next(); w4=lower(w4);}
      if(number==5) {w5=kb.next(); w5=lower(w5);}
      for (int i=number; i >=1;i--) {
        if(i==5) outputWords(w1,w2,w3,w4,w5);
        if(i==4) outputWords(w1,w2,w3,w4);
        if(i==3) outputWords(w1,w2,w3);
        if(i==2) outputWords(w1,w2);
        if(i==1) outputWords(w1);
      }
  }
  public String lower(String str) { //checks each letter and converts to lower case
      String word="";
      for(int i=0;i<str.length();i++) {
          if( (int)str.charAt(i)>=65 && (int)str.charAt(i)<=90) word+=(char)((int)str.charAt(i)+32);
          else word+=str.charAt(i);
      }
      return word;
  }
  public void outputWords(String w1) { 
    int counter=0;
    String word = "";
    for(int j = 97;j<=122;j++) {
        //checks letter is contained in word and adds 1 if true
        counter+=countLetters(w1, (char)j);
        if (counter==1 && word.length()==0) {
            word+=(char)j; //this is to check if it's the first letter that works
        } else if(counter==1) {
            word = word +","+(char)j;
        }
        counter=0;
    }
    System.out.println("Letter(s) that appear in 1 word:");
    System.out.println(word);
  }
  public void outputWords(String w1, String w2) { 
    int counter=0;
    String word = "";
    for(int j = 97;j<=122;j++) {
        //checks letter is contained in word and adds 1 if true
        counter+=countLetters(w1, (char)j);
        counter+=countLetters(w2, (char)j);
        if (counter==2 && word.length()==0) {
            word+=(char)j; //this is to check if it's the first letter that works
        } else if(counter==2) {
            word = word +","+(char)j;
        }
        counter=0;
    }
    System.out.println("Letter(s) that appear in 2 words:");
    System.out.println(word);
  }
  public void outputWords(String w1, String w2, String w3) { 
    int counter=0;
    String word = "";
    for(int j = 97;j<=122;j++) {
        //checks letter is contained in word and adds 1 if true
        counter+=countLetters(w1, (char)j);
        counter+=countLetters(w2, (char)j);
        counter+=countLetters(w3, (char)j);
        if (counter==3 && word.length()==0) {
            word+=(char)j; //this is to check if it's the first letter that works
        } else if(counter==3) {
            word = word +","+(char)j;
        }
        counter=0;
    }
    System.out.println("Letter(s) that appear in 3 words:");
    System.out.println(word);
  }
  public void outputWords(String w1, String w2, String w3, String w4) { 
    int counter=0;
    String word = "";
    for(int j = 97;j<=122;j++) {
        //checks letter is contained in word and adds 1 if true
        counter+=countLetters(w1, (char)j);
        counter+=countLetters(w2, (char)j);
        counter+=countLetters(w3, (char)j);
        counter+=countLetters(w4, (char)j);
        if (counter==4 && word.length()==0) {
            word+=(char)j; //this is to check if it's the first letter that works
        } else if(counter==4) {
            word = word +","+(char)j;
        }
        counter=0;
    }
    System.out.println("Letter(s) that appear in 4 words:");
    System.out.println(word);
  }
  public void outputWords(String w1, String w2, String w3, String w4, String w5) { 
    int counter=0;
    String word = "";
    for(int j = 97;j<=122;j++) {
        //checks letter is contained in word and adds 1 if true
        counter+=countLetters(w1, (char)j);
        counter+=countLetters(w2, (char)j);
        counter+=countLetters(w3, (char)j);
        counter+=countLetters(w4, (char)j);
        counter+=countLetters(w5, (char)j);
        if (counter==5 && word.length()==0) {
            word+=(char)j; //this is to check if it's the first letter that works
        } else if(counter==5) {
            word = word +","+(char)j;
        }
        counter=0;
    }
    System.out.println("Letter(s) that appear in 5 words:");
    System.out.println(word);
  }
  public int countLetters(String str, char ch){ //this is the method that actually checks if letter is in the word
    for(int i=0; i<str.length();i++) {
        if(str.charAt(i)==ch) {
            return 1;
        }
    }
    return 0;
  }
}
