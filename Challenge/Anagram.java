import java.util.*;
import java.util.Arrays;

public class Anagram {

	// Returns a copy of the string in sorted order.
	public static String sort(String s) {

		char[] sorted = s.toLowerCase().toCharArray();
        Arrays.sort(sorted);
        return String.valueOf(sorted);

	}

	public static boolean isAnagram(String line, String anagram){

		if(line.length() != anagram.length()){
			return false;
		}
		line = line.replaceAll("[^0-9A-Za-z]", "");

		line = sort(line);
		anagram = sort(anagram);
		return line.equals(anagram);

	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.printf("Enter line: ");
		String line = keyboard.nextLine();
		line = line.replaceAll("[^0-9A-Za-z]", "");

		System.out.printf("Enter anagram: ");
		String anagram = keyboard.nextLine();
		anagram = anagram.replaceAll("[^0-9A-Za-z]", "");

		System.out.println("");

		if(isAnagram(line,anagram)){
			System.out.println("Anagram!");
		}else{
			System.out.println("Not an anagram.");
		}
	}
}
