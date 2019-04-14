package euler;

import java.util.ArrayList;
import java.util.HashSet;

/*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n-1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n-1)	 	1, 6, 15, 28, 45, ...

It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.
 */


public class Euler45 {

	public static void main(String[] args) {
		//no upper limit given
		ArrayList<Long> tArray = getTriangulars(100000);
		ArrayList<Long> pArray = getPentagonals(100000);
		ArrayList<Long> hArray = getHexagonals(100000);
		
		HashSet<Long> pSet = new HashSet<Long>(pArray);
		HashSet<Long> hSet = new HashSet<Long>(hArray);
		
		//tArray.forEach(a -> System.out.println(a));
		//pArray.forEach(a -> System.out.println(a));
		//hArray.forEach(a -> System.out.println(a));
		
		
		long triangular = 0;
		for (int i = 285; i < tArray.size(); i++) {
			long t = tArray.get(i);
			if (pSet.contains(t) && hSet.contains(t)) {
				System.out.println("i: " + (i + 1) + ": " + ", t: " + t);
				triangular = t;
				break;
			}
		}
		System.out.println(triangular);
	}

	
	public static ArrayList<Long> getTriangulars(int max) {
		ArrayList<Long> triangulars = new ArrayList<Long>();
		for (long i = 1; i <= max; i++) {
			long triangular = (i * (i + 1)) / 2;
			triangulars.add(triangular);
		}
		return triangulars;
	}
	
	public static ArrayList<Long> getPentagonals(int max) {
		ArrayList<Long> pentagonals = new ArrayList<Long>();
		for (long i = 1; i <= max; i++) {
			long pentagonal = (i * ((3 * i) - 1)) / 2;
			pentagonals.add(pentagonal);
		}
		return pentagonals;
	}
	
	public static ArrayList<Long> getHexagonals(int max) {
		ArrayList<Long> hexagonals = new ArrayList<Long>();
		for (long i = 1; i <= max; i++) {
			long hexagonal = i * ((2 * i) - 1);
			hexagonals.add(hexagonal);
		}
		return hexagonals;
	}
	
}