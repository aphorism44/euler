
import java.io.*;
import java.util.*;

public class Euler24 {
  /* Lexicographic permutations*/
   /*

   A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
   of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
   we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

      012   021   102   120   201   210

   What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
    */
  
   public static void main(String[] args) {
      
      
                 
   } //end main method
   
  public static ArrayList<Integer> getProperDivisorsArray(int n) {      
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