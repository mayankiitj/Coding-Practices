package QnA;

public class nextRightTree {

	public void recurNext(Node p) {

		if (p == null)
			return;
		if (p.next != null) {
			recurNext(p.next);
		}

		if (p.left != null) {
			if (p.right != null) {
				p.left.next = p.right;
				p.right.next = nextRight(p);
			} else {
				p.left.next = nextRight(p);
			}
			recurNext(p.left);
		} else if (p.right != null) {
			p.right.next = nextRight(p);
			recurNext(p.right);
		} else {
			recurNext(nextRight(p));
		}
	}

	public Node nextRight(Node p) {
		Node temp = p.next;

		while (temp != null) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.next;
		}

		return null;

	}

	public static void main(String args[]) {
		nextRightTree t = new nextRightTree();
		Node tree = new Node(10);
		tree.left = new Node(8);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		t.recurNext(tree);
		System.out.println(tree.left.left.next.data);
	}
}
