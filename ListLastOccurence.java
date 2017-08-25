
public class ListLastOccurence {
	int data;
	ListLastOccurence next;
	public ListLastOccurence(int data) {
		this.data = data;
	}
	
	public static void main(String args[]){
		ListLastOccurence l = new ListLastOccurence(3);
		l.next =new ListLastOccurence(5);
		l.next.next =new ListLastOccurence(2);
		l.next.next.next = new ListLastOccurence(4);
		l.next.next.next.next = new ListLastOccurence(2);
		//l.next.next.next.next.next = new ListLastOccurence(6);
		
		l.removeLastOccur(l, 2, null);
		while(l!=null){
			System.out.println(l.data);
			l=l.next;
		}
		
	}
	public boolean removeLastOccur(ListLastOccurence node,int k,ListLastOccurence parent){
		if(node ==null)
			return false;
		boolean flag = removeLastOccur(node.next,k,node);
		
		if(node.data ==k && !flag){
			parent.next = node.next;
			flag = true;
		}
		
		return flag;
		
	}
}
