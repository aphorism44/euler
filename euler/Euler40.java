package euler;

public class Euler40 {

	public static void main(String[] args) {
		
		StringBuilder numberB = new StringBuilder();
		for (int i = 1; i < 300000; i++) {
			numberB.append(String.valueOf(i));
		}
		String nString = numberB.toString();
		System.out.println(nString.length());
		int int1 = Integer.valueOf(Character.toString(nString.charAt(0)));
		System.out.println(int1);
		int int2 = Integer.valueOf(Character.toString(nString.charAt(9)));
		System.out.println(int2);
		int int3 = Integer.valueOf(Character.toString(nString.charAt(99)));
		System.out.println(int3);
		int int4 = Integer.valueOf(Character.toString(nString.charAt(999)));
		System.out.println(int4);
		int int5 = Integer.valueOf(Character.toString(nString.charAt(9999)));
		System.out.println(int5);
		int int6 = Integer.valueOf(Character.toString(nString.charAt(99999)));
		System.out.println(int6);
		int int7 = Integer.valueOf(Character.toString(nString.charAt(999999)));
		System.out.println(int7);
		
		int product = 1;
		for (int i = 1; i < 1000000 ; i *= 10) {
			int n = Integer.valueOf(nString.substring(i - 1, i));
			System.out.println(n);
			product *= n;
		}
		System.out.println(product);
	}
	
}

