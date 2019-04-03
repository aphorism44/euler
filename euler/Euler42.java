package euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import helpers.combinatorics;
import helpers.sieveEratosthenes;

/*
 
The n^th term of the sequence of triangle numbers is given by, t(n) = (1/2)n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. 
For example, the word value for SKY is 19 + 11 + 25 = 55 = t(10). 
If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 
 */


public class Euler42 {

	public static void main(String[] args) {
		int triangularWords = 0;
		
		//make a map between words and values
		HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
		int alphaNum = 1;
		for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
		    alphabet.put(alpha, alphaNum);
		    alphaNum++;
		}
		
		HashSet<Integer> t = getTriangulars(1000);
		String csvFile = "words.txt";
        BufferedReader br = null;
        String[] words = null;
        try {
			br = new BufferedReader(new FileReader(csvFile));
			words = br.readLine().replace("\"", "").split(",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for (String s: words) {
        	int wordSum = 0;
        	for (int i = 0; i < s.length(); i++) {
        		char letter = s.charAt(i);
            	wordSum += alphabet.get(letter);
        	}
        	if (t.contains(wordSum)) {
        		triangularWords++;
        	}
        }
        
        System.out.println(triangularWords);
	}

	
	public static HashSet<Integer> getTriangulars(int max) {
		HashSet<Integer> triangulars = new HashSet<Integer>();
		for (int i = 1; i <= max; i++) {
			int triangular = (i * (i + 1)) / 2;
			triangulars.add(triangular);
		}
		return triangulars;
	}
	
}