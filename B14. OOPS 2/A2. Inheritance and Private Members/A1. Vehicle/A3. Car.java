package Maps;

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
       //print function car mai bhi hai aur vehicle mai bhi, 
        //agar humne car mai print() call kiya to pehle woh car function mai check karega ki waha print() function hai kya, agar car mai nhi hua to uske parent(vehicle) ke pas jayenge
        
       // c.printCar(); //printCar ko print() change kiya car class mai
        
	}

}
