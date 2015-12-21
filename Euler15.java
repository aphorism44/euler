
import java.math.*;
import java.util.*;

public class Euler15 {


   public static void main(String[] args) {
   
      
      /* Lattice paths */
      /* if you start from topLeft, can only move right and down, there are 6 routes to bottom right in 2 x 2 grig */
      /* How many routes in a 20 x 20 grid?    
      --SOLUTION - create a 40-digit long binary number (2^40 possibilities); each one where the 1s sum to 20 is a solution
      --involves gray code generation - after alot of study tracked it down to Knuth's vol. 4, p. 362, "Gray codes for combinations"
      -- called a "revolving door combination"
      --AND AFTER ALL MY STUDIES THE ANSWER IS IN BASIC COMBINATORICS!!!
      CHOOSE N OVER K
      HERE, CHOOSE 40 OVER 20
      choose(n,k) = n! / (n-k)! k!
     */ 

      BigInteger n = new BigInteger("40");
      BigInteger k = new BigInteger("20");
      BigInteger nFac = factorial(n);
      BigInteger kFac = factorial(k);
      
      BigInteger paths = nFac.divide(kFac.multiply(kFac));
     
      System.out.println(paths);
      //137846528820
        
   } //end main method
   
   //made factorial!
   public static BigInteger factorial(BigInteger n) {
          if(n.intValue() == 1 || n.intValue() == 0)
              return BigInteger.ONE;
          else
              return n.multiply(factorial(n.subtract(BigInteger.ONE)));
      }
  
   //below 2 methods are too slow
   public static ArrayList<Integer>  createGrayCount(int n) {
      if (n == 1) {
         ArrayList<Integer> newList = new ArrayList<Integer>();
         //the answer is two, since:
         //{0}, {1}, only 1 makes it
         newList.add(1);
         newList.add(0);
         return newList;
         
      } else {
         ArrayList<Integer> lastCount = createGrayCount(n - 1);
         ArrayList<Integer> newCount = new ArrayList<Integer>();
         //create 2 arrays - to one add 1, the other add 0, and concat the results
         for (int k: lastCount) {
           if  (k == 1) {
            
           } else {
           
           }
           if (k == n/2 || k + 1 == n/2)
               newCount.add(1);
           newCount.add(0);
           
           //newCount.add(k);
           //newCount.add(k+1);
         }
       return newCount;
      }
   }

   
   
   public static ArrayList<BitSet> createGrayCode(int n) {
      if (n == 1) {
         ArrayList<BitSet> newList = new ArrayList<BitSet>();
         BitSet zero = new BitSet(1);
         BitSet one = new BitSet(1);
         one.set(0);
         newList.add(zero);
         newList.add(one);
         return newList;
      } else {
         ArrayList<BitSet> lastList = createGrayCode(n - 1);
                  
         ArrayList<BitSet> lastListReversed = lastList; 
         for (BitSet temp: lastListReversed) {
            temp.flip(0, n-1);
         } 
         
         ArrayList<BitSet> L1 = new ArrayList<BitSet>();
         ArrayList<BitSet> L2 = new ArrayList<BitSet>();
         
         //copy with 0 in front
         for (BitSet temp: lastList) {
            BitSet n1 = new BitSet(n);
            for (int i = 0; i < n; i++) {
               if (temp.get(i))
                  n1.set(i + 1);
            }
           L1.add(n1);             
         }
         
         //copy with 1 in front
         for (BitSet temp: lastListReversed) {
            BitSet n2 = new BitSet(n);
            n2.set(0);
            for (int i = 0; i < n; i++) {
               if (temp.get(i))
                  n2.set(i + 1);
            }
           L2.add(n2);             
         }
         
         L1.addAll(L2);
         
         return L1;
      }
   }


} //end class