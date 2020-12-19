package Vehicle_temp;

import Vehicle.Vehicle;

public class Truck extends Vehicle{

	int maxLoadingCapacity;
	
	public void print() {
		System.out.println("maxLoadingCapacity : "+maxLoadingCapacity);
		System.out.println("color : "+color); //jo data memeber Vehicle mai hai jo dusre package mai hai usko access kr pa rhe coz woh ab protected hai
	    System.out.println("Speed : "+getmaxSpeed()); //yeh function mera public hai so access kr skte hai
	   //getmaxSpeed through ke jake maine maxSpeed access kiya.
	}
}
