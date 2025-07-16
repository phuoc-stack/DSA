package map.day29;

import java.util.Arrays;

public class EarliestTime {
	public static void main(String[] args) {
		int[] digits = {2, 3, 5, 2, 5, 9};
		System.out.println(calculateEarliestTime(digits)); 	
	}
	
	public static String calculateEarliestTime(int[] digits) {
		Arrays.sort(digits);
		boolean[] used = new boolean[6];
        int[] currentTime = new int[6];
        
        int[] result = backtrack(0, used, currentTime, digits);
        
        return result != null ? formatTime(result) : "NOT POSSIBLE";
	}
	
	private static int[] backtrack(int position, boolean[] used, int[] currentTime, int[] digits) {
        if (position == 6) {
        	return currentTime;
        }
        
        for (int i = 0; i < digits.length; i++) {  // iterate by index
            if (!used[i]) {  // check if this index is used
                int digit = digits[i];
                if (isValidAtPosition(digit, position, currentTime)) {
                    // Make choice
                	used[i] = true;  // mark this index as used
                    currentTime[position] = digit;
                    
                    // Recurse
                    int[] result = backtrack(position + 1, used, currentTime, digits);
                    
                    if (result != null) {
                        return result;
                    }
                    
                    // Undo choice
                    used[i] = false;  // unmark this index
                }
            }
        }
        return null;
    }
    
    private static boolean isValidAtPosition(int digit, int position, int[] currentTime) {
        switch (position) {
            case 0: return digit <= 2;
            case 1: return currentTime[0] < 2 || (currentTime[0] == 2 && digit <= 3);
            case 2: return digit <= 5;
            case 3: return true;
            case 4: return digit <= 5;
            case 5: return true;
            default: return false;
        }
    }
    
    private static String formatTime(int[] time) {
        return "" + time[0] + time[1] + ":" + time[2] + time[3] + ":" + time[4] + time[5];
    }
}
