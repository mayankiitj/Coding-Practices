package QnA;

public class BSTCheck {

	public static boolean checkBst(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max)
			return false;

		return checkBst(root.left, min, root.data) && checkBst(root.right, root.data, max);

	}

	public static void main(String args[]) {
		Node root = null;
		root = new Node(7);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		if (checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}
