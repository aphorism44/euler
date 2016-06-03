import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler25 {

   /*
  The Fibonacci sequence is defined by the recurrence relation:
Fn = Fn - 1 + Fn - 2, where F1 = 1 and F2 = 1

Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?   */

   public static void main(String args[]) {
          
       //the key here is to use an iterative, rather than recursive, method to generate the numbers
       //also, we need to use BigInteger for the 1000 digits
       BigInteger minusOne = BigInteger.ONE;
       BigInteger minusTwo = BigInteger.ONE;
       BigInteger currentFib = BigInteger.ZERO;
       int length = currentFib.toString().length();
        
       int index = 2;
       while (length < 1000) {
            
            currentFib = minusOne.add(minusTwo);
            index++;
            
            length = currentFib.toString().length();
            minusTwo = minusOne;
            minusOne = currentFib;
       }
       System.out.println(currentFib.toString().length());
       System.out.println(index);
   
   }

}