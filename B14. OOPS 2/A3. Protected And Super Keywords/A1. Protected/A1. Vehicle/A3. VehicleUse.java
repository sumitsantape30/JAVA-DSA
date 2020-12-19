package Vehicle;

public class VehicleUse {

	public static void main(String[] args) {

		Vehicle v= new Vehicle();
		v.color= "pink";
		v.setmaxSpeed(77); //maxSpeed set karne keliye setmaxSpeed call krke value pass krre coz setmaxSpeed function public hai and maxspeed data memeber private hai
		v.print(); //vehicle ke andar jo print function hai woh call hoga
		
		Car c= new Car();
		c.color= "Blue";
		c.numGears= 10; //yaha numGears access kr pa rhe coz woh default hai so same package mai access set kr pare
        c.setmaxSpeed(88);
		c.color= "Blue"; //hum vehicle ki property Car keliye use karre coz car extends Vehicle
       
		c.print(); // agar print() function Car mai nhi hota to woh Vehicle wala print() function call krti.
       
	}

}
