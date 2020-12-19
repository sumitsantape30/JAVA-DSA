package Maps;

public class VehicleUse {

	public static void main(String[] args) {

		Vehicle v= new Vehicle(); //jab mai yeh object create kar rha hu to vehicle ka constructor call hoga.
		// Output: Vehicle Constructor
		
		//hum jab car banayenge to car ke andar vehicle bhi banhega hi.
		//jab hum derived class ka constructor call krte hai (means jab hum derived class ka object bana rhe) to yeh parent class object bhi banata hai so parent kabhi constructor call hota hai.
		Car c= new Car(); //jab mai yeh object create kar rha hu to car ka constructor call hoga.
		//Output:  Vehicle Constructor
    	//         Car Constructor
        
       
	}

}
