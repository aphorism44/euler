package euler;

import java.util.ArrayList;

import helpers.sieveEratosthenes;

/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, 
contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

NOTE - took almost 20 seconds; could be optimized.

 */

public class Euler50 { 
	
	public static void main(String[] args) {
		int max = 1000000;
		int answerPrime = 0;
		int maxSumElements = 0;
		
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(max);
		
		for (int i = 0; i < primes.size(); i++) {
			int currentPrime = primes.get(i);
			//System.out.println("currentPrime: " + currentPrime);
			int tempSum = 0;
			int tempCount = 0;
			int j = 0;
			while (j < primes.size()) {
				tempSum += primes.get(j);
				//System.out.println("tempSum: " + tempSum);
				tempCount++;
				if (tempSum == currentPrime) {
					if (tempCount > maxSumElements) {
						answerPrime = currentPrime;
						maxSumElements = tempCount;
					}
					j = primes.size();
					tempSum = 0;
					tempCount = 0;
				} else if (tempSum > currentPrime) {
					j -= tempCount - 2;
					tempSum = 0;
					tempCount = 0;
				} else {
					j++;
				}
			}
		}
		
		System.out.println("Longest sum: " + maxSumElements);
		System.out.println("Prime: " + answerPrime);
		
	}
}