package final_keyword;

   //agar meri class final hai to iss class ko koi inherit nhi kr skta
public final class Vehicle {
	protected String color;
	private int maxSpeed;
	
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
	
	//vehicle class ne print() function bahaya hai and car class ne bhi print() function banaya hai so effectively car class ne vehicle ke iss function ko override kardiya.
    //car was able to override this function but jaisehi print() ko final kardiya, car class k print() mai error aajayega.
	public final void print() { //yeh function ab final ho chuka hai isko override nhi kr skte ab, koi bhi subclass exact signature ka function nhi bana skti
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle Speed : " + maxSpeed);
	}
}
