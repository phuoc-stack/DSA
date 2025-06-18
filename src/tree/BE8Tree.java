package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BE8Tree {
	BENode root;

	public BENode findNode(int value) {
		// DFS
		// compare root value first
		if (root == null) {
			return null;
		}
		if (root.value == value) {
			return root;
		}
		return findNodeRecursive(root, value);
	}

	public BENode findNodeRecursive(BENode currentNode, int value) {
		if (currentNode.value == value) {
			return currentNode;
		}
		for (BENode childNode : currentNode.children) {
			BENode result = findNodeRecursive(childNode, value);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	public BENode findNodeQueue(int value) {
		// BFS
		Queue<BENode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BENode currentNode = queue.poll();
			if (currentNode.value == value) {
				return currentNode;
			}

			for (BENode childNode : currentNode.children) {
				queue.add(childNode);
			}
		}
		return null;
	}

	public void displayTreeBFS(BENode root) {
		int depth = 0;
		// BFS
		Queue<BENode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// display node value
			BENode currentNode = queue.poll();
			for (int i = 0; i < depth; i++) {
				System.out.print(" ");
			}
			System.out.println(currentNode.value);
			for (BENode childNode : currentNode.children) {
				queue.add(childNode);
				depth++;
			}
		}
	}

	public void displayTreeDFS(BENode root) {
		// DFS
		Stack<BENodeWithDepth> stack = new Stack<>();
		stack.push(new BENodeWithDepth(root, 0));

		while (!stack.isEmpty()) {
			// display node value
			BENodeWithDepth currentNode = stack.pop();
			for (int i = 0; i < currentNode.depth; i++) {
				System.out.print(" ");
			}
			System.out.println(currentNode.node.value);
			for (BENode childNode : currentNode.node.children) {
				stack.push(new BENodeWithDepth(childNode, currentNode.depth + 1));
			}
		}
	}

}
