package euler;

import java.util.ArrayList;

import helpers.factorial;

/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 */

public class Euler34 {
	
	public static void main(String[] args) {
		
		//to save time, all we need is the factorial of 0-9
		int[] factorials = new int[10];
		for (int f = 0; f < 10; f++)
			factorials[f] = factorial.getFactorial(f);
		
		//below is for my personal reference
		ArrayList<Integer> curious = new ArrayList<Integer>();
		int finalSum = 0;
		
		//NOTE - not sure how to calculate upper bound here; just increased until there were no more
		//curious numbers found
		for (int i = 3; i < 10000000; i++) {
			int temp = i, sum = 0;
			while (temp > 0) {
				int rem = temp % 10;
				sum += factorials[rem];
				temp /= 10;
			}
			//System.out.println(i + ", " + sum);
			if (i == sum) {
				finalSum += i;
				curious.add(i);
			}
		}
		
		for (int j: curious)
			System.out.print(j + ",");
		System.out.println();
		System.out.println("finalSum: " + finalSum);
		
	}
	
}
