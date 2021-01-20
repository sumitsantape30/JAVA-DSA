package final_keyword;

/* Abstract classes and methods are when the parent class has a named method, but need its child class(es) to fill out the tasks. 
An abstract class is a class that contains at least one abstract method. An abstract method is a method that is declared, but not implemented in the code.
*/


   //4. humare class mai ek function hai jo incomplete hai(isMotorized function), so humari class complete nhi hai so tumhe class level pe bhi bolna padega ki jo vehicle class hai woh abstract hai 
public abstract class Vehicle { //3. yeh class abstract kiya coz iske andar ek abstract function hai
	protected String color;
	private int maxSpeed;
	
	
	//1. hum yeh function banana chahte hai but the problem is we cannot really answer this, so hum is function ko declare krke chhod skte hai, body mat likho({ }).
	//2.mai yeh function yahape define nhi kr skta coz muje nhi pta jo current vehicle hai woh motorised hai ya nhi, jo meri subclasses (car,bicycle, boat) hai woh answer kr skti hai
	//3.agar yeh function yahape intialised nhi kiya to car ki marzi hogi isko define karna hai to kare ya na kare, but yaha initialse kiya to we're forcing other subclasses(car,boat) to make this function, unko define karna padega
	public abstract boolean isMotorized(); //humne yeh function banaya nhi hai, this is just an abstract concept we've created ki ha yr aisa kuch function hona chahiye
	
	//5. ek aur incomplete function 
	public abstract String getCompany();
	
	
	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("Vehicle Constructor");
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public  void print() { 
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle Speed : " + maxSpeed);
	}
}
