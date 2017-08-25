package QnA;

public class ConstructTreeFromTraversal {
	
	static int p =0;
	static Node root = null;
	
	static Node constructTree(char in[],char pre[],int st,int end){
		if(st>end)
			return null;
		Node node = new Node(pre[p++]);
		
		if(st == end){
			return node;
		}
		else{
			int index = 0;
			for(int i=0;i<in.length;i++){
				if(node.data == in[i]){
					index =i;
				}
			}
			node.left = constructTree(in, pre, st, index-1);
			node.right = constructTree(in,pre,index+1,end);
			
			return node;
		}
	}
	static void inorder (Node n){
		if(n == null)
			return;
		inorder(n.left);
		System.out.println(n.data);
		inorder(n.right);
	}
	
	public static void main(String args[]){
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int i=0,j=in.length-1;
        root = constructTree(in,pre,i,j);
        
        inorder(root);
	}

}
