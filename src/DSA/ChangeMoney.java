package DSA;

public class ChangeMoney {
	public static int changeMoney(int money) {

		// Time complexity: O(1) 
		// Space complexity: O(1)

		int[] types = { 1, 2, 5, 10, 20, 50, 100, 200, 500 };
		int count = 0;
		for (int i = types.length-1; i >= 0; i--) {
			count += money / types[i];
			money %= types[i];
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("changeMoney(250): " + changeMoney(15)); // 200 + 50 = 2 coins
	}
}