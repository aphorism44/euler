
import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler20 {
  
  
   public static void main(String[] args) {
      
   /* Factorial digit sum*/
   /*
      n! means n x (n - 1) x ... x 3 x 2 x 1
      
      For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
      and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
      
      Find the sum of the digits in the number 100!

      APPROACH - use big numbers again...

    */
   BigInteger sum = new BigInteger("100");
   
   for (int n = 99; n > 0; n--) {
      sum = sum.multiply(BigInteger.valueOf(n));
   }
   
   String sumStr = sum.toString();
   
   System.out.println(sumStr);
   //93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
 
   int result = 0;
   for (int i = 0; i < sumStr.length(); i++) {
      result += Integer.parseInt(String.valueOf(sumStr.charAt(i)));
   }
   
    System.out.println(result);
    //648         
                 
   } //end main method
   

   
} //end class