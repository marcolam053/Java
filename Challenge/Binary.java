import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

public class Binary {

	public static String input = "";

	// Returns decimal representation of given binary number.
	public int toDecimal(String b) {

		return Integer.parseInt(b,2);
	}

	// Returns whether or not given string is a binary number.
	public static boolean isBinary(String b) {

		String pattern = "(0*1*)*";

		if(Pattern.compile(pattern).matcher(b).matches()){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);

		System.out.print("Enter binary: ");
		input = in.nextLine();
		String pattern = "(0*1*)*";

		if(Pattern.compile(pattern).matcher(input).matches()){
			System.out.println("");
			System.out.println(Integer.parseInt(input,2)+" in decimal");
		}else{
			System.out.println("");
			//System.out.println("");
			System.out.println("Not binary!");
		}
	}
}
