import java.util.*;

public class Vector {

	private Long sum;
	private Long mode;
	private Long median;
	private Long minimum;
	private Long maximum;

	private final int length;
	private final long[] elements;

	// ===========================================================================
	// INITIALIZATION
	// ===========================================================================

	/**
	 * Constructs new vector with the given
	 * length and all elements set to zero.
	 */
	public Vector(int length) {

		this.sum = null;
		this.mode = null;
		this.median = null;
		this.minimum = null;
		this.maximum = null;

		this.length = length;
		this.elements = new long[length];
	}

	/**
	 * Returns new vector with elements generated at random up to 100.
	 */
	public static Vector random(int length, long seed) {

		Vector vector = new Vector(length);
		Random random = new Random(seed);

		for (int i = 0; i < length; i++) {
			vector.elements[i] = (long) random.nextInt(101);
		}

		return vector;
	}

	/**
	 * Returns new vector with all elements set to given value.
	 */
	public static Vector uniform(int length, long value) {

		// initiate vector for storing uniform values
		Vector uniform = new Vector(length);

		// loop through the length and print out the value one by one
		for(int i  = 0; i < length; i++){
			uniform.elements[i] = value;
		}

		return uniform;
	}

	/**
	 * Returns new vector with elements in sequence from given start and step.
	 */
	public static Vector sequence(int length, long start, long step) {

		/*
			length 1, start 1, step 1  => [1]
			length 2, start 2, step 2  => [2 4]
			length 3, start 3, step 3  => [3 6 9]
			length 4, start 4, step 4  => [4 8 12 16]
			length 5, start 5, step -1 => [5 4 3 2 1]
		*/

		// initiate vector to store the sequence
		Vector s = new Vector(length);

		// loop through the length and store the value
		for(int i = 0 ; i < length; i ++){
			s.elements[i] = start;
			start = start + step;
	   }

	   return s;
	}

	/**
	 * Returns whether the number is semi-prime.
	 */
	public static boolean isPQ(long number) {

			for(long i = 2; i <= number;i++){
				if(number%i == 0 && isPrime(i) == true){
					long divided = number/i;
					if(isPrime(divided)){
						return true;
					}
				}
			}

			return false;
	}

	/**
	 * Returns new vector with elements generated from the
	 * pq number sequence starting from the specified value.
	 */
	public static Vector pq(int length, long start) {

		/*
			length 4, start 1  => [4 6 9 10]
			length 4, start 4  => [4 6 9 10]
			length 4, start -1 => [4 6 9 10]
			length 4, start 42 => [46 49 51 55]
		*/
		Vector pq = new Vector(length);
		// enter the value of semiPrime into the List
		for(int i = 0; i < length; i++){
			while(isPQ(start) == false){
				start++;
			}
			pq.elements[i] = start;
			start++;
		}

		return pq;
	}

	/**
	 * Returns whether the number is prime.
	 */
	public static boolean isPrime(long number) {

	    if(number == 1 || number == 0)return false;
	    for(int i = 2; i < number; i++) {
	        if(number%i==0)
	            return false;
	    }
	    return true;
	}
	/**
	 * Returns new vector with elements generated from the
	 * prime number sequence starting from the specified value.
	 */
	public static Vector prime(int length, long start) {

		Vector prime = new Vector(length);
		long num = start;

		// convert negative to positive
		if(start < 0){
			num = start * -1;
		}
		// Enter the prime value to the vector
		for(int i = 0; i < length;i++){
			while(isPrime(num) ==false){
				num++;
			}
			prime.elements[i] = num;
			num++;
		}
		return prime;
	}

	/**
	 * Returns whether the number is abundant.
	 */
	public static boolean isAbundant(long number) {

		long sum = 0;
		long decider = 0;

		for(int i = 1; i <= number; i++){
			if(number % i == 0){
				sum += i;
			}
		}
		decider = 2*number;
		if(sum > decider){ // if it is 2n -> abundant number
			return true;
		}
		return false;
	}

	/**
	 * Returns new vector with elements generated from the
	 * abundant number sequence starting from the specified value.
	 */
	public static Vector abundant(int length, long start) {

		/*
			length 4, start 0  => [12 18 20 24]
			length 4, start 12 => [12 18 20 24]
			length 4, start -1 => [12 18 20 24]
			length 4, start 42 => [42 48 54 56]
		*/

		Vector abundant = new Vector(length);
		long num = start;

		// convert negative to positive
		if(start < 0){
			num = start * -1;
		}
		// Enter the abundant value to the vector
		for(int i = 0; i < length;i++){
			while(isAbundant(num) ==false){
				num++;
			}
			abundant.elements[i] = num;
			num++;
		}
		return abundant;
	}
	/**
	 * Returns whether the number is composite.
	 */
	public static boolean isComposite(long number) {

		for(int i =2; i <= number;i++){

			if(number > 3 &&(isPrime(number) == false) &&(number%2 == 0 && number%3 == 0
			   || number%2 == 0 && number%5 == 0|| number%2 == 0 || number%3 == 0)){
				return true;
			}

		}
		return false;
	}

