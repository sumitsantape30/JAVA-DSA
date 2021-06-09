package Maps;

public class VehicleUse {

	public static void main(String[] args) {

		Vehicle v= new Vehicle(); //jab mai yeh object create kar rha hu to vehicle ka constructor call hoga.
		// Output: Vehicle Constructor
		
		//hum jab car banayenge to car ke andar vehicle bhi banhega hi.
		//jab hum derived class ka constructor call krte hai (means jab hum derived class ka object bana rhe) to yeh parent class ka object bhi banata hai so parent kabhi constructor call hota hai.
		Car c= new Car(5); //jab mai yeh object create kar rha hu to car ka constructor call hoga.
		//Output:  Vehicle Constructor
    	//                 Car Constructor
        
       
//so keep in mind, jab derived class ka constrcutor call hota hai to super class kabhi consturctor call hota hai, pehle super class ka hota hai then derived class ka. 
// second thing is, agar default constructor hai to thik hai agar default constructor nhi hai to tumhe specifically constructor call karna padega super keyword use krke. ANd constructor ke andar aatehi yeh line sabse pehle honi chahiye
		
	}

}
