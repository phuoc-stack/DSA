package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BE8Tree {
	BENode root;

	public BENode findNode(int value) {
		BENode currentNode = root;
		return findNodeRecursive(currentNode, value);
	}

	public BENode findNodeRecursive(BENode currentNode, int value) {
		if (currentNode == null) {
			return null;
		}
		for (BENode childNode : currentNode.children) {
			BENode result = findNodeRecursive(childNode, value);
			if (result != null) {
				return result;
			}
		}
		if (currentNode.value == value) {
			return currentNode;
		}
		return null;
	}

	public void displayTreeBFS(BENode root) {
		// BFS
		Queue<BENodeWithDepth> queue = new LinkedList<>();
		queue.add(new BENodeWithDepth(root, 0));

		while (!queue.isEmpty()) {
			// display node value
			BENodeWithDepth currentNode = queue.poll();
			for (int i = 0; i < currentNode.depth; i++) {
				System.out.print(" ");
			}
			System.out.println(currentNode.node.value);
			for (BENode childNode : currentNode.node.children) {
				queue.add(new BENodeWithDepth(childNode, currentNode.depth + 1));
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
