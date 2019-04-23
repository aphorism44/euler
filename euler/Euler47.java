package euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import helpers.sieveEratosthenes;

/*

The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

 */

public class Euler47 { 
	
	public static void main(String[] args) {
		int max = 1000000;
		int targetRun = 4;
		int targetConsecutive = 4;
		
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(max);
		HashMap<Integer, HashSet<Integer>> currentRunFactors = new HashMap<Integer, HashSet<Integer>>();
		int primeSize = primes.size();
		for (int i = 4; i < max; i++) {
			//factorize with primes
			HashSet<Integer> currentPrimeFactorization = new HashSet<Integer>();
			int temp = i;
			int primeIndex = 0;
			while (primeIndex < primeSize && temp > 1) {
				int currentPrime = primes.get(primeIndex);
				while (temp % currentPrime == 0) {
					currentPrimeFactorization.add(currentPrime);
					temp /= currentPrime;
				}
				primeIndex++;
			}
			//System.out.println(i + " has " + currentPrimeFactorization.size() + " unique prime factor(s): ");
			//currentPrimeFactorization.stream().forEach(p -> System.out.print(p + " ")); 
			//System.out.println();
			
			if (currentPrimeFactorization.size() == targetRun)
				currentRunFactors.put(i, currentPrimeFactorization);
			else
				currentRunFactors.clear();
			
			if (currentRunFactors.size() == targetConsecutive) {
				currentRunFactors.forEach((key, value) -> System.out.println(key + ", " + value));
				break;
			}
			
			
		}
		
	}
}