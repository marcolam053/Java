import java.util.*;
import java.lang.StringBuilder;

public class Caesar {

	public static Scanner in = new Scanner(System.in);

	public static String line;
	public static int shift;
	public static String encrypted = "";

	public static void main(String[] args) {

		System.out.printf("Enter number: ");
		shift = in.nextInt ();
		if(shift < 0){
			System.out.printf("\nInvalid key!\n");
		}else if(shift >= 0){
			in.nextLine();
			System.out.printf("Enter line: ");
			line = in.nextLine();

			System.out.printf("\n%s\n",encrypt(line,shift));
		}
	}

	public static String encrypt(String line, int shift)
	    {
		  shift = shift % 26 + 26;
        	StringBuilder encrypted = new StringBuilder();
        		for (char word : line.toCharArray()) {
        			if (Character.isLetter(word)) {
                		if (Character.isLowerCase(word)) {
                    		encrypted.append((char) ('a' + (word - 'a' + shift) % 26 ));
                		} else {
                    		encrypted.append((char) ('A' + (word - 'A' + shift) % 26 ));
                		}
            		} else {
                		encrypted.append(word);
            		}
        		}
          return encrypted.toString();
    }
}
