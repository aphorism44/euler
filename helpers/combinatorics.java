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
}
