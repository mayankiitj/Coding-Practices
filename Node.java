package QnA;

public class Node {
	Node left,right,next;
	int height,data,size;
	
	public Node(){
		
	}
	
	public Node(int data){
		 this.data = data;
		 this.left= null;
		 this.right = null;
		 this.next= null;
		 height =1;
		 size =1;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
