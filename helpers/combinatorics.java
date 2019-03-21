package helpers;

import java.util.ArrayList;

public class combinatorics {

	
	//takes in a number and returns an array of all possible permutations of its digits
	public static ArrayList<Integer> getIntPermutations(int num) {
		ArrayList<Character> numArr = new ArrayList<Character>();
		for (char c: Integer.toString(num).toCharArray())
			numArr.add(c);
		ArrayList<Integer> permutations = new ArrayList<Integer>();
		//base case 1
		if (numArr.size() < 2) {
			permutations.add(num);
			return permutations;
		//base case 2
		} else if (numArr.size() == 2) {
			String sNum1 = new StringBuilder().append(numArr.get(0)).append(numArr.get(1)).toString();
			String sNum2 = new StringBuilder().append(numArr.get(1)).append(numArr.get(0)).toString();
			permutations.add(Integer.valueOf(sNum1));
			permutations.add(Integer.valueOf(sNum2));
			return permutations;
		} else {
			//recursive relation
			for (int i = 0; i < numArr.size(); i++) {
				ArrayList<Character> tempNumArr = new ArrayList<Character>(numArr);
				char currNumStr = tempNumArr.remove(i);
				StringBuilder tempNumStr = new StringBuilder();
				for (char c: tempNumArr)
					tempNumStr.append(c);
				ArrayList<Integer> newPerms = getIntPermutations(Integer.valueOf(tempNumStr.toString()));
				for (int p: newPerms) {
					String newNum = currNumStr + String.valueOf(p);
					permutations.add(Integer.valueOf(newNum));
				}
			}
			return permutations;
		}
	}
	
		//takes in a string and returns an array of all possible permutations of its letters
		public static ArrayList<String> getStringPermutations(String str) {
			ArrayList<Character> strArr = new ArrayList<Character>();
			for (char c: str.toCharArray())
				strArr.add(c);
			ArrayList<String> permutations = new ArrayList<String>();
			//base case 1
			if (strArr.size() < 2) {
				permutations.add(str);
				return permutations;
			//base case 2
			} else if (strArr.size() == 2) {
				String str1 = new StringBuilder().append(strArr.get(0)).append(strArr.get(1)).toString();
				String str2 = new StringBuilder().append(strArr.get(1)).append(strArr.get(0)).toString();
				permutations.add(str1);
				permutations.add(str2);
				return permutations;
			} else {
				//recursive relation
				for (int i = 0; i < strArr.size(); i++) {
					ArrayList<Character> tempStrArr = new ArrayList<Character>(strArr);
					char currStr = tempStrArr.remove(i);
					StringBuilder tempBldr = new StringBuilder();
					for (char c: tempStrArr)
						tempBldr.append(c);
					ArrayList<String> newPerms = getStringPermutations(tempBldr.toString());
					for (String s: newPerms) {
						String newStr = currStr + s;
						permutations.add(newStr);
					}
				}
				return permutations;
			}
		}
	
	//takes in a number and returns an array of all possible rotations of its digits
	//(a rotation of 197 = {197, 971, 719}
	public static ArrayList<Integer> getIntRotations(int num) {
		ArrayList<Integer> rotations = new ArrayList<Integer>();
		String numStr = String.valueOf(num);
		int numLength = numStr.length();
		for (int i = 0; i < numLength; i++) {
			StringBuilder numBld = new StringBuilder().append(numStr.charAt(i));
			for (int j = i + 1; j < numLength + i; j++) {
				numBld.append(numStr.charAt(j % numLength));
			}
			rotations.add(Integer.valueOf(numBld.toString()));
		}
		
		return rotations;
	}
	
	//takes in string and checks if it's a palindrome
	public static boolean isStringPalindrome(String str) {
		int begin = 0;
		int end = str.length() - 1;
		while (begin < end) {
			if (str.charAt(begin) != str.charAt(end))
				return false;
			begin++;
			end--;
		}
		return true;
	}
}
