package euler;

import helpers.factorial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2*1^2
15 = 7 + 2*2^2
21 = 3 + 2*3^2
25 = 7 + 2*3^2
27 = 19 + 2*2^2
33 = 31 + 2*1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 
 NOTE - composite numbers are a positive integer that can be formed by MULTIPLYING two smaller positive 
 integers (where neither integer is 1). Also, except for 1, all numbers are either prime or composite.
 
 4 is the smallest composite number (since we want odds only, we start at 5).
 
 */
public class Euler46 { 
	public static void main(String[] args) {
		int max = 10000;
		ArrayList<Integer> primeList = helpers.sieveEratosthenes.getPrimes(max);
		HashSet<Integer> primeSet = new HashSet<Integer>(primeList);
		for (int i = 5; i <= max; i += 2) {
			//only looking at composite numbers; a number is
			//either composite or prime
			boolean fitsConjecture = false;
			if (!primeSet.contains(i)) {
				for (int j = primeList.size() - 1; j >= 0; j--) {
					int temp = i;
					int currentPrime = primeList.get(j);
					int remainder = temp - currentPrime;
					//if odd, it can't be twice a square
					if (remainder > 0 && remainder % 2 == 0) {
						remainder /= 2;
						//check if this is a square
						double sqrt = Math.sqrt(remainder);
						//System.out.println("i: " + i + ", prime: " + currentPrime + ", remainder: " + remainder
						//	+ ", sqrt of remainder: " + sqrt);
						if (sqrt % 1 == 0) {
							fitsConjecture = true;
							break;
						}
					}
					
				}
				if (!fitsConjecture) {
					System.out.println("found answer: " + i);
					break;
				}
			}
			
		}
		
	}


	
}