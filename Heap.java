package QnA;

public class Heap {
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public void heapify(int i, int n, int arr[]) {
		int next = -1;
		if (i >= n) {
			return;
		}
		if (2 * i + 1 < n && arr[2 * i + 1] < arr[i]) {
			next = 2 * i + 1;
		}
		if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
			next = 2 * i + 2;
		}
		if (next != -1){
			int temp = arr[next];
			arr[next] = arr[i];
			arr[i] = temp;
			heapify(next, n, arr);}
	}

	public int [] doHeap(int n,int arr[]){
		int count = n/2-1;
		while(count>=0){
			heapify(count,n,arr);
			count--;
		}
		return arr;
	}
	
	public static void main(String args[]){
		int arr[] = {13,5,8,3,6,2,1,9};
		Heap h = new Heap();
		int arr1 []=h.doHeap(arr.length,arr);
		for(int a: arr1){
			System.out.println(a);
		}
	}
}
