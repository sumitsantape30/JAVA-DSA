
public class MinimumCostPathDP {

	public static int minCostPathDP(int arr[][]) { //input will be array
		
		//sabse pehla kam humara storage array create karna hai
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];

		//Basecase ke corresponding enrties khud fill krdenge
		//Basecase ke corresponding answer/entry humko already answer pta hai , last cell ki wahi hogi cost
		storage[m - 1][n - 1] = arr[m - 1][n - 1];
		
		//*description keliye open book*
		// Last row keliye . Last cell ke left mai ja rhe hai aur values calculate kr rhe hai
		for (int j = n - 2; j >= 0; j--) { // n-1 wala cell last hai so n-2 wale cell se start karenge
			storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j]; //j+1 will be isko jo just right mai cell hai ussa age tak ka path hai woh plus(+) iss cell ki khudki value
		}
		
		// Last Column ko fill karne keliye 
		for (int i = m - 2; i >= 0; i--) {
			storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1]; //hum last column mai last cell se upar ki direction mai move kr rhe hai
		}

		//last row and last column fill krne kebad bich mai jo cells honge un sab cells keliye teeno values hongi[(i+1,j), (i+1,j+1), (i, j+1)]. Last row last column fill krne ke bad left order mai move krte hai aur ek ek cell ko fill krte hai
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				// storage i,j ki value will be the cost of travelling form i,j till the end and woh cost hum woh teen options ke help se nikalte hai, and teeno options mese jo minimum hoga woh rakh lenge and minimum mai hum current cell ki bhi value add karenge. Minimum of three paths plus current cell ki value will give me storage[i][j] ki value.
				storage[i][j] = arr[i][j]
						+ Math.min(storage[i][j + 1], Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
			}
		}
		//so Storage[i][j] ki value jab humare pas aajayegi now I have to return result and result 0,0 cell pe hoga. matlab 0,0 se end tak jane ki jo cost return karenge
		return storage[0][0];
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 1 }, { 4, 5, 2 }, { 7, 8, 9 } };
		System.out.println(minCostPathDP(arr));

	}

}

Output:
13
