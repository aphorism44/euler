package euler;

import java.math.BigInteger;

/*

The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

 */

public class Euler48 { 
	
	public static void main(String[] args) {
		BigInteger total = BigInteger.ZERO;
		int max = 1000;
		int lastDigitsNeeded = 10;
		
		for (int i = 1; i <= max; i++) {
			BigInteger base = new BigInteger(String.valueOf(i));
			BigInteger square = base.pow(i);
			total = total.add(square);
		}
		
		String answer = total.toString();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < lastDigitsNeeded; j++) {
			sb.append(answer.charAt(answer.length() - 1 - j));
		}
		
		//System.out.println(answer);
		System.out.println(sb.reverse());
		
	}
}