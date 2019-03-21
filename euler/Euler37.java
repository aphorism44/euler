package euler;

import java.util.ArrayList;

import helpers.sieveEratosthenes;

/*

The number 3797 has an interesting property. Being prime itself, it is possible to continuously 
remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. 
Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

 */


public class Euler37 {

	public static void main(String[] args) {
		
		int upperBound = 1000000;
		
		ArrayList<Integer> primes = sieveEratosthenes.getPrimes(upperBound);
		//remove single digit primes, as explained in instructions
		primes.remove(Integer.valueOf(2));
		primes.remove(Integer.valueOf(3));
		primes.remove(Integer.valueOf(5));
		primes.remove(Integer.valueOf(7));
		
		//used to check since we were given no upper bound
		ArrayList<Integer> truncPrimes = new ArrayList<Integer>();
		int sum = 0;
		
		for (int prime: primes) {
			String strP_LR = String.valueOf(prime);
			String strP_RL = String.valueOf(prime);
			boolean truncatable = true;
			while (true) {
				strP_LR = strP_LR.substring(1);
				if (strP_LR.length() < 1)
					break;
				if (!sieveEratosthenes.isPrime(Integer.valueOf(strP_LR))) {
					truncatable = false;
					break;
				}
			}
			
			if (truncatable) {
				while (true) {
					strP_RL = strP_RL.substring(0, strP_RL.length() - 1);
					if (strP_RL.length() < 1)
						break;
					if (!sieveEratosthenes.isPrime(Integer.valueOf(strP_RL))) {
						truncatable = false;
						break;
					}
				}
			}
			
			if (truncatable) {
				System.out.println("adding " + prime);
				truncPrimes.add(prime);
				sum += prime;
			}
		}
		
		if (truncPrimes.size() == 11) {
			System.out.println("Sum: " + sum);
		} else {
			System.out.println("We only found " + truncPrimes.size() + " truncatable primes.");
		}
		
	}
	
	
	//need to check if the leading number is a 0, which accelerates stripping
	public static boolean hasLeadingZero(String numStr) {
		String checkNum = String.valueOf(Integer.valueOf(numStr));
		if (checkNum.length() < numStr.length())
			return true;
		return false;
	}
	
	
	
	
}
