package Maps;

public class VehicleUse {

	public static void main(String[] args) {

		//Vehicle v= new Vehicle(10); //jab mai yeh object create kar rha hu to vehicle ka constructor call hoga.
		// Output: Vehicle Constructor
		
      //when you created car object this vehicle object was also getting created, mere isme automatic vehicle create ho rha hai to woh default constructor( new vehicle()) call karneki koshish kr rha hai
		// since vehicle object is getting created but humne wahaka default constructor gayab kardiya
		Car c= new Car(100); //jab mai yeh object create kar rha hu to car ka constructor call hoga.
	   //Output:Vehicle Constructor
	   //Car Constructor
		
		//Point to remember:
		// 1. derived class ka constructor call krte hai to pehle derived class ka then super() class ka bhi constructor call hota hai.
		// 2. default constructor hai to thik hai, default constructor nhi hai to tumhe specifically call karna padega super() keyword use krke. 
	}

}
