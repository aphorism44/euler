
import java.util.*;
import java.math.*;

public class Euler7 {

   public static void main(String[] args) {
   
      /*10001st prime*/
      /* use sieve of Eratosthenes from Euler 3 */    
     /* first use sieve of Eratosthenes to generate  enough primes */    
      /* then find the prime we need */
            
      int largestPrime = 2000000;
      
      HashMap<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
      
      for (int p = 2; p < largestPrime; p++) {
         primes.put(p, true);
      }
      
      for (int i = 2; i < largestPrime; i++) {
         if (primes.get(i) == true) {
            for (int j = 2 * i; j < largestPrime; j += i) {
               primes.put(j, false);
            }
         }
      }
      
      
     
      
      ArrayList<Integer> finalPrimes = new ArrayList<Integer>();
      
      int count = 0;
      for (int k = 2; k < largestPrime; k++) {
         if (primes.get(k) == true) {
            finalPrimes.add(k);
            count++;
         } 
      }
      
     System.out.println("we have this many primes: " + count);
     System.out.println(finalPrimes.get(10000));
     
      /*
      above returns:
      41534 primes, 104743:
      */
         
   }//end main method
   

}