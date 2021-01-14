package array;

import java.util.Scanner;

public class Selection_sort {
	
	public static void selectionSort(int input[]) { // array will be input
		
		// hume n-1 rounds karne hai to sort n elements
		for (int i = 0; i < input.length - 1; i++) { // 0 to length - 2 (n-1 rounds), kyuki last wale element keliye koi operation nhi karna padega woh apne aap sahi position aajayega 
			
			//har round mai array mese minimum nikalna hai 
			
			int min = input[i]; // pehle hum aisehi assume karlete hai ki jo 0th index pe hai woh minimum hai
			int minindex = i;  // minimum element ke sath uska index bhi rakh lena chahiye taki swapping kar ske
				
			//ab remaining array mai scan karna padega  so i+1 se end tak har element pe jayenge and har element se compare karenge.
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < min) { // agar next wala element chota hai mere purane minimum ko and uske minIndex ko update kardena chahiye.
					min = input[j];
					minindex = j;
				}
			}
			
			// After first loop I can assume ki min mai minimum element hoga and minIndex mai uss element ka index hoga so muje swap kardena chahiye
			if (minindex != i) { // swap tabhi karenge jab minIndex aur i equal na ho, agar minIndex aur i equal hai means same ek hi element ko swap karre which isn't possible 
				input[minindex] = input[i]; // jo new minimum ka minindex hoga uske place pe purana wala minimum (jo assume kiya tha) usko dal denge
				input[i] = min; //ith position pe humko minimum chahiye tha so old wale ke place pe new min dal denga.
			}
		}
	}

	public static void main(String[] args) {
		int input[] = { 2, 6, 9, 1, 5 };
		selectionSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " "); //output: 1 2 5 6 9 
		}

	}

}

//Working: suppose array is {2,6,9,1,5},
//pehle mai minimum(2) aur uska index(minIndex= 0) rakh lunga, fir next element pe gye, 6 ko minimum se compare karenge
// check karenge 6 minimum se better hai kya, iss case mai better nhi hai to minimum update nhi hona chahiye.
// age badh jayenge 9 ko compare karenge, 9 2 se minimum hai kya, nhi hai to 9 ke sath bhi kuch nhi karna chahiye
// then 2 and 1 ko comprare karenge, isme se 1 chota hai, abhitak jo minimum assume kiye the(2) usse bhi chota element mila hai to hume minimum ko update kardena chahiye
// now my new minimum is 1 then minIndex bhi update ho jana chahiye with index of 1. so minIndex will be 3
// ab 5 ko 1 se compare krte hai, 5 aur 1 mese 1 hi chota hai to hum minimum ko change nhi karenge 
