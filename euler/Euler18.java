package euler;

import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler18 {

  public static int [][] pyramid = new int[][] {
                    new int[]  {75}, 
                   new int[]  {95, 64}, 
                  new int[]  {17, 47, 82}, 
                new int[]  {18, 35, 87, 10}, 
              new int[]   {20, 04, 82, 47, 65}, 
            new int[]    {19, 01, 23, 75, 03, 34}, 
          new int[]     {88, 02, 77, 73, 07, 63, 67}, 
         new int[]     {99, 65, 4, 28, 6, 16, 70, 92}, 
        new int[]     {41, 41, 26, 56, 83, 40, 80, 70, 33}, 
        new int[]    {41, 48, 72, 33, 47, 32, 37, 16, 94, 29}, 
       new int[]    {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14}, 
      new int[]    {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57}, 
      new int[]   {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48}, 
     new int[]   {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31}, 
    new int[]   {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
     };
  
   public static void main(String[] args) {
      
      /* Maximum path sum I */
      /*
      By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

      3
      7 4
      2 4 6
      8 5 9 3

      That is, 3 + 7 + 4 + 9 = 23.

      Find the maximum total from top to bottom of the triangle below:

      75
      95 64
      17 47 82
      18 35 87 10
      20 04 82 47 65
      19 01 23 75 03 34
      88 02 77 73 07 63 67
      99 65 04 28 06 16 70 92
      41 41 26 56 83 40 80 70 33
      41 48 72 33 47 32 37 16 94 29
      53 71 44 65 25 43 91 52 97 51 14
      70 11 33 28 77 73 17 78 39 68 17 57
      91 71 52 38 17 14 91 43 58 50 27 29 48
      63 66 04 68 89 53 67 30 73 16 69 87 40 31
      04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
     
     NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
     However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
     it cannot be solved by brute force, and requires a clever method! 
     
     
     INSIGHT - for any node row in the current row being calculated,
     although there may be MANY different paths to get there,
     WE ONLY NEED the MAX for all those paths, which can be easily
     calculated at each step, thus limiting the number of running totals
     to the number of columns in the final row
      */
      
      int[][] sums = new int[pyramid.length][pyramid[pyramid.length - 1].length]; 
      sums[0][0] = pyramid[0][0];
     
      for (int row = 1; row < pyramid.length; row++) {
         for (int col = 0; col < pyramid[row].length; col++) {
            if (col == 0) {
               sums[row][col] = sums[row - 1][col] + pyramid[row][col];
            } else if (col == pyramid[row].length - 1) {
               sums[row][col] = sums[row - 1][col - 1] + pyramid[row][col];
            } else {
               sums[row][col] = Math.max(sums[row - 1][col - 1] + pyramid[row][col], sums[row - 1][col] + pyramid[row][col]);
            }
         }
      }
     
     
           
      long max = 0;
      for (int i = 0; i < sums[sums.length - 1].length; i++) {
         if (sums[sums.length - 1][i] > max)
            max = sums[sums.length - 1][i];
      }
      
      System.out.println(max);
     
                 
   } //end main method
   


   
} //end class