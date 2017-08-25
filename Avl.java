package QnA;

public class Avl {
	static int smallCount[] = new int [7];
	static int ctr =0;
	public static void main(String args[]) {
		// Count smaller elements on right side
		  Node root = null;
		  Avl avl =new Avl();
		  int arr[] = {10, 6, 15, 20, 30, 5, 7};
		  for (int i = arr.length-1; i >= 0; i--)
		  {
		     root = avl.insertDataToTree(root, arr[i]);
		     ctr++;
		  }
		  for(int i=0;i<smallCount.length;i++){
			  System.out.print(smallCount[i]+" ");
		  }
	}

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return root.height;

	}
	
	public int getSize(Node root){
		if(root ==null)
			return 0;
		return root.size;
	}

	public int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	public Node insertDataToTree(Node root, int data) {

		if (root == null) {
			return new Node(data);
		}

		if (root.data > data) {
			root.left = insertDataToTree(root.left, data);
		} else if (root.data < data) {
			root.right = insertDataToTree(root.right, data);
			smallCount[ctr] +=getSize(root.left)+1;
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		root.size = getSize(root.left)+getSize(root.right)+1;
		int balance = getBalance(root);

		if (balance > 1 && root.left.data > data) {
			root = rightRotate(root);
		}

		if (balance < -1 && root.right.data < data) {
			root = leftRotate(root);
		}

		if (balance > 1 && root.left.data < data) {
			root.left = leftRotate(root);
			root = rightRotate(root);
		}

		if (balance < -1 && root.right.data > data) {
			root.right = rightRotate(root);
			root = leftRotate(root);
		}
		
		return root;

	}

	public Node rightRotate(Node t) {
		Node y = t.left;
		Node z = y.right;
		y.right = t;
		t.left = z;
		t.height = getHeight(t.left) > getHeight(t.right) ? getHeight(t.left) + 1 : getHeight(t.right) + 1;
		y.height = getHeight(y.left) > getHeight(y.right) ? getHeight(y.left) + 1 : getHeight(y.right) + 1;
		return y;
	}

	public Node leftRotate(Node t) {
		Node y = t.right;
		Node z = y.left;
		y.left = t;
		t.right = z;
		t.height = getHeight(t.left) > getHeight(t.right) ? t.left.height + 1 : t.right.height + 1;
		y.height = getHeight(y.left) > getHeight(y.right) ? y.left.height + 1 : y.right.height + 1;
		return y;
	}

}
