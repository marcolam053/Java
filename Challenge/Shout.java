import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shout {

	private static String input;
	private static int i = 0;


	public static void main(String[] args) {

	List<String> input_l = new ArrayList<String>();
	Scanner key = new Scanner(System.in);

	//read input until ctlr+d
	while(key.hasNextLine()){
		input= key.nextLine().toUpperCase();
		input_l.add(input);
	}
	for(int i = 0; i < input_l.size(); i++){
		System.out.println(input_l.get(i));
	}
  }
}
