package QnA;

public class TreeToDll {
	static Node head = new Node();
	static Node prev = null;
	public static void convertTreetoList(Node root){
		if(root == null)
			return;
		
		convertTreetoList(root.left);
		if(prev == null){
			head = root;
		}
		else{
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convertTreetoList(root.right);
	}
	public static void main (String args[]){
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.right.left = new Node(6);
		root.left.right = new Node(4);
		
		convertTreetoList(root);
		
		while(head.right !=null){
			System.out.println(head.data);
			head = head.right;
		}
		
		while(head !=null){
			System.out.println(head.data);
			head = head.left;
		}
		
	}
}
