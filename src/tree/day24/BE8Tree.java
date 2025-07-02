package tree.day24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BE8Tree {
	BENode root;

	public BE8Tree(BENode root) {
		this.root = root;
	}

	public boolean isBalance() {
		return findImBalanceNodes().isEmpty();
	}

	public ArrayList<BENode> findImBalanceNodes() {
		ArrayList<BENode> result = new ArrayList<>();
		checkBalance(root, result);
		return result;
	}

	public int checkBalance(BENode node, ArrayList<BENode> imbalanced) {
		if (node == null)
			return 0;

		int leftHeight = checkBalance(node.left, imbalanced);
		int rightHeight = checkBalance(node.right, imbalanced);
		int tilted = leftHeight - rightHeight;
		if (Math.abs(tilted) > 1) {
			imbalanced.add(node);
		}

		return Math.max(leftHeight, rightHeight) + 1;

	}

	public void balanceTree() {
		root = balanceNode(root);
	}

	// Recursive method to balance each node
	private BENode balanceNode(BENode node) {
		if (node == null)
			return null;

		// First balance the children
		node.left = balanceNode(node.left);
		node.right = balanceNode(node.right);

		// Now check if this node needs balancing
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		int tilted = leftHeight - rightHeight;

		// If tilted > 1: left side is taller (left-heavy)
		if (tilted > 1) {
			// Check if we need single or double rotation
			int leftChildTilt = getHeight(node.left.left) - getHeight(node.left.right);

			if (leftChildTilt >= 0) {
				// Left-Left case: single right rotation
				return rightRotate(node);
			} else {
				// Left-Right case: double rotation
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}

		// If tilted < -1: right side is taller (right-heavy)
		if (tilted < -1) {
			// Check if we need single or double rotation
			int rightChildTilt = getHeight(node.right.left) - getHeight(node.right.right);

			if (rightChildTilt <= 0) {
				// Right-Right case: single left rotation
				return leftRotate(node);
			} else {
				// Right-Left case: double rotation
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		// Node is already balanced
		return node;
	}

	// Helper method to get height
	private int getHeight(BENode node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	// Right rotation (for left-heavy trees)
	private BENode rightRotate(BENode y) {
		BENode x = y.left;
		BENode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// x is now the new root of this subtree
		return x; 
	}

	// Left rotation (for right-heavy trees)
	private BENode leftRotate(BENode x) {
		BENode y = x.right;
		BENode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// y is now the new root of this subtree
		return y; 
	}

}
