package euler;

import java.util.ArrayList;
import helpers.sieveEratosthenes;
import helpers.combinatorics;

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 
NOTE - this solves it, but takes about 30 seconds...
  
 */

public class Euler35 {
	
	public static void main(String[] args) {
		
		//long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(1000000);
		//ArrayList<Integer> circularPrimes = new ArrayList<Integer>(); //testing only
		int numCircularPrimes = 0;
		
		for (int i: primes) {
			ArrayList<Integer> rotations = combinatorics.getIntRotations(i);
			boolean isCircularPrime = true;
			for (int r: rotations) {
				if (!primes.contains(r)) {
					isCircularPrime = false;
					break;
				}
			}
			if (isCircularPrime) {
				//circularPrimes.add(i);
				numCircularPrimes++;
			}
			
		}
		
		System.out.println("Circular primes: " + numCircularPrimes);
		//for (int n: circularPrimes)
			//System.out.println(n);
		
		//long endTime = System.currentTimeMillis();
		//System.out.println("That took " + (endTime - startTime) / 1000 + " seconds");
		
	}
	
}