	/**
	 * Returns new vector with elements generated from the
	 * composite number sequence starting from the specified value.
	 */
	public static Vector composite(int length, long start) {

		/*
			length 4, start 0  => [4 6 8 9]
			length 4, start 4  => [4 6 8 9]
			length 4, start -1 => [4 6 8 9]
			length 4, start 42 => [42 44 45 46]
		*/

		Vector composite = new Vector(length);
		// convert negative start to positive
		if(start < 0){
			start = start *-1;
		}
		// enter the value of compositeinto the List
		for(int i = 0; i < length; i++){
			while(isComposite(start) == false){
				start++;
			}
			composite.elements[i] = start;
			start++;
		}

		return composite;
		}


	// ===========================================================================
	// VECTOR OPERATIONS
	// ===========================================================================

	/**
	 * Returns new vector that is a copy of the current vector.
	 */
	public Vector cloned() {

		Vector clone = new Vector(length);

		for(int i = 0; i < length;i++){
			clone.elements[i]= this.elements[i];
		}
		return clone;
	}

	/**
	 * Returns new vector with elements ordered from smallest to largest.
	 */
	public Vector sorted() {

		/*
			[1 1 1 1] => [1 1 1 1]
			[1 2 3 4] => [1 2 3 4]
			[4 3 2 1] => [1 2 3 4]
		*/

		Vector sorted = new Vector(length);
		// copy current vector to the new vector to prepare for sorting.
		for(int i = 0; i < length; i++){
			sorted.elements[i]=this.elements[i];
		}
		// start storting process
		Arrays.sort(sorted.elements);

		return sorted;
	}

	/**
	 * Returns new vector with elements ordered in reverse.
	 */
	public Vector reversed() {

		/*
			[1 1 1 1] => [1 1 1 1]
			[1 2 3 4] => [4 3 2 1]
			[4 3 2 1] => [1 2 3 4]
		*/

		Vector reverse = new Vector(length);

		// copy the current vector
		for(int i = 0; i< length; i++){
			// reverse the vector elements
			reverse.elements[i] = this.elements[length-i-1];
		}

		return reverse;
	}

	/**
	 * Returns new vector with elements shifted right by a given number of positions.
	 */
	public Vector shifted(int amount) {

		/*
			[1 2 3 4] 0 => [1 2 3 4]
			[1 2 3 4] 1 => [4 1 2 3]
			[1 2 3 4] 2 => [3 4 1 2]
			[1 2 3 4] 3 => [2 3 4 1]
			[1 2 3 4] 4 => [1 2 3 4]
			[1 2 3 4] 5 => [4 1 2 3]
		*/
		Vector shifted = new Vector(length);
		// calculate the number of time shifing operation is needed
		amount = amount%length;

		// shift the elements
		for(int i = 0; i < length; i++){
			// No shifted is needed
			if(amount == 0){
				shifted.elements[i] = this.elements[i];
			}
			// shift operation is needed
			else{
				// shift all elements
				for(i =0; i< amount;i++){
					shifted.elements[i]=this.elements[length-amount+i];
				}
				for(i= amount; i<length; i++){
					shifted.elements[i]=this.elements[i-amount];
				}
			}
		}
		return shifted;
	}

	/**
	 * Returns new vector, adding scalar to each element.
	 */
	public Vector scalarAdd(long scalar) {

		/*
			[1 1 1 1] + 1  => [2 2 2 2]
			[1 2 3 4] + 4  => [5 6 7 8]
			[2 2 2 2] + -1 => [1 1 1 1]
		*/

		Vector scalar_add = new Vector(length);

		// add all elements by scalar listed
		for(int i= 0; i < length; i++){
			scalar_add.elements[i] = this.elements[i] + scalar;
		}

		return scalar_add;
	}

	/**
	 * Returns new vector, multiplying scalar to each element.
	 */
	public Vector scalarMultiply(long scalar) {

		/*
			[1 2 3 4] x 0  => [0 0 0 0]
			[1 2 3 4] x 1  => [1 2 3 4]
			[1 2 3 4] x 2  => [2 4 6 8]
			[1 2 3 4] x 10 => [10 20 30 40]
			[1 2 3 4] x -1 => [-1 -2 -3 -4]
		*/
		Vector scalar_multi = new Vector(length);

		// multiply all the element in the vector by the scalar provided
		for(int i = 0; i< length; i++){
			scalar_multi.elements[i] = this.elements[i] * scalar;
		}

		return scalar_multi;
	}

