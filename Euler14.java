
import java.math.*;
import java.util.*;

public class Euler14 {

   public static void main(String[] args) {
   
      
      /* longest Collatz sequence */
      /* n > n/2 (n is even) */
      /* n > 3n + 1 (n is odd)   */    
      /* starting with 13, you get: 3 > 40 > 20 > 10 > 5 > 16 > 8 > 4 > 2 > 1 */
      /* this has 10 terms, and we believe akk starting numbers finish at 1  */
      /* which starting number, less than 1 million, produces longest chain? */
      
      /* here's how I'll do it: 
      convert them to strings, then to BIGINTEGER (coarse but it works fine)
      */  
      
      long largestChain = 0, winner = 0;
      /*to limit calls to collatzSequence function, keep track of past results from it*/
      HashMap<Long, Long> collatzResults = new HashMap<Long, Long>();
      
      for (long i = 13; i < 1000000; i++) {
         long count = 0, checkNo = i;
         while (checkNo != 1) {
            if (collatzResults.containsKey(checkNo)) {
               count += collatzResults.get(checkNo);
               break;
            } else {
               count++;
               checkNo = collatzSequence(checkNo);
            }
         }
         //add 1 since the above doesn't count 1 in the chain
         collatzResults.put(i, count + 1);
         
         if (count + 1 > largestChain) {
            largestChain = count + 1;
            winner = i;
         }

      }
            
      
      System.out.println("winner: " + winner);
      System.out.println("largestChain: " + largestChain);
      //837799 with chain of 553      
        
        
   } //end main method

   
   public static long collatzSequence(long n) {
      if (n % 2 == 0)
         return n / 2;
      else
         return 3 * n + 1;
   }

}