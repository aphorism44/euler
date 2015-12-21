
import java.math.*;
import java.util.*;

public class Euler12 {

   public static void main(String[] args) {
   
      
      /* triangle numbers are formed by adding natural numbers*/
      /* the 1st is 1, 2nd is 1 + 2 = 3, 3rd is 1 + 2 + 3 = 6 ...7th is 28*/    
      /* list the factors of the divisors; 28 is first triangular to have more than five divisors */
      /*
          1: 1
          3: 1,3
          6: 1,2,3,6
         10: 1,2,5,10
         15: 1,3,5,15
         21: 1,3,7,21
         28: 1,2,4,7,14,28
      */
      /*what is value of 1st triangular number with more than 500 divisors? */
      /*TRICK: USE PRIME FACTORS (use sieve again) - since brute force doesn't work */
      /* get all the prime factors of each one, then use this math to find number of divisors:*/
      /* if factor is 2^3 + 3^5 + 5 ^2, number of factors is (4 * 6 * 3) */
      
      
      int largestPrime = 1000000;
      
      HashMap<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
      ArrayList<Integer> finalPrimes = new ArrayList<Integer>();
      
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
      
      for (int i = 2; i < largestPrime; i++) {
         if (primes.get(i) == true)
            finalPrimes.add(i);
      } 
      
      //start with 3 since 1 isn't divisible by primes, and we know it's not the answer
      long triangular = 1, factoredTriangular = 1;;
      
      for (int i = 2; i < 50000; i++) {
        
         triangular += i;
        
         
         System.out.println("triangular: " + triangular);
         
         //now get the prime factorization
         factoredTriangular =  triangular;
         ArrayList<Integer> factors = new ArrayList<Integer>();
         Set<Integer> uniqueFactors = new HashSet<Integer>();
         
         int currentPrime = 0;
         
         for (int j = 0; j < finalPrimes.size(); j++) {
            currentPrime = finalPrimes.get(j);
            while (factoredTriangular % currentPrime == 0) {
               factors.add(currentPrime);
               uniqueFactors.add(currentPrime);
               factoredTriangular /= currentPrime;
            }
         }
         
        //System.out.println("prime factors: " +factors);
        
        ArrayList<Integer> multipliers = new ArrayList<Integer>();
        
        //now we need to get the individual prime factors and the numbers of time they appear, then multiplier them together
        Iterator it1 = uniqueFactors.iterator();
        while (it1.hasNext()) {
            int currentNo = Collections.frequency(factors, it1.next());
            currentNo++;
            multipliers.add(currentNo);
        }
        
        //System.out.println("multipliers: " + multipliers);
        
        int count = 1;
        for (int k = 0; k < multipliers.size(); k++) {
            count *= multipliers.get(k);
        }
        
        //System.out.println("count: " + count);
        
        if (count > 500) {
         System.out.println("Found it in triangular: " + triangular);
         //76576500
         break;
        }
        
        
         
      }
      
      
        
   } //end main method


}