package euler;

import java.util.ArrayList;

import helpers.combinatorics;
import helpers.sieveEratosthenes;

/*
 
 We shall say that an n-digit number is pandigital if it makes use of 
 all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital
 and is also prime.

What is the largest n-digit pandigital prime that exists?
 
 */


public class Euler41 {

	public static void main(String[] args) {
		
		int largestPandigital = 0;
		
		//s = length of pandigital; example shows we can get at least 4 digits; no upper bound given
		//NOTE - this brute force solution would be too slow if we had to handle
		//pandigits of max length (9 digits long)
		for (int s = 4; s < 9; s++) {
			//System.out.println("size: " + s);
			int digits = 0;
			for (int i = 1; i <= s; i++)
				digits += i * Math.pow(10, i - 1);
			ArrayList<Integer> allPandigits = combinatorics.getIntPermutations(digits);
			for (int pd: allPandigits) {
				if (sieveEratosthenes.isPrime(pd)) {
					if (pd > largestPandigital) {
						largestPandigital = pd;
					}
				}
			}
		}
		System.out.println(largestPandigital);
		
	}
	
}