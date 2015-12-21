
import java.io.*;

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
      
      try {
         FileReader nameReader = new FileReader("names.txt");
         BufferedReader nameBuffer = new BufferedReader(nameReader);
         String line = null;
         while((line = nameBuffer.readLine()) != null) {
                   System.out.println(line);
               }   
         nameBuffer.close();     
      }
     catch(FileNotFoundException ex) {
         System.out.println(ex);                
     }
     catch(IOException ex) {
         System.out.println(ex);
     }
   
                 
   } //end main method
   
  
   
} //end class