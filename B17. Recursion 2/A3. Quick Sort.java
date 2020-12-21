
public class Quick_Sort {

	//array ko do parts mai break karna hai to hum range rakhlene( yaha shuru karna hai and yaha end) so sI and eI
	public static void quickSort(int input[], int sI, int eI) {
		if (sI >= eI) { //agar humari range mai ek hi element reh gya (sI==eI) hai ya fir ek bhi nhi, to already sorted hai to kuch kam nhi karna hai
			return;
		}
		
		//sabse pehla step hume partition step karna hai, 
		int pivotPos = partition(input, sI, eI); //partition function humare liye teen steps karega- find pivot(first pe rakha hua pivot hoga), place pivot at its position, ensure karega towards left <=x hai and towards right >x values hai, and finally it will return pivot position.
		// pivot position milne ke bad humara array two parts mai split hogya. hume dono parts ko recursively sort karna hai
		quickSort(input, sI, pivotPos - 1); //part one end pivotPos -1 position pe hora
		quickSort(input, pivotPos + 1, eI); //mera part two pivotPos +1 se hoga and end wahipe hoga jaha humara pura array end hora
        //pivot apne sahi position pehi tha isliye include nhi kiya.
	}

	private static int partition(int input[], int sI, int eI) {
		
		//pehle pivot ki position dhundenge then usko waha place karenge.
		int count = 0; //agar 3 elements pivot se chote hai, to muje pehle 3 places chhod dene chahiye and then pivot ko dal dena chahiye. so hum startindex se endindex tak scan karenge hum find out karenge kitne aise element hai jo pivot se chote hai ya equal hai woh count karlenge
		int pivot = input[sI]; // jis range ki bat karre( sI to eI) uske first element ko pivot consider karre.
		
		for (int i = sI + 1; i <= eI; i++) {
			if (input[i] <= pivot) {
				count++;
			}
		}
		
		// to place pivot at particular position
		int pivotPos = sI + count; //statIndex ko pakad ke uske badd ka smaller elements ka jitna count aya uske bad wali pivotPos rahegi.
		//swap karenge sI ke element se pivotPos ke old element se
		int temp = input[pivotPos];
		input[pivotPos] = input[sI];
		input[sI] = temp;

		// to ensure, small elements on left and big ones on right
		//array starting and end pe aise do variable consider karenge
		// hum starting se i ko move karenge and yeh ensure krte move karnege ki 'i' pe jo rakha hai chota hai pivot se and same with j, pivot se bada hai tohi hum 'j' ko move karenge.
		int i = sI;
		int j = eI;

		while (i < pivotPos && j > pivotPos) { //jabtak i chota hai pivotPos se and j bada hai tabtak i j leke swap karne wala kam karre honge.
			//har ek element ko check karenge ki kya woh pivot se chota hai, agar pivot se chota nhi hai to yeh left side mai nhi hona chahiye, right mai bhi aisa koi element hoga jo pivot se chota so uske sath isko swap karenge. So hum pichese dhundenge jiske sath hum swap kar skte hai
			if (input[i] <= pivot) {
				i++;
			} else if (input[j] >= pivot) {
				j--;
			} else {// if both are false then swap the value
				temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				i++;
				j--;
			}
		}
		//yaha tak ensure hogya ab pivot ki position return karenge and recursively dono parts ko sort kar skte hai
		return pivotPos;
	}

	public static void main(String[] args) {
		int arr[] = { 9, 8, 11, 5, 2 };
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
}
