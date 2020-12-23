package final_keyword;

import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {

		
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
	
		Vehicle v;
		if (n == 0) {
			v = new Car(10,20);
		} else {
			v = new Vehicle(20);
		}
		//v.isConvertible();
		v.print();
		

	}

}
