package DSA;

public class OptimizingFarthestDifferent {
	public static void main(String[] args) {
		int[] A = { 4, 6, 2, 2, 6, 6, 4 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			if (A[0] != A[i]) {
				return i;
			}
		}
		return 0;
	}
}
