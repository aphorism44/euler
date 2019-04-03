package euler;


/*

If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p <= 1000, is the number of solutions maximized?

 */


public class Euler39 {

	public static void main(String[] args) {
		
		int maxNumSolutions = 0, pValue = 0;
		for (int p = 3; p <= 1000; p++) {
			int numSolutions = 0;
			
			for (int a = 1; a < p; a++) {
				for (int b = 1; b + a < p; b++) {
					int c = p - (a + b);
					if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
						numSolutions++;
				}
			}
			
			
			if (numSolutions > maxNumSolutions) {
				maxNumSolutions = numSolutions;
				pValue = p;
			}
		}
		
		System.out.println("pValue: " + pValue + ", maxNumSolutions: " + maxNumSolutions);
		
	}
	
	
}
