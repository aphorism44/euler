package euler;

import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler16 {


   public static void main(String[] args) {
   
      
      /* Power digit sum */
      /* 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
      What is the sum of the digits of the number 2^1000?     */ 

      BigInteger n = new BigInteger("2");
      BigInteger power = bigPow(n, 1000);
      String parse = power.toString();
     
      System.out.println(parse);
     
     int sum = 0;
     
     for (int i = 0; i < parse.length(); i++) {
         int d = Character.getNumericValue(parse.charAt(i));
         sum += d;
      }
     
       System.out.println(sum);
      //1366
        
   } //end main method
   
   //need special function to handle BigInt pow
   public static BigInteger bigPow(BigInteger n, int exp) {
          BigInteger result = BigInteger.ONE;
          
          for (int i = 0; i < exp; i++)
            result = result.multiply(n);
         
         return result;  
      }
  

} //end class