	/**
	 * Returns new vector, adding elements with the same index.
	 */
	public Vector vectorAdd(Vector other) {

		/*
			[1 2 3 4] + [0 0 0 0]     => [1 2 3 4]
			[1 2 3 4] + [4 4 4 4]     => [5 6 7 8]
			[1 2 3 4] + [1 2 3 4]     => [2 4 6 8]
			[2 2 2 2] + [-1 -1 -1 -1] => [1 1 1 1]
		*/
		Vector vector_add = new Vector(length);
		// Add two vector together
		for(int i = 0; i < length; i++){
			vector_add.elements[i] = this.elements[i] + other.elements[i];
		}
		return vector_add;
	}

	/**
	 * Returns new vector, multiplying elements with the same index.
	 */
	public Vector vectorMultiply(Vector other) {

		/*
			[1 2 3 4] x [0 0 0 0]     => [0 0 0 0]
			[1 2 3 4] x [1 1 1 1]     => [1 2 3 4]
			[1 2 3 4] x [1 2 3 4]     => [1 4 9 16]
			[2 2 2 2] x [-1 -1 -1 -1] => [-2 -2 -2 -2]
		*/
		Vector v_mul = new Vector(length);
		// multiply the two vector
		for(int i = 0; i< length; i++){
			v_mul.elements[i] = this.elements[i] * other.elements[i];
		}
		return v_mul;
	}

	// ===========================================================================
	// VECTOR COMPUTATIONS
	// ===========================================================================

	/**
	 * Returns the sum of all elements.
	 */
	public Long getSum() {

		/*
			[0 0 0 0] => 0
			[1 1 1 1] => 4
			[1 2 3 4] => 10
		*/

		// Calculate and store the sum when unknown
		long sum = 0;
		for(int i = 0; i < length; i++){
			sum += this.elements[i];
		}

		return sum;
	}

	/**
	 * Returns the most frequently occuring element
	 * or -1 if there is no such unique element.
	 */
	public Long getMode() {

		/*
			[1]       => 1
			[2 2]     => 2
			[2 4 4]   => 4
			[1 2 3 4] => -1
		*/
		long count = 0; // number of repeated value
		long prev_count = 0;
		long mode = -1;


	    for (int i = 0; i < length; i++) {

	        for (int j = i; j < length; j++) {

	            if (i != j && elements[i] == elements[j]) {
	                count++;

					// identify the mode value of the vector
	                if (count >= prev_count) {
	                    mode = elements[i];
	                }

	                prev_count = count; // record the count for future use
	            }

	            count = 0; // reset the current counter
	        }
	    }
	    return mode;
	}

	/**
	 * Returns the upper median.
	 */
	public Long getMedian() {

		/*
			[1] => 1
			[1 2] => 2
			[1 2 3] => 2
			[1 1 1 1] => 1
		*/

		return this.median;
	}

	/**
	 * Returns the smallest value in the vector.
	 */
	public Long getMinimum() {

		/*
			[1 1 1 1] => 1
			[1 2 3 4] => 1
			[4 3 2 1] => 1
		*/

		// sort the vector
		Arrays.sort(this.elements);
		// minimum = first elements
		minimum = this.elements[0];

		return this.minimum;
	}

	/**
	 * Returns the largest value in the vector.
	 */
	public Long getMaximum() {

		/*
			[1 1 1 1] => 1
			[1 2 3 4] => 4
			[4 3 2 1] => 4
		*/
		// Sort the Arrays
		Arrays.sort(elements);
		// maximum = the late value
		maximum = this.elements[length-1];

		return this.maximum;
	}

	/**
	 * Returns the frequency of the value in the vector.
	 */
	public long getFrequency(long value) {

		/*
			[1 2 3 4] 0 => 0
			[1 2 3 4] 1 => 1
			[1 1 1 1] 1 => 4
		*/

		long fequency = 0;

		// loop through the vector and find the repeated value
		for(int i = 0; i < length;i++){
			if(this.elements[i] == value){
				fequency++;
			}
		}

		return fequency;
	}

	// ===========================================================================
	// DISPLAY OPERATIONS
	// ===========================================================================

	/**
	 * Displays the vector.
	 */
	public void display() {

	//Display each element in the vector seperated by a space.

	 	for(int i = 0; i < length; i++){
		 	System.out.println(elements[i]+" ");
	    }
	}

	/**
	 * Displays the element at the specified index.
	 */
	public void displayElement(int index) {

		//Display the element at the given index.

		System.out.println(elements[index]);
	}

	// ===========================================================================
	// ACCESSOR METHODS
	// ===========================================================================

	/**
	 * Returns the vector length.
	 */
	public int getLength() {

		return this.length;
	}

	/**
	 * Returns the vector elements.
	 */
	public long[] getElements() {

		return this.elements;
	}
}
