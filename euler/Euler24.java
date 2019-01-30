package euler;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Euler24 {
  /* Lexicographic permutations*/
   /*

   A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
   of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
   we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

      012   021   102   120   201   210

   What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
    
    --INSIGHT - in order to do this, think recursively
   --n digits have n! permutations
   --when you check permutations, you basically all the first n-k digits
      in place, then shift around the final k digits until you get all permutations
   --e.g., for example givien, you start with lowest perm 012, permuate the smallest possible unit (2 = k; last 2 digits; permutated just by swapping them)
        , then move to the (k+1)th-from-end digit, place the next largest digit (from last 2 digits into it), then permuate the remaining
   
   
      1. 
   
      1.take the last 2 digits
      2. switch them
      3. swap the digit immediately to the left with the smallest digit of those 2
      4. goto 1
      
      
   
   
    
    */
  
   public static void main(String[] args) {
      
      JOptionPane.showMessageDialog(null, "Broken by J2");
      
      /*
      int[] digits = {0,1,2};//{0,1,2,3,4,5,6,7,8,9};
      int swap;
      int permutations = 0;
      
      for (int k = 2; k <= digits.length; k++) {
         for (int j = k; j >= 2; j--) {
            //if you're down to the last 2, then swap them and swap the next highest
            if (j == 2) {
               //swap = 
            }
            //if k = 2, just swap the numbers, then perform the
         }   
      }
      
    */  
      
                 
   } //end main method
   
   /*
  public static int[] sortIntegerString(int[] array) {      
     String sorted = array; 
      
              
     return sorted;
   }
   
   public static int[] nextHighestSort(int[] array) {      
      String sorted = array;
      
              
      return sorted;
   }
   */
} //end class