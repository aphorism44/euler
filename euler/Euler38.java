package euler;

import java.util.ArrayList;
import java.util.HashSet;

import helpers.combinatorics;

/*

Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

 */


public class Euler38 {

	public static void main(String[] args) {
		//if n > 1, the upper bound can't be more than 5 digits
		int upperBound = 50000;
		long largestPandig = 0;
		
		//first grab all the possible pandigital numbers and put them in a set
		ArrayList<String> pandigsList = combinatorics.getStringPermutations("123456789");
		HashSet<String> pandigs = new HashSet<String>(pandigsList);
			
		for (int n = 2; n < upperBound; n++) {
			int multiplier = 1;
			String digit = "";
			while (digit.length() < 9) {
				int temp = n * multiplier;
				digit = digit + String.valueOf(temp);
				multiplier++;
			}
			if (digit.length() == 9) {
				if (pandigs.contains(digit)) {
					System.out.println("addding " + digit);
					if (Long.valueOf(digit) > largestPandig)
						largestPandig = Long.valueOf(digit);
				}
			}
			
		}
		
		System.out.println("largest: " + largestPandig);
		
		
	}
	
	
}
