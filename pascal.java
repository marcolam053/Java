import java.util.*;

public class pascal{
	public static void main(String[]args){
		int row;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter height :");
		row = in.nextInt();
		for(int i = 0; i < row ;i++){
			int start = 1;
			System.out.format("%"+(row-i)*2+"s","");
			for(int j = 0; j <= i;j++){
				System.out.format("%4d",start);
			  	start= start*(i-j) /(j+1);
			}
			System.out.println();
		}
	}
}
