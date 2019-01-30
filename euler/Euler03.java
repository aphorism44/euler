package euler;

import java.util.*;
import java.math.*;

public class Euler03 {

   public static void main(String[] args) {
   
      
      /* first use sieve of Eratosthenes to generate all primes up to sqrt of BigInt */    
      /* because of Java's damn use of the BigInteger I had to copy a method to grab its SQRT*/
      BigInteger checkNo = new BigInteger("600851475143");
      
      int largestPrime = sqrt(checkNo).intValue();
      
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
      
      
      System.out.println("this many primes: " + primes.size());
      System.out.println("below are the prime divisors");
      
      for (int k = 2; k < largestPrime; k++) {
         if (primes.get(k) == true) {
            BigInteger div = new BigInteger(Integer.toString(k));
            //System.out.println("prime: " + div);
            BigInteger rem = checkNo.remainder(div);
            //System.out.println("remainder: " + rem);
            if (rem == BigInteger.ZERO)
               System.out.println(k);
         }
      
      }
      
         
      
      
     
     
     
     
          
   
   }
   
   public static BigInteger sqrt(BigInteger x) {
    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
    BigInteger div2 = div;
    // Loop until we hit the same value twice in a row, or wind
    // up alternating.
    for(;;) {
        BigInteger y = div.add(x.divide(div)).shiftRight(1);
        if (y.equals(div) || y.equals(div2))
            return y;
        div2 = div;
        div = y;
    }
}

}