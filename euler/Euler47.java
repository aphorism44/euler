package euler;

import java.util.ArrayList;
import java.util.HashSet;
import helpers.sieveEratosthenes;

/*

The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2^2 × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

 */

public class Euler47 { 
	
	public static void main(String[] args) {
		int max = 20;
		int targetRun = 2;
		
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(max);
		HashSet<HashSet<Integer>> currentRunFactors = new HashSet<HashSet<Integer>>();
		for (int i = 4; i < max; i++) {
			//factorize with primes
			HashSet<Integer> currentPrimeFactorization = new HashSet<Integer>();
			int index = 0;
			int n = i;
			while (n > 1) {
				int prime = primes.get(index);
				int currentFactor = 1;
				while (n % prime == 0) {
					currentFactor *= prime;
					n /= prime;
				}
				if (currentFactor > 1)
					currentPrimeFactorization.add(currentFactor);
				index++;
			}
			System.out.println(i + " has the following prime factors:");
			for (int cpf: currentPrimeFactorization)
				System.out.print(cpf + " ");
			System.out.println();
			
			//check if it has unique factors from last ones
			boolean unique = true;
			if (currentRunFactors.size() == 0 && currentPrimeFactorization.size() > 1) {
				break;
			} else if (currentPrimeFactorization.size() > 1) {
				for (HashSet<Integer> hs:  currentRunFactors) {
					if (hs.size() == currentPrimeFactorization.size()) {
						for (int factor: currentPrimeFactorization) {
							if (hs.contains(factor)) {
								unique = false;
								break;
							}
						}
					} else {
						unique = false;
						break;
					}
				}
			} else {
				unique = false;
			}
			
			System.out.println("unique: " + unique);
			if (unique)
				currentRunFactors.add(currentPrimeFactorization);
			else
				currentRunFactors.clear();
			
			
			if (currentRunFactors.size() == targetRun) {
				System.out.println("found answer: " + i);
				break;
			}
		}
		
		
	}
}