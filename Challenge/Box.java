public class Box {

	public static void main(String[] args) {

		if(args.length==0){
			System.out.println("No arguments");
			System.exit(0);
		}
		if(args.length == 1){
			System.out.println("Too few arguments");
			System.exit(0);
		}
		if(args.length > 2){
			System.out.println("Too many arguments");
			System.exit(0);
		}


		if(Integer.parseInt(args[0]) < 0 && Integer.parseInt(args[1]) < 0){
			System.out.println("Negative dimensions");
			System.exit(0);
		}
		if(Integer.parseInt(args[0]) < 0){
			System.out.println("Negative width");
			System.exit(0);
		}
		if(Integer.parseInt(args[1]) < 0){
			System.out.println("Negative height");
			System.exit(0);
		}


		//print box
		int w = Integer.parseInt(args[0]);
		int h = Integer.parseInt(args[1]);

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

}
