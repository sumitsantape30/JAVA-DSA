package Maps;

import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {

		
		//"Vehicle V" this statement promises us that V is going to point to something i.e. going to be Vehicle (that vehicle can be anything truck,car etc.)
        // 'v' vehicle ke taraf bhi point kr skti hai and vehicle ke child class kobhi point kr skti hai
		Vehicle v= new Car(100); //that vehicle can be a car
		
		//v.isConvertible(); = can't call isConvertible, coz only thing compiler knows is 'v' is a vehicle, it's going to point towards vehicle but every vehicle doesn't have isConvertible function only car has it.
		//isConvertible sirf car ke pas hai Vehicle ke pas nhi hai so error ayega.
		// v. means it's able to access the functionalities of the vehicle only
		
		// hum sirf vehicle specific chize kr skte hai, subclass specific chize nhi kr skte
		v.print(); // this works, coz vehicle class has a print funtion but 'Car' wala 'print' function run hoga aur agar car print() function nhi hai to woh khudka run karega.(car ka print pehle Vehicle ka print() run karra * bsdk Car class open krke dekh*)
		//car ka print() function call hua coz 'Car' type ka object tha (Vehicle V= new Car(100))
		// so dono ke pas print function tha so call karne mai problem nhi tha, agar car ke pass print nhi hota to woh vehicle wala call krta coz uske pas to tha hi print function

Output:
Vehicle Constructor
Car Constructor
Vehicle Color :null
Vehicle maxSpeed :100
numGears : 100
isConvertible : false

//=================================================================================================================================================================================================================================================================
		
	//Taking an 'n' input from the user.
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		Vehicle v;
		if( n == 0) { //if user is going to give me a zero then I am going to create a car otherwise I am going to create a vehicle
			v= new Car(10);
		}else {
			v= new Vehicle(20);
		}
		v.isCovertible(); // error dega -- compiler ko pta hi nhi hai car banega ki vehicle banegi but compiler doesn't cares woh bas v type ki chize access karne dega baki nhi karne dega, and hum subclass ki properties access nhi kr skte hum vas parent class ki properties access kr skte hai as we wrote Vehicle v
		v.print();
		
	}

}
