package euler;

import java.util.ArrayList;
import helpers.sieveEratosthenes;
import helpers.combinatorics;

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 * 
 */

public class Euler35 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		
		for (int i: ints)
			System.out.println(i);
		
		ints = combinatorics.getIntPermutations(ints);
		
		for (int i: ints)
			System.out.println(i);
		
		/*
		 * 
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(100);
		ArrayList<Integer> circularPrimes = new ArrayList<Integer>();
		int numCircularPrimes = 0;
		
		for (int i: primes) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int temp = i;
			while (temp > 0) {
				digits.add(temp % 10);
				temp /= 10;
			}
			
			if (digits.size() == 1) {
				circularPrimes.add(i);
				numCircularPrimes++;
			} else {
				//perform permutations
				ArrayList<Integer> permutations = new ArrayList<Integer>();
				for (int index = 0; index < digits.size(); index++) {
					int firstInt = 
				}
				
			}
		}
		*/
		
	}
	
}
