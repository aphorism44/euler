package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import helpers.combinatorics;
import helpers.sieveEratosthenes;

/*

The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: 
(i) each of the three terms are prime, and, 
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

NOTE - one of the "properties" they're looking for is specifically the "3330" difference, which
is _not_ made clear in the instructions.
 */

public class Euler49 { 
	
	public static void main(String[] args) {
		int targetDifference = 3330;
		HashSet<Integer> alreadyChecked = new HashSet<Integer>();
		for (int i = 1000; i < 10000; i++) {
			if (!alreadyChecked.contains(i)) {
				ArrayList<Integer> perms = combinatorics.getIntPermutations(i);
				ArrayList<Integer> integerCheck = new ArrayList<Integer>();
				boolean checkPrimes = false;
				for (int perm: perms) {
					alreadyChecked.add(perm);
					if (String.valueOf(perm).length() == 4 && sieveEratosthenes.isPrime(perm)) {
						integerCheck.add(perm);
					}
				}
				//to save time...
				if (integerCheck.size() >= 3) {
					checkPrimes = true;
					Collections.sort(integerCheck);
				} else {
					continue;
				}
				
				if (checkPrimes) {
					HashSet<Integer> differencePairs = new HashSet<Integer>();
					for (int j = 0; j < integerCheck.size() - 1; j++) {
						for (int k = j + 1; k < integerCheck.size(); k++) {
							if (integerCheck.get(k) - integerCheck.get(j) == targetDifference) {
								differencePairs.add(integerCheck.get(k));
								differencePairs.add(integerCheck.get(j));
							}
						}
					}
					if (differencePairs.size() == 3) {
						System.out.println("found answer for " + i);
						differencePairs.forEach((n)-> {
							System.out.print(n);
						});
						System.out.println();
					}
					
				}	
			}
		}
		
		
		
	}
}