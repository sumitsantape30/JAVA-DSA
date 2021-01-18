
public class CheckSorted2 {

//Approach 2
	//iss Approch mai pehle n-1 size ki problem solve karne se pehle hum pehle do elements ko compare krte hai, 
	//agar yahi dono arranged nhi honga to n-1 size ki problem ko solve karne ki jarurat hi nhi hai coz humare pas pehlese result hoga that's false
   public static boolean checkSorted_2(int input[]){
		
		if(input.length <= 1){
			return true;
		}
		
		//checking ki first two elements arranged hai ya nhi, agar nhi hue to false return kar denge.
		if(input[0] > input[1]){ //agar 0th element 1st wale se bada hua to I can straight away false return kar skte
			return false;
		}
		
		//agar first two elements properly arranged hai to hume baki array ko check karna hai n-1 wale array ka kam karna hai.
		int smallInput[] = new int[input.length - 1];
		for(int i = 1; i < input.length; i++){
			smallInput[i - 1] = input[i];
		}
		
		boolean smallAns = checkSorted_2(smallInput);
		return smallAns;
//		if(smallAns){
//			return true;
//		}else{
//			return false;
//		}

}

public static void main(String[] args) {
		int input[] = {1,2,3};
		System.out.println(checkSortedBetter(input));

	}
}
