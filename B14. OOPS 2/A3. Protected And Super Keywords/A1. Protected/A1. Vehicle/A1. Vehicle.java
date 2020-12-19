package Maps;

public class Vehicle {
    //Vehicle pehle package friendly tha
	// maine color ko protected kardiya isliye mai color ko Truck mai access kr skta hu
	protected String color; //protected karne se I can access color in other package also
	private int maxSpeed; 
	
	public int getmaxSpeed() {
		return maxSpeed;
	}
	
	public void setmaxSpeed( int maxSpeed) {
		this.maxSpeed= maxSpeed;
	}
	
	public void print() {
		System.out.println("Vehicle Color :"+color); //Output: null
		System.out.println("Vehicle maxSpeed :"+maxSpeed); // Color: 0
	}
}

