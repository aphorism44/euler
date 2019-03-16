package helpers;

import java.util.ArrayList;

public class combinatorics {

	public static ArrayList<Integer> getIntPermutations(ArrayList<Integer> arr) {
		ArrayList<Integer> permutations = new ArrayList<Integer>();
		//base case
		if (arr.size() == 1) {
			return arr;
		} else if (arr.size() > 1) {
			//recursive relation
			for (int i = 0; i < arr.size(); i++) {
				ArrayList<Integer> tempPerm = new ArrayList<Integer>(permutations);
				String front = tempPerm.remove(i).toString();
				ArrayList<Integer> newPerms = getIntPermutations(tempPerm);
				for (int p: newPerms) {
					permutations.add(Integer.valueOf(front + p));
				}
			}
			
			
		}
		
		return permutations;
	}
	
}
