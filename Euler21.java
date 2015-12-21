
import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler21 {
  /* Amicable numbers*/
   /*
   Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
   If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
   
   For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
   
   Evaluate the sum of all the amicable numbers under 10000.
   
   METHOD:
   1. get proper divisors of num1 - STORE their sum AS sum1
   2. get proper divisors of sum1 - store that sum as sum2
   3. if num1 = sum2, then add num1 to an array
   4. at end, sum all the numbers in the array
    */
  
   public static void main(String[] args) {
      
      //adding array just to check
      //NOTE - 1 doesn't have any proper divisors
      ArrayList<Integer> amicables = new ArrayList<Integer>();
      int amicableSum = 0;
      
      for (int i = 2; i < 10000; i++) {
         ArrayList<Integer> div1 = getFactorArray(i);
         int sum1 = sumArrayList(div1);
         ArrayList<Integer> div2 = getFactorArray(sum1);
         int sum2 = sumArrayList(div2);
         if (i == sum2 && i != sum1) {
            amicables.add(i);
            amicableSum += i;
         }
            
      }
      
      System.out.println(amicables);
      System.out.println(amicableSum);
      //NOT 40285 or 40284 or 22542 or 31627
      //31626   
   
          
                 
   } //end main method
   
   public static ArrayList<Integer> getFactorArray(int n) {      
      ArrayList<Integer> divisors = new ArrayList<Integer>();
        if (n == 1)
            return divisors;
        divisors.add(1);
        for (int i = 2; i < n; i++){
            if (n % i == 0) 
               divisors.add(i);
        }
        
        return divisors;
   }
   
   public static int sumArrayList(ArrayList<Integer> l) {
     int sum = 0; 
     for (int i = 0; i < l.size(); i++)
         sum += l.get(i);
     return sum;
}

   
} //end class