package Maps;

public class VehicleUse {

	public static void main(String[] args) {

		Vehicle v= new Vehicle();
		v.print();
		
		Car c= new Car();
		c.numGears= 10; //yaha numGears access kr pa rhe coz woh default hai so same package mai access set kr pare
                c.color= "Blue"; //hum vehicle ki property Car keliye use karre coz car extends Vehicle
                c.print(); //hum vehicle ke functions bhi apne liye use kr skte hai
	}
}

Output:

Vehicle Color :null
Vehicle Color :0
Vehicle Color :Blue
Vehicle Color :0
