import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class DNA {

	public static String dna;
	public static String comp = "";
	static Scanner in =  new Scanner(System.in);

	public static void main(String[] args) {

		System.out.printf("Enter strand: ");
		dna = in.nextLine();
		int len = dna.length();
		System.out.printf(dna); //test

		// Check if the String is empty
		if(dna.length == 0){
			System.out.printf("\nNo strand is provided.\n");
		}

		System.out.printf("\nComplementary strand are %s",comp);

	}


	public static String complementary(String dna){

			for(int i = 0; i < dna.length();i++){
				if(dna.charAt(i) == 'A'){
					comp = comp + 'T';
				}
				if(dna.charAt(i) == 'T'){
					comp = comp + 'A';
				}
				if(dna.charAt(i) =='G'){
					comp = comp +'G';
				}
				if(dna.charAt(i) == 'C'){
					comp = comp + 'C';
				}
			}
			return comp;
		}
	}
