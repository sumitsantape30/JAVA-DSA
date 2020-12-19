package Maps;

public class Vehicle {
  
	protected String color; 
	private int maxSpeed; 
	
	//humne vehicle ke anadr naya constructor banaya and default constructor (public vehicle()) gayab hogya, bina parameters wala constructor gayab hogya.
	public Vehicle( int maxSpeed) {
		this.maxSpeed= maxSpeed;
		System.out.println("Vehicle Constructor");
	}
	
	public int getmaxSpeed() {
		return maxSpeed;
	}
	
	public void setmaxSpeed( int maxSpeed) {
		this.maxSpeed= maxSpeed;
	}
	
	public void print() {
		System.out.println("Vehicle Color :"+color);
		System.out.println("Vehicle maxSpeed :"+maxSpeed); 
	}
}
