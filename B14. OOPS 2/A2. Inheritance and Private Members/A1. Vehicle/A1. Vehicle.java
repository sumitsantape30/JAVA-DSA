package OOPS2;

public class Vehicle {

	String color;
	private int maxSpeed; //maxSpeed ko private kiya to maxSpeed ko iss class ke bahar access nhi krskte so iss class ke bahar bhi access karwani ke indirect way is create getters and setters
	
	//Car directly maxSpeed ko access nhi kr skti coz private hai, but car getmaxSpeed ko call kr skti hai aur fir wahase getmaxSpeed maxSpeed ko access kr skta hai. 
	
	
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
