package euler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


import helpers.combinatorics;
import helpers.sieveEratosthenes;

/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.


 */


public class Euler43 {

	public static void main(String[] args) {
		int[] primes =  {17,13,11,7,5,3,2 };
		//yields 10!, or about 3.6 million permutations
		ArrayList<String> pandigs = combinatorics.getStringPermutations("0123456789");
		//ArrayList<Long> divisibles = new ArrayList<Long>(); //testing only
		long total = 0;
		
		
		for (int i = 0; i < pandigs.size(); i++) {
			String pan = pandigs.get(i);
			
			int num17 = Integer.valueOf(pan.substring(7, 10));
			int num13 = Integer.valueOf(pan.substring(6, 9));
			int num11 = Integer.valueOf(pan.substring(5, 8));
			int num7 = Integer.valueOf(pan.substring(4, 7));
			int num5 = Integer.valueOf(pan.substring(3, 6));
			int num3 = Integer.valueOf(pan.substring(2, 5));
			int num2 = Integer.valueOf(pan.substring(1, 4));
			
			if (num17 % 17 != 0)
				continue;
			if (num13 % 13 != 0)
				continue;
			if (num11 % 11 != 0)
				continue;
			if (num7 % 7 != 0)
				continue;
			if (num5 % 5 != 0)
				continue;
			if (num3 % 3 != 0)
				continue;
			if (num2 % 2 != 0)
				continue;
			//System.out.println("Adding " + pan);
			//divisibles.add(Long.valueOf(pan));
			total += Long.valueOf(pan);
			
		}
		
		System.out.println("total: " + total);
		
		
	}
	
	
	
	
	
	
	
}
