package euler;

import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler17 {


   public static void main(String[] args) {
   
      
      /* Number letter counts */
      /* If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
      then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

      If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

      NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
      and 115 (one hundred and fifteen) contains 20 letters. 
      The use of "and" when writing out numbers is in compliance with British usage.  */ 
      
      HashMap<Integer, String> numberWords = new HashMap<Integer, String>();
      
      numberWords.put(1, "one");
      numberWords.put(2, "two");
      numberWords.put(3, "three");
      numberWords.put(4, "four");
      numberWords.put(5, "five");
      numberWords.put(6, "six");
      numberWords.put(7, "seven");
      numberWords.put(8, "eight");
      numberWords.put(9, "nine");
      numberWords.put(10, "ten");
      
      numberWords.put(11, "eleven");
      numberWords.put(12, "twelve");
      numberWords.put(13, "thirteen");
      numberWords.put(14, "fourteen");
      numberWords.put(15, "fifteen");
      numberWords.put(16, "sixteen");
      numberWords.put(17, "seventeen");
      numberWords.put(18, "eighteen");
      numberWords.put(19, "nineteen");
      
      numberWords.put(20, "twenty");
      numberWords.put(30, "thirty");
      numberWords.put(40, "forty");
      numberWords.put(50, "fifty");
      numberWords.put(60, "sixty");
      numberWords.put(70, "seventy");
      numberWords.put(80, "eighty");
      numberWords.put(90, "ninety");
            
      int finalCount = 0;
      
      //for 1 to 20, we use what's in the map
      for (int i = 1; i <= 20; i++) {
         String num = numberWords.get(i);
         System.out.println(num);
         finalCount += num.length();  
      }
      
      //now up to 100, we combine the 10s and the singles
      for (int i = 21; i <= 99; i++) {
         //i / 10 = tens columns; i % 10 = ones columns
         String tenCol = numberWords.get((i/10) * 10);
         String oneCol = numberWords.get(i % 10);
         if (oneCol == null)
            oneCol = "";
         System.out.println(tenCol + " " + oneCol);
         int count = tenCol.length() + oneCol.length();
         finalCount += count;
      }
      
      //now for the hundreds
      for (int i = 100; i <= 999; i++) {
         //i / 10 = tens columns; i % 10 = ones columns
         String hundredCol = numberWords.get((i/100));
         String tenCol = numberWords.get((i/10) % 10 * 10);
         String oneCol = numberWords.get( i % 10);
         
         if (tenCol == null)
            tenCol = "";
         if (oneCol == null)
            oneCol = "";
         
         int less = ((i/10) % 10) * 10  + (i % 10);
         String lessCol = numberWords.get(less);
                  
         String finalSt = hundredCol + " hundred";
         
         if (tenCol.length() > 0 || oneCol.length() > 0) {
            finalSt += " and ";
            
            if (((i/10) % 10) > 1)
               finalSt += tenCol + " " + oneCol;
            else
               finalSt += lessCol;
         }
            
         System.out.println(finalSt);
         finalCount += finalSt.replaceAll(" ", "").length();         
      }
      
      //finally add one thousand
      String th = "one thousand";
      System.out.println(th);
      finalCount += th.replaceAll(" ", "").length();   
      
      
      System.out.println(finalCount);
             
   } //end main method
   
   

} //end class