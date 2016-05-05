import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Statistics {


	// Returns the mean of the given data set.
	public static double mean(ArrayList<Double> numbers) {

		double sum = 0;
		double size = numbers.size();

		for(int i = 0; i < size;i++){
			sum += numbers.get(i);
		}
		double mean = sum / (numbers.size());
		return mean;
	}

	// Returns the variance of the given data set.
	public static double variance(ArrayList<Double> numbers,double mean) {

		double variance = 0;
		double size = numbers.size();
		double diff = 0;


		for(int i = 0; i < size; i++){
			diff += (numbers.get(i) - mean)* (numbers.get(i) - mean);
	}
		return diff/size;
	}

	// Returns the standard deviation of the given data set.
	public static double sd(double variance) {

		return Math.sqrt(variance);
	}

	public static void main(String[] args) {

		ArrayList <Double> numbers = new ArrayList <Double> ();
		Scanner in = new Scanner(System.in);


		System.out.println("Enter data set:");

		while(in.hasNextDouble()){
			double input = in.nextDouble();
			numbers.add(input);
	}

		if(numbers.isEmpty()){
			System.out.println("");
			System.out.println("No data!");
			System.exit(0);
		}
		double mean = mean(numbers);
		double variance = variance(numbers,mean);

		//System.out.println("");
		//System.out.println("");
		System.out.println("");

		System.out.printf("Mean = %.4f",mean);
		System.out.println("");

		System.out.printf("Variance = %.4f",variance(numbers,mean(numbers)));
		System.out.println("");

		System.out.printf("Standard deviation = %.4f",sd(variance));
		System.out.println("");
	}

}
