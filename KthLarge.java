package QnA;


public class KthLarge{
	static int k =3;
	public static void main(String args[]){
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.right.left = new Node(6);
		root.left.right = new Node(4);
		
		
		inorder(root);
	}
	public static void inorder(Node root){
		if(root ==null || k<0)
			return ;
		inorder(root.left);
		k--;
		if(k ==0){
			System.out.println(root.data);
		}
		inorder(root.right);
	}
}