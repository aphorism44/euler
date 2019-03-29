package euler;

public class Euler40 {

	public static void main(String[] args) {
		
		StringBuilder numberB = new StringBuilder();
		for (int i = 1; i < 300000; i++) {
			numberB.append(String.valueOf(i));
		}
		String nString = numberB.toString();
		
		int product = 1;
		for (int i = 1; i < 1000000 ; i *= 10) {
			int n = Integer.valueOf(nString.substring(i - 1, i));
			product *= n;
		}
		System.out.println(product);
	}
	
}

