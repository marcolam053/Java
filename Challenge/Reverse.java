import java.util.Scanner;

public class Reverse{




  public static void main(String[] args){

    Scanner keyboard = new Scanner(System.in);
    String original = " ";

	 //read untill ctlr+d
   while(keyboard.hasNextLine()){
	    original = keyboard.nextLine(); //in.nextLine() for line-by-line
      String reverse = new StringBuffer(original).reverse().toString();
      System.out.println(reverse);
	   }
   }
}
