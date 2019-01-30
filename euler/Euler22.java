package euler;

import java.io.*;
import java.util.*;

public class Euler22 {
  /* Name Scores*/
   /*
   

   Using names.txt (right click and 'Save Link/Target As...')
   , a 46K text file containing over five-thousand first names
   , begin by sorting it into alphabetical order. 
   Then working out the alphabetical value for each name
   , multiply this value by its alphabetical position in the list to obtain a name score.
   
   For example, when the list is sorted into alphabetical order
   , COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
   So, COLIN would obtain a score of 938 × 53 = 49714.
   
   What is the total of all the name scores in the file?
    */
  
   public static void main(String[] args) {
      
      String line = null;
      List<String> names = new ArrayList<String>();
      
      try {
         FileReader nameReader = new FileReader("names.txt");
         BufferedReader nameBuffer = new BufferedReader(nameReader);
         
         while((line = nameBuffer.readLine()) != null) {
                   names = Arrays.asList(line.split(","));
               }   
         nameBuffer.close();     
      }
     catch(FileNotFoundException ex) {
         System.out.println(ex);                
     }
     catch(IOException ex) {
         System.out.println(ex);
     }
   
      long total = 0;
      int temp;
      
      Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
      System.out.println(names.size());
      System.out.println(names.get(0));
      System.out.println(names.get(5162));
      //5163 names
      for (int i = 1; i <= names.size(); i++) {
         temp = 0;
         String name = names.get(i - 1).replace("\"", "");
         for (int j = 0; j < name.length(); j++) {
              temp += Character.toLowerCase(name.charAt(j)) - 'a' + 1;
          }
          temp *= i;
          total += temp;
      }
   
      System.out.println(total);
      //871198282
                 
   } //end main method
   
  
   
} //end class