package DSA;

public class BinaryGap {
	public static void main(String[] args) {
    	int N = 9;
    	System.out.println(solution(N));
    }
	
    public static int solution(int N) {
        int maxGap = 0;
        int currentGap = 0;
        boolean foundFirstOne = false;
        
        // Process each bit of N from right to left
        while (N > 0) {
            // Check if current bit is 1 or 0
            int currentBit = N & 1;
            
            if (currentBit == 1) {
                // Current bit is 1
                if (foundFirstOne == true) {
                    if (currentGap > maxGap) {
                        maxGap = currentGap;
                    }
                }
                foundFirstOne = true;
             // Reset gap counter
                currentGap = 0; 
            } else {
                if (foundFirstOne == true) {
                    // We're inside a gap (between two 1s)
                    currentGap = currentGap + 1;
                }
            }
            
            // Move to next bit 
            N = N / 2;
        }
        
        return maxGap;
    }    
    //// time complexity: O(logN) 
}