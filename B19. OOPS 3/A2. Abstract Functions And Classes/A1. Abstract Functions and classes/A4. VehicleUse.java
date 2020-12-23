package final_keyword;

import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {

		//Vehicle v= new Vehicle(); //1. error ayega- coz hum vehicle type ka object nhi bana skte coz vehicle is a incomplete class.(agar uska object banaya to usme ek incomplete function rakha hua hai)
		
		Vehicle v= new Car(1,2); //yeh hum kr skte hai coz jo object bana hai woh Car tye ka bana hai. (V is reference which is pointing towards Car)
		//car class ko abstract krne ke bad yaha error ayega coz woh incomplete hai uska object nhi bna skte.
		
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
	
		if (n == 0) {
			v = new Car(10,20); //car class ko abstract krne ke bad yaha error ayega coz woh incomplete hai uska object nhi bna skte.
		} else {
			//v = new Vehicle(20);//2.yahape bhi erroe ayega coz vehicle type ka object banare.
		}
		//v.isConvertible();
		v.print();
		

	}

}
