package QnA;

public class ListNode {

	int data;
	ListNode right, down;

	public ListNode(int data) {
		this.data = data;
	}
	public static ListNode merge(ListNode a,ListNode b){
		if (a==  null )
			return b;
		if(b == null)
			return a;
		ListNode res = null;
		if(a.data>b.data){
			res =b;
			res.right = merge(a,b.down);
		}
		else{
			res = a;
			res.right = merge(a.down,b);
		}
		return res;
	}
	public static ListNode flattenList(ListNode root) {
		if (root == null || root.right == null) {
			return root;
		}
		root.right = flattenList(root.right);
		root = merge(root,root.right);
		return root;
	}

	public static void main(String args[]) {
		
		ListNode root = new ListNode(5);
		root.right = new ListNode(8);
		root.down = new ListNode(6);
		root.down.down = new ListNode(10);
		root.right.down = new ListNode(9);
		root.right.down.down = new ListNode(13);
		root.right.right = new ListNode(11);
		
		ListNode res = flattenList(root);
		
		while(res!=null){
			System.out.println(res.data);
			res= res.right;
			}
		

	}

}
