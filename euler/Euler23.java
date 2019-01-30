package euler;

import java.io.*;
import java.util.*;

public class Euler23 {
  /* Non-abundant sums*/
   /*
   
   A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
   For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 
   is a perfect number.
   
   A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant 
   if this sum exceeds n.
   
   As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written 
   as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater 
   than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any 
   further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two 
   abundant numbers is less than this limit.
   
   Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

   NOTE - reuse functions from 21

    */
  
   public static void main(String[] args) {
      
      long finalSum = 0;
      
      //first find all abundants; are 6965 of them below 28123
      ArrayList<Integer> abundants = new ArrayList<Integer>();
      
      for (int i = 1; i <= 28123; i++) {
         ArrayList<Integer> divisors = getProperDivisorsArray(i);
         int tempSum = sumArrayList(divisors);
         if (tempSum > i)
            abundants.add(i);
      }
      int numAbundants = abundants.size();
      
      ArrayList<Integer> nonSums = new ArrayList<Integer>();
      //now grab all the numbers in the limit; the index of each int is j -1
      int maxNumber = 28123;
      for (int j = 1; j <= maxNumber; j++) {
         nonSums.add(j);
      }
            
      int firstAb, secondAb, tempSum = 0;
      //...and remove the ones that are sums of 2 abundant numbers
      for (int k = 0; k < numAbundants; k++) {
         System.out.println(k);
         firstAb = abundants.get(k);
         //don't forget you need to add each abundant to itself
         for (int l = k; l < numAbundants; l++) {
            //cast int below is needed due to Java's bad function overloading
            secondAb = abundants.get(l);
            tempSum = firstAb + secondAb;
            //add below to speed up processing
            if (tempSum <= maxNumber)
               //set to 0 with index muuuch quicker than removing by value
               nonSums.set(tempSum - 1, 0);
               //nonSums.remove((Integer)tempSum);
            else
               break;
         }
      }
      
      finalSum = sumArrayList(nonSums);
      System.out.println(nonSums.size());
      System.out.println(finalSum);
      //4179871
                 
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