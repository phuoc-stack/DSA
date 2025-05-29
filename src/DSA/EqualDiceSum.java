package DSA;

import java.util.ArrayList;
import java.util.Collections;

public class EqualDiceSum {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 3, 2, 1 };
		int[] B = { 6 };
		System.out.println(minimumNoOfDice(A, B));
	}

	public static int minimumNoOfDice(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;

		for (int die : A)
			sumA += die;
		for (int die : B)
			sumB += die;

		int diff = sumA - sumB;

		ArrayList<Integer> improvements = new ArrayList<Integer>();

		if (diff > 0) {
			for (int die : A)
				improvements.add(die - 1);
			for (int die : B)
				improvements.add(6 - die);
		} else if (diff < 0) {
			for (int die : A)
				improvements.add(6 - die);
			for (int die : B)
				improvements.add(die - 1);
		} else {
			return 0;
		}
		Collections.sort(improvements, Collections.reverseOrder());
		int remaining = Math.abs(diff);
		int count = 0;

		for (int improvement : improvements) {
			if (remaining <= 0)
				break;
			if (improvement > 0) { 
				remaining -= improvement;
				count++;
			}
		}
		return remaining <= 0 ? count : -1; 
	}
    // time complexity: O(A + B) 
}
