package helpers;

public class factorial {

	public static int getFactorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (n < 0)
			return -1;
		
		int fact = 1;
		for (int i = n; i > 0; i--) {
			fact *= i;
		}
		
		return fact;
		
	}
	
}
