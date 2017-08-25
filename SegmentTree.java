package QnA;

public class SegmentTree {
	int st[];
	SegmentTree(int arr[],int n){
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new int[max_size];
		constructTree(arr,0,n-1,0);
	}
	public static void main(String args[]){
		int arr[] ={1, 3, 5, 7, 9, 11};
		int n= arr.length;
		SegmentTree stree= new SegmentTree(arr, n);
		for(int s: stree.st){
			System.out.println(s);
		}
	}
	public int constructTree(int arr[],int s,int e,int cur){
		if(s ==e){
			st[cur] = arr[s];
			return st[cur];
		}
		
		int mid = s+(e-s)/2;
		st[cur] = constructTree(arr, s, mid, 2*cur+1)+constructTree(arr, mid+1, e, 2*cur+2);
		return st[cur];
	}
}
