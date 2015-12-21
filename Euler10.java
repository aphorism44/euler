
import java.util.*;
import java.math.*;

public class Euler10 {

   public static void main(String[] args) {
   
      /*sum of all primes less than 2,000,000*/
      /* use sieve of Eratosthenes from Euler 3 */    
            
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
      
      
     
      int count = 0, lastPrimeK = 0;
      long primeSum = 0; //this must be a long or we get bad answer...grr...
       
      for (int k = 2; k < largestPrime; k++) {
         if (primes.get(k) == true && k < 2000000) {
            primeSum += k;
            lastPrimeK = k;
            count++;
         } 
      }
      
      
       
     System.out.println("we have this many primes: " + count);
     System.out.println("the largest prime less than 2 mission is: " + lastPrimeK);
     System.out.println("sum: " + primeSum);
     /*
      above returns:
      148933 primes, largest 1999993, sum 142913828922
      */
         
   }//end main method
   

}