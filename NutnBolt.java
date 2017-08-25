package QnA;

public class NutnBolt {

	public static void matchPair(int nuts[], int bolts[], int low, int high) {
		if (low < high) {
			int pivot = partition(bolts, low, high, nuts[high]);
			partition(nuts, low, high, bolts[pivot]);
			matchPair(nuts, bolts, low, pivot - 1);
			matchPair(nuts, bolts, pivot + 1, high);
		}
	}

	public static int partition(int arr[], int low, int high, int pivot) {
		/*
		 * int i=low,j=high; while(low<high){ while(arr[low]<p)low++;
		 * while(arr[high]>p)high--; if(low<high){ int temp =arr[low];
		 * arr[low]=arr[high]; arr[high] = temp; } } if(i == low){ int temp
		 * =arr[low]; arr[low]=p; arr[high] = temp; } return 0;
		 */
		int i = low;
		int temp1, temp2;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				temp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp1;
				i++;
			} else if (arr[j] == pivot) {
				temp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = temp1;
				j--;
			}
		}
		temp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = temp2;
		return i;
	}

	public static void main(String args[]) {
		int nuts[] = { 1, 5, 3, 2, 4 };
		int bolts[] = { 3, 2, 4, 1, 5 };
		matchPair(nuts, bolts, 0, 4);
		for (int i = 0; i < nuts.length; i++) {
			System.out.println(nuts[i] + bolts[i]);
		}
	}
}
