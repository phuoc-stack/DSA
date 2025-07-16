package map.day29;

import java.util.HashMap;

public class MinTicketCost {
	public static void main(String[] args) {
		int[] A = { 1, 2, 4, 5, 7, 29, 30 };
		System.out.println(calculateMinCost(A));
	}

	public static int calculateMinCost(int[] A) {
		if (A.length == 0)
			return 0;
		// Convert array to hashmap for O(1) lookup
		HashMap<Integer, Integer> travelDays = new HashMap<>();
		for (int day : A) {
			travelDays.put(day, 0);
		}

		// Memoization map: day -> minimum cost from that day onwards
		HashMap<Integer, Integer> memo = new HashMap<>();

		return minCostFrom(1, travelDays, memo);
	}

	public static int minCostFrom(int day, HashMap<Integer, Integer> travelDays, HashMap<Integer, Integer> memo) {

		// Base case: past the end of month
		if (day > 30)
			return 0;

		// Check memoization
		if (memo.containsKey(day)) {
			return memo.get(day);
		}

		int result;

		if (!travelDays.containsKey(day)) {
			// Not a travel day, move to next day with no cost
			result = minCostFrom(day + 1, travelDays, memo);
		} else {
			// Travel day: consider all three ticket options
			int option1 = 2 + minCostFrom(day + 1, travelDays, memo); // 1-day ticket
			int option2 = 7 + minCostFrom(day + 7, travelDays, memo); // 7-day ticket
			int option3 = 25 + minCostFrom(day + 30, travelDays, memo); // 30-day ticket

			result = Math.min(option1, Math.min(option2, option3));
		}

		memo.put(day, result);
		return result;
	}
}
