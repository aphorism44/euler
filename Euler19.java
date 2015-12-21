
import java.math.*;
import java.util.*;
import java.lang.*;

public class Euler19 {
  
  
   public static void main(String[] args) {
      
   /* Counting Sundays */
   /*
   You are given the following information, but you may prefer to do some research for yourself.
   
       1 Jan 1900 was a Monday.
       Thirty days has September,
       April, June and November.
       All the rest have thirty-one,
       Saving February alone,
       Which has twenty-eight, rain or shine.
       And on leap years, twenty-nine.
       A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
   
   How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
   NOTE - 1/1/1901 was Tuesday, 12/1/2000 was 
    
    JAVA - this is too easy, since we have a complete built-in data function
    1 = sunday, 2 = monday, ..., 7 = saturday.
    */
    
    Calendar c = new GregorianCalendar(1901, Calendar.JANUARY, 1);
    int noOfSundays = 0;
    
    while (c.get(Calendar.YEAR) < 2001) {
      if (c.get(Calendar.DAY_OF_WEEK) == 1)
         noOfSundays++;
      c.add(Calendar.MONTH, 1);
    }
    
    System.out.println(noOfSundays);
    
                 
   } //end main method
   


   
} //end class