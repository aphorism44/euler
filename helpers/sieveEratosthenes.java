package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class sieveEratosthenes {

	public static ArrayList<Integer> getPrimes(int max) {
		
		
		HashMap<Integer, Boolean> primeCheck = new HashMap<Integer, Boolean>();
	      
	      for (int p = 2; p < max; p++) {
	    	  primeCheck.put(p, true);
	      }
	      
	      
	      for (int i = 2; i < max; i++) {
	          if (primeCheck.get(i) == true) {
	             for (int j = 2 * i; j < max; j += i) {
	            	 primeCheck.put(j, false);
	             }
	          }
	       }
	      
	      ArrayList<Integer> primes = new ArrayList<Integer>();
	      for (Entry<Integer, Boolean> entry : primeCheck.entrySet()) {
	    	    if (entry.getValue())
	    	    	primes.add(entry.getKey());
	    	}
		
		return primes;
	}
	
}
