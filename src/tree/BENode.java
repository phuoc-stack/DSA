package tree;

import java.util.ArrayList;

public class BENode {
	Integer value;
	ArrayList<BENode> children;

	public BENode() {
		children = new ArrayList<BENode>();
	}
}
