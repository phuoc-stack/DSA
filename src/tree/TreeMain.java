package tree;

public class TreeMain {
	public static void main(String[] args) {
		BE8Tree tree = new BE8Tree();
		BENode root = new BENode();
		root.value = 1;

		tree.root = root;

		BENode node = new BENode();
		node.value = 30;

		tree.root.children.add(node);

		node = new BENode();
		node.value = 40;

		tree.root.children.add(node);

		BENode node20 = new BENode();
		node20.value = 20;

		// call method findNode with value 40
		BENode findNode = tree.findNode(40);
		if (findNode == null) {
			System.out.println("Cannot find the node with value" + node20.value);
		} else {
			findNode.children.add(node20);
			tree.displayTreeDFS(root);
		}
	}
}
