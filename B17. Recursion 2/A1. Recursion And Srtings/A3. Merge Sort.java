Merge Sort Code

Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.

Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)

Constraints :
1 <= n <= 10^3

Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8

Sample Input 2 :
5
2 1 5 2 3
Sample Output 2 :
1 2 2 3 5

Code:

public class Merge_Sort {

	public static void mergeSort(int input[]) {
		mergeSort(input, 0, input.length - 1);
	}

	public static void mergeSort(int input[], int sI, int eI) {
		if (sI >= eI) {
			return;
		}
		int mid = (sI + eI) / 2;
		// part 1
		mergeSort(input, sI, mid);
		// part 2
		mergeSort(input, mid + 1, eI);
		merge(input, sI, eI);
	}

	public static void merge(int input[], int sI, int eI) {
		int mid = (sI + eI) / 2;
		int ans[] = new int[eI - sI + 1];
		int i = sI;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= eI) {
			if (input[i] < input[j]) {
				ans[k] = input[i];
				i++;
				k++;
			} else {
				ans[k] = input[j];
				k++;
				j++;
			}
		}

		while (i <= mid) {
			ans[k] = input[i];
			i++;
			k++;
		}
		while (j <= eI) {
			ans[k] = input[j];
			k++;
			j++;
		}

		for (int index = 0; index < ans.length; index++) {
			input[sI + index] = ans[index];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 6, 8, 5, 4, 3 };
		mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
