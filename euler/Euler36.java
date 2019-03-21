package euler;


import helpers.combinatorics;
/*

The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

 */


public class Euler36 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 1; i < 1000000; i++) {
			String base10 = String.valueOf(i);
			String base2 = Integer.toBinaryString(i);
			
			if (combinatorics.isStringPalindrome(base10) && combinatorics.isStringPalindrome(base2))
				sum += i;
			
		}
		
		System.out.println("Sum: " + sum);
	}
	
	
	
	
	
	
	
}
