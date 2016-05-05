public class RomanNumerals {
	public static String entry;
	public static int input;
	public static String roman = "";
	static Scanner in =  new Scanner(System.in);

	// Method for entry of number
	public static void start(){
		System.out.printf("Enter a number: ");
		entry = in.nextLine();
		System.out.println();
	}

	// Method for Checking if string is number
	public static boolean isNum(String entry){
		return (entry.matches("[-+]?\\d*\\.?\\d+"));
	}

	// Method for Converting the input to Roman
	public static void convert(int input){

		//check if entry is a number before converting
		if(isNum(entry)==true){
			input = Integer.parseInt(entry);
		}else{
			System.out.println("Not a number."); // out put error msg if not number
			System.exit(0);
		}

		while(input > 0){
			 if (input >= 1000) {
			        roman += "M";
			        input -= 1000;
			   }
			 else if (input >= 900) {
			        roman += "CM";
			        input -= 900;
			    }
			 else  if (input >= 500) {
			        roman += "D";
			        input -= 500;
			    }
			 else if (input >= 400) {
			        roman += "CD";
			        input -= 400;
			    }
			 else if (input >= 100) {
			        roman += "C";
			        input -= 100;
			    }
			 else if (input >= 90) {
			        roman += "XC";
			        input -= 90;
			    }
			 else  if (input >= 50) {
			        roman += "L";
			        input -= 50;
			    }
			 else  if (input >= 40) {
			        roman += "XL";
			        input -= 40;
			    }
			 else  if (input >= 10) {
			        roman += "X";
			        input -= 10;
			    }
			 else if (input >= 9) {
			        roman += "IX";
			        input -= 9;
			    }
			 else   if (input >= 5) {
			        roman += "V";
			        input -= 5;
			    }
			    else  if (input >= 4) {
			        roman += "IV";
			        input -= 4;
			    }
			    else  if (input >= 1) {
			        roman += "I";
			        input -= 1;
			    }

		}

		System.out.println("Roman equivalent is " + roman);
		System.exit(0);
	}


	public static void main(String[] args){

		start();
		convert(input);

	}
}
