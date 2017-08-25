package QnA;

public class HeapSort {
	
	public static void main(String args[]){
		int harr[] = {4,6,2,9,3,7,1};
		new HeapSort().minHeap(harr);
		
	for(int a : harr){
		System.out.println(a);
	}
	}
	
	public void heapify(int index,int harr[]){
		int left =2*index+1;
		int right = 2*index+2;
		int smallest =index;
		
		if(left<harr.length && harr[left] <harr[smallest] ){
			smallest =left;
		}
		if(right<harr.length && harr[right] <harr[smallest]){
			smallest = right;
		}
		if(smallest != index){
			int temp = harr[index];
			harr[index]=harr[smallest];
			harr[smallest]=temp;
			heapify(smallest, harr);
		}
	}
	
	public void minHeap(int harr[]){
		int n = (harr.length-1)/2;
		while(n>=0){
			heapify(n, harr);
			n--;
		}
	}

}
