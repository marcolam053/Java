public class Apollo{
	public static void main(String[] args){
		System.out.printf("Guidance is internal.\n");

		for(int i = 12 ; i > 0 ; i--){
			System.out.printf("%d...\n",i);

			if(i == 7){
				System.out.println("Ignition sequence start.");
			}

			if(i==1){
				System.out.println("All engine running.");
				System.out.println("Lift off on Apollo 11!");
			}
		}
	}
}
