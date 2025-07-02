package tree.day24;

import java.util.ArrayList;

public class TreeMain {
	public static void main(String[] args) {
		BE8Tree tree = new BE8Tree(null);
		BENode node = new BENode();
		node.value = 4;

		tree.root = node;

		node = new BENode();
		node.value = 2;

		tree.root.right = node;

		node = new BENode();
		node.value = 3;

		tree.root.right.right = node;

		ArrayList<BENode> imbalanceList = tree.findImBalanceNodes();
		System.out.println(imbalanceList.size());

		for (BENode be8Node : imbalanceList) {
			System.out.println(be8Node.value);
		}

		tree.balanceTree();
	}
}
