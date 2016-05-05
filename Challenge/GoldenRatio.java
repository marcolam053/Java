import java.util.Scanner;

public class GoldenRatio {
	public static double division;
	public static double sum_div;

	public static void main(String[] args){
		String nums;
		Scanner input = new Scanner(System.in);

		// Enter the value
		System.out.printf("Enter two numbers: ");
		nums = input.nextLine();
		System.out.println();

		// split the string into 2 numbers
		String[] a  = nums.split("\\s+");

		if(isNumber(a[0])==true && isNumber(a[1])==true){
			double first = Double.parseDouble(a[0]);
			double second = Double.parseDouble(a[1]);

			// calculate division and sum+division of a and b
			if(first>second){

			division = Math.round((first/second)*1000.0)/1000.0;
			sum_div = Math.round(((first+second)/first)*1000.0)/1000.0;
			}
			else if(first<second){
				division = Math.round((second/first)*1000.0)/1000.0;
				sum_div = Math.round(((first+second)/second)*1000.0)/1000.0;
			}

			if(division == sum_div){
				System.out.println("Golden ratio!");
			}
			else if(division != sum_div){
				System.out.println("Maybe next time.");
				System.exit(0);
			}
		}
		else{
				System.out.println("Invalid input.");
				System.exit(0);
			}
	}

	public static boolean isNumber(String str) {
		return (str.matches("[-+]?\\d*\\.?\\d+"));
	}
}
